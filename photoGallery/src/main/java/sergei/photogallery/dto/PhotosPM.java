package sergei.photogallery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhotosPM {
    @JsonProperty("albumId")
    public int albumId;
    @JsonProperty("id")
    public int id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("url")
    public String url;
    @JsonProperty("thumbnailUrl")
    public String thumbnailUrl;

}
