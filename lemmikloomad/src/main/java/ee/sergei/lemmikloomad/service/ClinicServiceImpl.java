package ee.sergei.lemmikloomad.service;

import ee.sergei.lemmikloomad.entities.Clinic;
import ee.sergei.lemmikloomad.entities.Pet;
import ee.sergei.lemmikloomad.repositories.ClinicRepository;
import ee.sergei.lemmikloomad.repositories.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private PetRepository petRepository;

    @Override
    public Clinic addClinic(String clinicName) {
        Clinic clinic = new Clinic();
        clinic.setClinicName(clinicName);
        return clinicRepository.save(clinic);
    }

    @Override
    public Clinic addPetToClinic(String clinicName, String petName) {
        Clinic clinic = clinicRepository.findByClinicName(clinicName);
        Pet pet = petRepository.findByPetName(petName);

        if (clinic != null && pet != null) {
            pet.setClinic(clinic);
            petRepository.save(pet);
        }
//        log.debug("clinic response: " + clinic);
        return clinic;
    }

    @Override
    public Clinic getClinicWithMostPets() {
        // get all clinics

        List<Clinic> clinics = clinicRepository.findAll();
        Clinic clinicWithMostPets = null;
        int maxPets = 0;

        for (Clinic clinic : clinics) {
            int numPets = clinic.getPets().size();
            if (numPets > maxPets) {
                maxPets = numPets;
                clinicWithMostPets = clinic;
            }
        }

        log.debug("clinicWithMostPets response: " + clinicWithMostPets);
        return clinicWithMostPets;

    }
}
