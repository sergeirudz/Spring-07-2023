package ee.sergei.lemmikloomad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class StringController {

    @GetMapping("h1")
    public String helloWorld() {
        return "Hello World at " + new Date();
    }

    @GetMapping("h1/{name}")
    public String helloName(@PathVariable("name") String name) {
        return "Hello " + name;
    }

    @GetMapping("h1/{name}/{telephone}/{address}/{height}/{weight}") // http://localhost:8080/h1/nimi/55555/aadress/150cm/50kg
    public String helloPerson(
            @PathVariable("name") String name,
            @PathVariable("telephone") String telephone,
            @PathVariable("address") String address,
            @PathVariable("height") String height,
            @PathVariable("weight") String weight
    ) {
        return "Name: " + name + "\n" +
                "Telephone: " + telephone + "\n" +
                "Address: " + address + "\n" +
                "Height: " + height + "\n" +
                "Weight: " + weight;
    }

    @GetMapping("hello") // http://localhost:8080/hello?name=nimi&telephone=55555&address=aadress&height=150cm&weight=50kg
    public String helloPerson2(
            @RequestParam("name") String name,
            @RequestParam("telephone") String telephone,
            @RequestParam("address") String address,
            @RequestParam("height") String height,
            @RequestParam("weight") String weight
    ) {
        return "Name: " + name + "\n" +
                "Telephone: " + telephone + "\n" +
                "Address: " + address + "\n" +
                "Height: " + height + "\n" +
                "Weight: " + weight;
    }
}
