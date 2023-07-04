package ee.sergei.lemmikloomad.controller;
import ee.sergei.lemmikloomad.entities.Pet;
import ee.sergei.lemmikloomad.service.PetService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


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

/*    @GetMapping("pet1/add") // localhost:8080/pet/add?name=Kass&weight=5000
    public List<Pet> addPet(
            @RequestParam("name") String name,
            @RequestParam("weight") double weight
    ) {
        return petService.addPet(name, weight);
        *//*Pet pet = new Pet(name, weight);
        petRepository.save(pet);
        return petRepository.findAll();*//*
    }*/

/*
    @GetMapping("owner/add") // localhost:8080/owner/add?name=Omanik
    public List<Owner> addPet(
            @RequestParam String name
    ) {

        Owner owner = new Owner();
        owner.setName(name);
        // add to db
        ownerRepository.save(owner);
        // return all pets

        return ownerRepository.findAll();


    }

    @GetMapping("owner/add-pet") // localhost:8080/owner/add-pet?owner=Omanik&pet=Kass
    public Owner addPetToOwner(
            @RequestParam String owner,
            @RequestParam String pet
    ) {

        Owner ownerFound = ownerRepository.findById(owner).get();
        Pet petFound = petRepository.findById(pet).get();
//        ownerFound.setPets().add(petFound);

        // add to db & return
        return ownerRepository.save(ownerFound);
    }
*/

}
