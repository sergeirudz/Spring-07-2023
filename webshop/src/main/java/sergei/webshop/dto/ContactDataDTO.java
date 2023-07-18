package sergei.webshop.dto;

import lombok.Data;

@Data
public class ContactDataDTO {

    private String email;
    private String phone;
    private AddressDTO address;
}