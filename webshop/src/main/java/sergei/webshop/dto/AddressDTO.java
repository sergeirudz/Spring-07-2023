package sergei.webshop.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private String country;
    private String county;
    private String street;
    private String number;
    private String postalIndex;
}
