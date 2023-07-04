package ee.sergei.lemmikloomad.service;
import ee.sergei.lemmikloomad.entities.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> addOwner(String name);
    List<Owner> getAllOwners();

    void addPetToOwner(String ownerName, String petName);
}
