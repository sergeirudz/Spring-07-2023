package sergei.phonesaleforward.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ProductPM{
    @JsonProperty("products")
    public ArrayList<Product> products;
    @JsonProperty("total")
    public int total;
    @JsonProperty("skip")
    public int skip;
    @JsonProperty("limit")
    public int limit;
}
