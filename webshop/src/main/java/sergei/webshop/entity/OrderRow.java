package sergei.webshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class OrderRow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderRowId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order orders;
}
