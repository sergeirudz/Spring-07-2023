package ee.sergei.lemmikloomad.service;
import ee.sergei.lemmikloomad.entities.Owner;

import java.util.List;

public interface OwnerService {
    void addOwner(String name);
    List<Owner> getAllOwners();
}
