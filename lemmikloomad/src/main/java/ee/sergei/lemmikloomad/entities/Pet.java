package ee.sergei.lemmikloomad.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="pet")
@Data
public class Pet {

    @Id
    @Column(name = "pet_name")
    private String petName;

    @Column(name = "pet_weight")
    private double petWeight;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_name", nullable = true)
    private Owner owner;
}
