package ee.sergei.lemmikloomad.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

//@Builder
@Data
public class PetDTO implements Serializable {
    private String petName;
    private double petWeight;
}
