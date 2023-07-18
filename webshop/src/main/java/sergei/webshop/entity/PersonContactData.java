package sergei.webshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonContactData {

    public PersonContactData(String email, String phone, PersonAddress personAddress) {
        this.email = email;
        this.phone = phone;
        this.personAddress = personAddress;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;

    @Column()
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private PersonAddress personAddress;

}
