package ee.sergei.lemmikloomad.repositories;

import ee.sergei.lemmikloomad.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, String> {
}
