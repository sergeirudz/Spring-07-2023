package ee.sergei.lemmikloomad.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
public class OwnerDTO implements Serializable {

    private Long id;
    private String ownerName;
    private PetDTO pet;
}
