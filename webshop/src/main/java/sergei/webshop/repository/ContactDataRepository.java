package sergei.webshop.repository;

import sergei.webshop.entity.PersonContactData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDataRepository extends JpaRepository<PersonContactData, Long> {
}
