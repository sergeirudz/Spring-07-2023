package ee.sergei.lemmikloomad.service;

import ee.sergei.lemmikloomad.entities.Owner;
import ee.sergei.lemmikloomad.entities.Pet;
import ee.sergei.lemmikloomad.repositories.OwnerRepository;
import ee.sergei.lemmikloomad.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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



    /*
    *
        Pet pet = new Pet(name, weight);
        petRepository.save(pet);

//        List<Pet> allPets = petRepository.findAll();
        return petRepository.findAll();
    * */

}
