package ee.sergei.lemmikloomad.service;
import ee.sergei.lemmikloomad.entities.Pet;
import java.util.List;

public interface PetService {
    List<Pet> addPet(String name, double weight);
    List<Pet> getAllPets();
}
