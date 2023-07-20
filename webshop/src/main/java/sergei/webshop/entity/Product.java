package sergei.webshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "productId", nullable = false, unique = true)
    private Long id;

    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Column(name="price", nullable = false)
    private double price;

    @Column(name="image")
    private String image;

    @Column(name="active", nullable = false)
    private boolean active;

    @Column(name="description")
    private String description;

    @Column(name="stock", nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    public void setCategory(Category category) {
        this.category = category;
    }
}
