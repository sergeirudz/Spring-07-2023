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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personContactDataId")
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone") // maybe unique = true
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "personAddressId")
    private PersonAddress personAddress;

}
