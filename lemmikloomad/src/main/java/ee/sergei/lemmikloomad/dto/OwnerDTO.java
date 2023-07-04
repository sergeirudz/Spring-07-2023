package ee.sergei.lemmikloomad.dto;

import lombok.Builder;
import lombok.Data;


@Data
public class OwnerDTO {

    private String name;
    private PetDTO pet;
}
