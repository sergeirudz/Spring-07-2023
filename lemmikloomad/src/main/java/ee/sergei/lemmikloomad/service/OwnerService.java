package ee.sergei.lemmikloomad.service;
import ee.sergei.lemmikloomad.dto.PetDTO;
import ee.sergei.lemmikloomad.entities.Owner;
import ee.sergei.lemmikloomad.entities.Pet;

import java.util.List;

public interface OwnerService {
    List<Owner> addOwner(String name);
    List<Owner> getAllOwners();

    void addPetToOwner(String ownerName, String petName);

    int getNumberOfPetsForOwner(Long id);

    PetDTO getHeaviestPetForOwner(Long id);
}
