package sergei.webshop.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sergei.webshop.dto.OrderDTO;
import sergei.webshop.dto.OrderRowsDTO;
import sergei.webshop.dto.everypay.EverypayData;
import sergei.webshop.dto.everypay.EverypayResponse;
import sergei.webshop.entity.*;
import sergei.webshop.repository.OrderRepository;
import sergei.webshop.repository.OrderRowRepository;
import sergei.webshop.repository.PersonRepository;
import sergei.webshop.repository.ProductRepository;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRowRepository orderRowRepository;

    @Override
    public ResponseEntity<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();

        for (Order order : orders) {
            OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
            orderDTOs.add(orderDTO);
        }

        return new ResponseEntity(orderDTOs, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<String> createPayOrder(OrderDTO orderDTO) throws Exception {
        double totalSum = calculateTotalSum(orderDTO.getOrderRows());

        Order order = new Order();
        order.setCreationDate(new Date());
        order.setPaymentState(orderDTO.getPaymentState());
        order.setTotalSum(totalSum);

        Order savedOrder = orderRepository.save(order);

        List<OrderRowsDTO> orderRowsDTOS = orderDTO.getOrderRows();

        if (orderRowsDTOS != null && !orderRowsDTOS.isEmpty()) {
            List<OrderRow> orderRows = new ArrayList<>();

            for (OrderRowsDTO orderRowsDTO : orderRowsDTOS) {
                Product product = productRepository.findById(orderRowsDTO.getProduct().getId()).orElse(null);
                if (product == null) {
                    throw new IllegalArgumentException("Product with the given id does not exist.");
                }

                OrderRow orderRow = new OrderRow();
                orderRow.setProduct(product);
                orderRow.setQuantity(orderRowsDTO.getQuantity());
                orderRow.setOrders(savedOrder);
                orderRows.add(orderRow);
                orderRowRepository.save(orderRow);

                double subtotal = product.getPrice() * orderRowsDTO.getQuantity();
                totalSum += subtotal;
            }

            savedOrder.setOrderRows(orderRows);
        }

        savedOrder.setTotalSum(totalSum);

        orderRepository.save(savedOrder);

        String paymentUrl = makePayment(totalSum, savedOrder.getId());
        return new ResponseEntity<>(paymentUrl, HttpStatus.CREATED);
    }

    public String makePayment(double totalSum, Long orderId) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://igw-demo.every-pay.com/api/v4/payments/oneoff";

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Basic ZTM2ZWI0MGY1ZWM4N2ZhMjo3YjkxYTNiOWUxYjc0NTI0YzJlOWZjMjgyZjhhYzhjZA==");
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        EverypayData body = new EverypayData();
        body.setApi_username("e36eb40f5ec87fa2");
        body.setAccount_name("EUR3D1");
        body.setAmount(totalSum);
        body.setOrder_reference(orderId.toString());
        body.setNonce("adasdsad3121" + ZonedDateTime.now() + Math.random());
        body.setTimestamp(ZonedDateTime.now().toString());
        body.setCustomer_url("https://maksmine.web.app/makse");

        HttpEntity<EverypayData> httpEntity = new HttpEntity<>(body, headers);
        ResponseEntity<EverypayResponse> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, EverypayResponse.class);
        return response.getBody().getPayment_link();
    }

    private double calculateTotalSum(List<OrderRowsDTO> orderRows) throws Exception {
        double totalSum = 0;

        for (OrderRowsDTO order : orderRows) {
            Product product = productRepository.findById(order.getProduct().getId()).orElse(null);
            if (product == null) {
                throw new IllegalArgumentException("Product with the given id does not exist.");
            }
            double subtotal = product.getPrice() * order.getQuantity();
            totalSum += subtotal;
        }

        return totalSum;
    }


    @Override
    public ResponseEntity<OrderDTO> deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDTO> getOrder(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }


}
