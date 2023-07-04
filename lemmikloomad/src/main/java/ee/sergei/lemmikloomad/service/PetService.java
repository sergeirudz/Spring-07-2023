package ee.sergei.lemmikloomad.service;

import ee.sergei.lemmikloomad.entities.Owner;
import ee.sergei.lemmikloomad.entities.Pet;

import java.util.List;
import java.util.Optional;


public interface PetService {

    List<Pet> addPet(String name, double weight);
    List<Pet> getAllPets();

}
