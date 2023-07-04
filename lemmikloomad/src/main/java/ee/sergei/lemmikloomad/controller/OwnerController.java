package ee.sergei.lemmikloomad.controller;

import ee.sergei.lemmikloomad.entities.Owner;
import ee.sergei.lemmikloomad.service.OwnerService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("owner/all")
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("owner/add-pet")
    public void addPetToOwner(
            @RequestParam("ownerName") String ownerName,
            @RequestParam("petName") String petName
    ) {
         ownerService.addPetToOwner(ownerName, petName);
    }
}
