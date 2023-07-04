package ee.sergei.lemmikloomad.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PetDTO {
    private String name;
    private double weight;
}
