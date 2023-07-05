package ee.sergei.lemmikloomad.dto;
import ee.sergei.lemmikloomad.entities.Pet;
import lombok.Data;
import java.io.Serializable;
import java.util.Set;

@Data
public class ClinicDTO implements Serializable {
    private Long id;
    private String clinicName;
    private Set<Pet> pets;
}
