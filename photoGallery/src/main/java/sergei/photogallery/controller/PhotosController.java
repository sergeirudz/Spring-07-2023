package sergei.photogallery.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sergei.photogallery.dto.PhotosPM;

@RestController
public class PhotosController {
    @GetMapping("/photos") // http://localhost:8080/photos
    public PhotosPM[] photos() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PhotosPM[]> response = restTemplate.getForEntity(
                "https://jsonplaceholder.typicode.com/photos",
                PhotosPM[].class);
       return response.getBody();
    }
}
