package sergei.webshop.dto;

import lombok.Data;
import sergei.webshop.entity.ContactData;

@Data
public class PersonDTO {

    private Long id;
    private String personalCode;
    private String firstName;
    private String lastName;
    private String password;
    private ContactDataDTO contactData;
}
