package sergei.webshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders") // PostgreSQL "order" & "user" are reserved words
@SequenceGenerator(name = "seq", initialValue = 20230715, allocationSize = 1)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "orderId")
    private Long id;

    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "paymentState")
    private PaymentStatus paymentState;

    @Column(name = "totalSum")
    private double totalSum;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderRow> orderRows;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    @OneToMany(mappedBy = "orderReference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;

}
