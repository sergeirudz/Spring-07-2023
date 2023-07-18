package sergei.webshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personId")
    private Long id;

    @Column(name = "personalCode", unique = true)
    private String personalCode;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "personContactDataId")
    private PersonContactData personContactData;

}
