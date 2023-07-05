package ee.sergei.lemmikloomad.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="pet")
@Data
public class Pet {

    @Id
    @Column(name = "pet_name")
    private String petName;

    @Column(name = "pet_weight")
    private double petWeight;

    @ManyToOne
    @JoinColumn(name = "owner_name", nullable = true)
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "clinic_name", nullable = true)
    private Clinic clinic;
}
