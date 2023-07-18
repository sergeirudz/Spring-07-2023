package sergei.webshop.repository;

import sergei.webshop.entity.PersonAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<PersonAddress, Long> {
}
