package sergei.webshop.service;

import org.springframework.http.ResponseEntity;
import sergei.webshop.dto.PaymentDTO;

public interface PaymentService {
    String payOrder(Long id) throws Exception;

    ResponseEntity<Boolean> checkPayment(String paymentReference);
}
