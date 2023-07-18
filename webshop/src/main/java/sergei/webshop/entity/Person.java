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

    public Person(String personalCode, String firstName, String lastName, String password) {
        this.personalCode = personalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String personalCode;
    private String firstName;
    private String lastName;
    private String password;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ContactData contactData;

}
