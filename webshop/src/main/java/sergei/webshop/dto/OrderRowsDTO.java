package sergei.webshop.dto;

import lombok.Data;

@Data
public class OrderRowsDTO {

    private Long id;
    private ProductDTO product;
    private int quantity;

}
