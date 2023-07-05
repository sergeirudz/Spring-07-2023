package ee.sergei.lemmikloomad.repositories;
import ee.sergei.lemmikloomad.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByOwnerName(String ownerName);
    Owner findByPersonalCode(String personalCode);

    @Query("SELECT o FROM Owner o WHERE SIZE(o.pets) > :count")
    List<Owner> findAllByPetsGreaterThan(int count);
}
