package sergei.webshop.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import sergei.webshop.dto.everypay.EverypayData;
import sergei.webshop.dto.everypay.EverypayResponse;

import java.time.ZonedDateTime;

public class OrderController {

    // KODUS: Kõikide võtmine, Lisamine???, Kustutamine, Ühe võtmine, Muutmine???
    //                      korraga tuleb lisada OrderRow

    @GetMapping("payment/{sum}")
    public String pay(@PathVariable double sum,
                      @RequestBody String orderReference

                      ) {


        RestTemplate restTemplate = new RestTemplate();

        String url = "https://igw-demo.every-pay.com/api/v4/payments/oneoff";


        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Basic ZTM2ZWI0MGY1ZWM4N2ZhMjo3YjkxYTNiOWUxYjc0NTI0YzJlOWZjMjgyZjhhYzhjZA==");
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        EverypayData body = new EverypayData();
        body.setApi_username("e36eb40f5ec87fa2");
        body.setAccount_name("EUR3D1");
        body.setAmount(sum);
        body.setOrder_reference("asd" + Math.random() * 11); // TODO save to DB order, then get order reference then make the call.
        body.setNonce("asd123" + ZonedDateTime.now().toString() + Math.random());
        body.setTimestamp(ZonedDateTime.now().toString());
        body.setCustomer_url("https://maksmine.web.app/makse");


        HttpEntity<EverypayData> httpEntity = new HttpEntity<>(body, headers);

        ResponseEntity<EverypayResponse> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, EverypayResponse.class);

        return response.getBody().getPayment_link();
    }
}