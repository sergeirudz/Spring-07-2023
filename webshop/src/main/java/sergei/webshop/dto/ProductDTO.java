package sergei.webshop.dto;

import lombok.Data;


@Data
public class ProductDTO {

    private Long id;
    private String name;
    private double price;
    private String image;
    private boolean active;
    private String description;
    private int stock;
    private CategoryDTO category;

}
