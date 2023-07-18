package sergei.webshop.repository;

import sergei.webshop.entity.ContactData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDataRepository extends JpaRepository<ContactData, Long> {
}
