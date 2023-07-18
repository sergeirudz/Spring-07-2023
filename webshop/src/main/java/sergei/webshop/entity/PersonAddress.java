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
public class PersonAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personAddressId")
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "county")
    private String county;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "postalIndex")
    private String postalIndex;
}
