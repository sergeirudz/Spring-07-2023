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
    public void addOwner(String name) {
        Owner owner = new Owner(name);
   ownerRepository.save(owner);
        ownerRepository.save(owner);
    }

    @Override
    public List<Owner> getAllOwners() {
        return null;
    }


    /*
    *
        Pet pet = new Pet(name, weight);
        petRepository.save(pet);

//        List<Pet> allPets = petRepository.findAll();
        return petRepository.findAll();
    * */

}
