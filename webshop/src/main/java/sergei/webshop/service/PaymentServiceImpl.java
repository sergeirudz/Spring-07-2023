package sergei.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import sergei.webshop.dto.PaymentDTO;
import sergei.webshop.dto.everypay.EverypayData;
import sergei.webshop.dto.everypay.EverypayResponse;
import sergei.webshop.entity.Order;
import sergei.webshop.entity.Payment;
import sergei.webshop.entity.PaymentStatus;
import sergei.webshop.repository.OrderRepository;
import sergei.webshop.repository.PaymentRepository;

import java.time.ZonedDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Value("${everypay.url}")
    String url;

    @Value("${everypay.token")
    String token;

    @Value("${everypay.customer-url}")
    String customerUrl;

    @Value("${everypay.username}")
    String everyPayUsername;

    @Value("${everypay.account-name}")
    String everyPayAccountName;

    @Override
    public String payOrder(Long id) throws Exception {

        Order orderFound = orderRepository.findById(id).get();
        if (orderFound == null) {
            throw new Exception("Order not found");
        }

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Basic " + token);
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);


        Payment temporaryPayment = new Payment();
        temporaryPayment.setAmount(orderFound.getTotalSum());
        temporaryPayment.setOrderReference(orderFound);
        temporaryPayment.setPaymentStatus(PaymentStatus.INITIAL);
        temporaryPayment.setCustomerUrl(customerUrl);
        temporaryPayment.setTimestamp(ZonedDateTime.now().toString());

        Payment savedPayment = paymentRepository.save(temporaryPayment);

        EverypayData body = new EverypayData();
        body.setApi_username(everyPayUsername);
        body.setAccount_name(everyPayAccountName);
        body.setAmount(savedPayment.getAmount());
        body.setOrder_reference(String.valueOf(orderFound.getId()));
        body.setNonce(String.valueOf(savedPayment.getNonce()));
        body.setTimestamp(temporaryPayment.getTimestamp());
        body.setCustomer_url(temporaryPayment.getCustomerUrl());

        HttpEntity<EverypayData> httpEntity = new HttpEntity<>(body, headers);

        ResponseEntity<EverypayResponse> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, EverypayResponse.class);

        return response.getBody().getPayment_link();

    }
}
