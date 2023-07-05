package ee.sergei.lemmikloomad.repositories;
import ee.sergei.lemmikloomad.entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    Clinic findByClinicName(String clinicName);



}
