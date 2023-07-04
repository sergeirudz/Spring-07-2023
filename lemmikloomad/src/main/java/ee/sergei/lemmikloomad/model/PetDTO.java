package ee.sergei.lemmikloomad.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PetDTO {
    private String name;
    private double weight;
}
