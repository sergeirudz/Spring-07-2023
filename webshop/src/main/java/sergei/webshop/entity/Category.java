package sergei.webshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "categoryId", nullable = false, unique = true)
    private Long id;

    @Column(name="name", nullable = false, unique = true)
    private String name;
}
