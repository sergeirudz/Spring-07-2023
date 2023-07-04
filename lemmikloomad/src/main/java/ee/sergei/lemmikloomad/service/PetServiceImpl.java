package ee.sergei.lemmikloomad.service;
import ee.sergei.lemmikloomad.entities.Pet;
import ee.sergei.lemmikloomad.repositories.OwnerRepository;
import ee.sergei.lemmikloomad.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {


    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Pet> addPet(String name, double weight) {
       Pet pet = new Pet();
        pet.setPetName(name);
        pet.setPetWeight(weight);
        petRepository.save(pet);
        return petRepository.findAll();
    }


    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}
