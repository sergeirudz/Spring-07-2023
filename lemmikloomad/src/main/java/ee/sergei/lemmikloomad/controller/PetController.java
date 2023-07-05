package ee.sergei.lemmikloomad.controller;
import ee.sergei.lemmikloomad.entities.Pet;
import ee.sergei.lemmikloomad.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PetController {
    private final PetService petService;

    @GetMapping("pet/add") // localhost:8080/pet/add?name=Kass&weight=5000
    public List<Pet> addPet(
            @RequestParam("name") String name,
            @RequestParam("weight") double weight
    ) {
        return petService.addPet(name, weight);
    }

    @GetMapping("pet/all")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }


}
