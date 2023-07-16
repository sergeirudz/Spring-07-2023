package sergei.phonesaleforward.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Product {
    @JsonProperty("_id")
    public int id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("description")
    public String description;
    @JsonProperty("price")
    public int price;
    @JsonProperty("discountPrice")
    public double discountPercentage;
    @JsonProperty("rating")
    public double rating;
    @JsonProperty("stock")
    public int stock;
    @JsonProperty("brand")
    public String brand;
    @JsonProperty("category")
    public String category;
    @JsonProperty("image")
    public String thumbnail;
    @JsonProperty("images")
    public ArrayList<String> images;
}
