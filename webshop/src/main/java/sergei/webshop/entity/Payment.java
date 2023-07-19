package sergei.webshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nonce")
    private Long nonce;

    @Column(name = "amount", nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order orderReference;

    @Column(name = "timestamp", nullable = false)
    private String timestamp;

    @Column(name = "customerUrl", nullable = false)
    private String customerUrl;

    @Column(name = "paymentStatus", nullable = false)
    private PaymentStatus paymentStatus;

}
