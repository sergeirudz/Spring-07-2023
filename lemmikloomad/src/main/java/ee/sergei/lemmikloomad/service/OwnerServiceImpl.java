package ee.sergei.lemmikloomad.service;
import ee.sergei.lemmikloomad.dto.PetDTO;
import ee.sergei.lemmikloomad.entities.Owner;
import ee.sergei.lemmikloomad.entities.Pet;
import ee.sergei.lemmikloomad.repositories.OwnerRepository;
import ee.sergei.lemmikloomad.repositories.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        }
    }

    @Override
    public int getNumberOfPetsForOwner(Long id) {
        Owner owner = ownerRepository.findById(id).get();
            return owner.getPets().size();
    }

    @Override
    public PetDTO getHeaviestPetForOwner(Long id) {
        Owner owner = ownerRepository.findById(id).get();
        List<Pet> pets = petRepository.findAllByOwner(owner);
        PetDTO heaviestPetDTO = new PetDTO();

        Pet heaviestPet = pets.get(0);
        for (Pet pet : pets) {
            if (pet.getPetWeight() > heaviestPet.getPetWeight()) {
                heaviestPet = pet;
            }
        }

        heaviestPetDTO.setPetName(heaviestPet.getPetName());
        heaviestPetDTO.setPetWeight(heaviestPet.getPetWeight());

        log.debug("heaviestPet response: " + heaviestPet);
        return heaviestPetDTO;
    }

    @Override
    public PetDTO getLightestPetForOwner(Long id) {
        Owner owner = ownerRepository.findById(id).get();
        List<Pet> pets = petRepository.findAllByOwner(owner);
        PetDTO lightestPetDTO = new PetDTO();

        Pet lightestPet = pets.get(0);
        for (Pet pet : pets) {
            if (pet.getPetWeight() < lightestPet.getPetWeight()) {
                lightestPet = pet;
            }
        }

        lightestPetDTO.setPetName(lightestPet.getPetName());
        lightestPetDTO.setPetWeight(lightestPet.getPetWeight());

        return lightestPetDTO;
    }

    @Override
    public List<Pet> getPetsInRange(Long id, double min, double max) {
        Owner owner = ownerRepository.findById(id).get();
        List<Pet> pets = petRepository.findAllByOwner(owner);
/*        Collections.sort(pets);
        log.debug("pets: " + pets);
        log.debug("min: " + min);
        log.debug("max: " + max);
        for (Pet pet : pets) {
            log.debug("pet.getPetWeight(): " + pet.getPetWeight());
        }
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getPetWeight() < min || pets.get(i).getPetWeight() > max) {
                pets.remove(i);
                i--;
            }
        }*/
        return pets;
    }
}
