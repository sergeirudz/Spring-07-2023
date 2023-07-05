package ee.sergei.lemmikloomad.service;

import ee.sergei.lemmikloomad.dto.ClinicDTO;
import ee.sergei.lemmikloomad.entities.Clinic;

public interface ClinicService {

    ClinicDTO addClinic(String clinicName);
    ClinicDTO addPetToClinic(String clinicName, String petName);

    ClinicDTO getClinicWithMostPets();
}
