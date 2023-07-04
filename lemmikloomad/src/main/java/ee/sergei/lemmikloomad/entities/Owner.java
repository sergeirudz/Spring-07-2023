package ee.sergei.lemmikloomad.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Table(name="owner")
@Getter
@Setter
public class Owner {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "owner_name")
    private String ownerName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
//    @JoinColumn(name = "pet_name", nullable = true)
    private Set<Pet> pets;

}
