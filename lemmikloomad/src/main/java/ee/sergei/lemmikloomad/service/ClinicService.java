package ee.sergei.lemmikloomad.service;
import ee.sergei.lemmikloomad.dto.ClinicDTO;

public interface ClinicService {
    ClinicDTO addClinic(String clinicName);
    ClinicDTO addPetToClinic(String clinicName, String petName);
    ClinicDTO getClinicWithMostPets();
}
