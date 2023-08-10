package sergei.webshop.repository;

import sergei.webshop.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByPersonalCode(String personalCode);

    Person findByFirstNameAndLastName(String firstName, String lastName);


}
