package sergei.webshop.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sergei.webshop.dto.OmnivaPM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ParcelMachineController {
    // https://www.omniva.ee/locations.json


    @GetMapping("parcel-machines/{country}")
    public List<OmnivaPM> getParcelMachines(
            @PathVariable() String country
    ) {
        String finalCountry = country.toUpperCase();

        RestTemplate restTemplate = new RestTemplate(); //@Bean @Autowired
        ResponseEntity<OmnivaPM[]> response = restTemplate.exchange(
                "https://www.omniva.ee/locations.json",
                HttpMethod.GET,
                null,
                OmnivaPM[].class
        );

        List<OmnivaPM> result = Arrays.stream(response.getBody())
                .filter(e -> e.getA0_NAME().equals(finalCountry))
                .toList();

/*        List<OmnivaPM> result2 = new ArrayList<>();
        for(OmnivaPM o: response.getBody()) {
            if(o.getA0_NAME().equals(finalCountry)) {
                result2.add(o);
            }
        }*/

        return result;
    }
}