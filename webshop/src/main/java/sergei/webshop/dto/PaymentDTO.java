package sergei.webshop.dto;

import jakarta.persistence.Column;
import lombok.Data;
import sergei.webshop.entity.PaymentStatus;

@Data
public class PaymentDTO {
    private Long nonce;
    double amount;
    OrderDTO orderReference;
    String timestamp;
    String customerUrl;
    PaymentStatus paymentStatus;
}
