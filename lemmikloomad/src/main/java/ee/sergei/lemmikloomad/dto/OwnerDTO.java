package ee.sergei.lemmikloomad.dto;
import lombok.Data;
import java.io.Serializable;
@Data // @NoArgsConstructor, @AllArgsConstructor, @Getter, @Setter
public class OwnerDTO implements Serializable {

    private Long id;
    private String ownerName;
    private PetDTO pet;

    private String personalCode;
}
