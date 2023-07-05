package ee.sergei.lemmikloomad.service;

import ee.sergei.lemmikloomad.entities.Clinic;
import ee.sergei.lemmikloomad.repositories.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public Clinic addClinic(String clinicName) {
        Clinic clinic = new Clinic();
        clinic.setClinicName(clinicName);
        return clinicRepository.save(clinic);
    }

    @Override
    public Clinic addPetToClinic(String clinicName, String petName) {
        return null;
    }
}
