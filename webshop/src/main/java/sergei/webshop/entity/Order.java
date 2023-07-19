package sergei.webshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders") // PostgreSQL "order" & "user" are reserved words
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long id;

    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "paymentState")
    private String paymentState; // SHOULD THIS BE ENUM?

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
