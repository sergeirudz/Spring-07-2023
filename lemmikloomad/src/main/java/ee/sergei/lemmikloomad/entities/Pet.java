package ee.sergei.lemmikloomad.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

    @Id
    private String name;
    private double weight;

}
