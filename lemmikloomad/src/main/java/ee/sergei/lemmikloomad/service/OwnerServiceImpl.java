package ee.sergei.lemmikloomad.service;

import ee.sergei.lemmikloomad.entities.Owner;
import ee.sergei.lemmikloomad.entities.Pet;
import ee.sergei.lemmikloomad.repositories.OwnerRepository;
import ee.sergei.lemmikloomad.repositories.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Slf4j
@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;


    @Override
    public List<Owner> addOwner(String name) {
        Owner owner = new Owner();
        owner.setOwnerName(name);
        ownerRepository.save(owner);
        return ownerRepository.findAll();
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public void addPetToOwner(String ownerName, String petName) {
        Owner owner = ownerRepository.findByOwnerName(ownerName);
        Pet pet = petRepository.findByPetName(petName);

        if (owner != null && pet != null) {
            pet.setOwner(owner);
            petRepository.save(pet);
//            owner.getPets().add(pet);
//            ownerRepository.save(owner);
        }
    }

    @Override
    public int getNumberOfPetsForOwner(Long id) {

        Owner owner = ownerRepository.findById(id).get(); //orElse(null);
//        if (owner != null) {
            return owner.getPets().size();
//        }
//        return 0;
    }

    @Override
    public Pet getHeaviestPetForOwner(Long id) {
        Owner owner = ownerRepository.findById(id).get();
//        Owner owner = ownerRepository.findById(id).orElse(null);
        List<Pet> pets = petRepository.findAllByOwner(owner);



//        System.out.println("owner response: " + owner);
//        return null;

        Pet heaviestPet = pets.get(0);
        for (Pet pet : pets) {
            if (pet.getPetWeight() > heaviestPet.getPetWeight()) {
                heaviestPet = pet;
            }
        }
        log.debug("heaviestPet response: " + heaviestPet);
        return heaviestPet;
    }



    /*
    *
        Pet pet = new Pet(name, weight);
        petRepository.save(pet);

//        List<Pet> allPets = petRepository.findAll();
        return petRepository.findAll();
    * */

}
