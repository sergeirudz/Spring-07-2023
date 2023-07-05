package ee.sergei.lemmikloomad.controller;

import ee.sergei.lemmikloomad.dto.ClinicDTO;
import ee.sergei.lemmikloomad.entities.Clinic;
import ee.sergei.lemmikloomad.service.ClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ClinicController {


    private final ClinicService clinicService;

    @GetMapping("clinic/add")
    public ClinicDTO addClinic(
            @RequestParam("clinicName") String clinicName) {
        return clinicService.addClinic(clinicName);
    }

    @GetMapping("clinic/add-pet")
    public ClinicDTO addPetToClinic(
            @RequestParam("clinicName") String clinicName,
            @RequestParam("petName") String petName) {
        return clinicService.addPetToClinic(clinicName, petName);
    }

    @GetMapping("clinic/most-pets")
    public ClinicDTO getClinicWithMostPets() {
        return clinicService.getClinicWithMostPets();
    }
}
