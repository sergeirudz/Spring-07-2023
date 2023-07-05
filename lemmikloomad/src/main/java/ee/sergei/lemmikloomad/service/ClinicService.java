package ee.sergei.lemmikloomad.service;

import ee.sergei.lemmikloomad.entities.Clinic;

public interface ClinicService {

    Clinic addClinic(String clinicName);
    Clinic addPetToClinic(String clinicName, String petName);

    Clinic getClinicWithMostPets();
}
