package ee.sergei.lemmikloomad.service;

import ee.sergei.lemmikloomad.dto.ClinicDTO;
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
    public ClinicDTO addClinic(String clinicName) {
        Clinic clinic = new Clinic();
        clinic.setClinicName(clinicName);

        ClinicDTO clinicDTO = new ClinicDTO();
        clinicDTO.setClinicName(clinicName);

        clinicRepository.save(clinic);

        return clinicDTO;
    }

    @Override
    public ClinicDTO addPetToClinic(String clinicName, String petName) {
        Clinic clinic = clinicRepository.findByClinicName(clinicName);
        Pet pet = petRepository.findByPetName(petName);

        ClinicDTO clinicDTO = new ClinicDTO();

        if (clinic != null && pet != null) {
            pet.setClinic(clinic);
            petRepository.save(pet);
            clinicDTO.setClinicName(clinicName);
        }

//        log.debug("clinic response: " + clinic);
        return clinicDTO;
    }

    @Override
    public ClinicDTO getClinicWithMostPets() {
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

        ClinicDTO clinicDTO = new ClinicDTO();
        clinicDTO.setClinicName(clinicWithMostPets.getClinicName());


        log.debug("clinicWithMostPets response: " + clinicWithMostPets);
        return clinicDTO;

    }
}
