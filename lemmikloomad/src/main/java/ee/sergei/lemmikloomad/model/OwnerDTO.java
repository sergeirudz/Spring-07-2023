package ee.sergei.lemmikloomad.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OwnerDTO {

    private String name;
    private PetDTO pet;
}
