package ee.sergei.lemmikloomad.controller;

import ee.sergei.lemmikloomad.dto.OwnerDTO;
import ee.sergei.lemmikloomad.dto.PetDTO;
import ee.sergei.lemmikloomad.entities.Owner;
import ee.sergei.lemmikloomad.entities.Pet;
import ee.sergei.lemmikloomad.service.OwnerService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping("owner/add") // localhost:8080/owner/add?name=Omanik
    public List<Owner> addOwner(
            @RequestParam("name") String name) {
        return ownerService.addOwner(name);
    }

    @GetMapping("owner/personalCode/{personalCode}")
    public Owner findOwnerByPersonalCode(
            @PathVariable("personalCode") String personalCode) {
        return ownerService.findOwnerByPersonalCode(personalCode);
    }

    @GetMapping("owner/all") // ERROR: localhost:8080/owner/all
    public List<Owner> getAllOwners() {

        /* USING MODELMAPPER

        ModelMapper modelMapper = new ModelMapper();
        List<OwnerDTO> ownerDTOs = new ArrayList<>();

        for(Owner o : ownerService.getAllOwners()) {
            OwnerDTO ownerDTO = modelMapper.map(o, OwnerDTO.class);
            ownerDTOs.add(ownerDTO);
        }
* */
        return ownerService.getAllOwners();


  /*      List<Owner> owners = ownerService.getAllOwners();
        List<OwnerDTO> ownerDTOs = new ArrayList<>();
        for(Owner o : owners) {
            OwnerDTO ownerDTO = new OwnerDTO();
            ownerDTO.setOwnerName(o.getOwnerName());
            ownerDTOs.add(ownerDTO);
        }
            return ownerDTOs;*/

    }

    @GetMapping("owner/add-pet")
    public void addPetToOwner(
            @RequestParam("ownerName") String ownerName,
            @RequestParam("petName") String petName
    ) {
         ownerService.addPetToOwner(ownerName, petName);
    }


    @GetMapping("owner/{id}/pets") // localhost:8080/owner/1/pets
    public int getNumberOfPetsForOwner(
            @PathVariable("id") Long id
    ) {
        return ownerService.getNumberOfPetsForOwner(id);
    }

    // get the heaviest pet for one owner
    @GetMapping("owner/{id}/heaviest-pet") // localhost:8080/owner/1/heaviest-pet
    public PetDTO getHeaviestPetForOwner(
            @PathVariable("id") Long id
    ) {
        return ownerService.getHeaviestPetForOwner(id);
    }

    //6. get the lightest pet for one owner
    @GetMapping("owner/{id}/lightest-pet") // localhost:8080/owner/1/lightest-pet
    public PetDTO getLightestPetForOwner(
            @PathVariable("id") Long id
    ) {
        return ownerService.getLightestPetForOwner(id);
    }

    // option to insert min and max weight and get all pets in that range
    @GetMapping("owner/{id}/pets-in-range") // localhost:8080/owner/1/pets-in-range?min=1000&max=5000
    public List<Pet> getPetsInRange(
            @PathVariable("id") Long id,
            @RequestParam("min") double min,
            @RequestParam("max") double max
    ) {
        return ownerService.getPetsInRange(id, min, max);
    }
}
