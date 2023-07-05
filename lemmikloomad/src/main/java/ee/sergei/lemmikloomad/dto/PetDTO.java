package ee.sergei.lemmikloomad.dto;
import lombok.Data;
import java.io.Serializable;

@Data
public class PetDTO implements Serializable {
    private String petName;
    private double petWeight;
}
