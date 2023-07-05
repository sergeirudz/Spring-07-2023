package ee.sergei.lemmikloomad.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Table(name="clinic")
@Getter
@Setter
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "clinic_name")
    private String clinicName;

//    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinic")
    private Set<Pet> pets;
}
