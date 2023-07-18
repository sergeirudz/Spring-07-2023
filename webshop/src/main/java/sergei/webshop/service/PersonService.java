package sergei.webshop.service;

import org.springframework.http.ResponseEntity;
import sergei.webshop.dto.PersonDTO;
import sergei.webshop.entity.Person;

import java.util.List;

public interface PersonService {
    ResponseEntity<List<Person>> findAll();

    ResponseEntity<PersonDTO> addOne(PersonDTO personDTO);

    ResponseEntity<PersonDTO> deleteOne(Long id);

    ResponseEntity<PersonDTO> findOne(Long id, String firstName, String lastName, String personalCode);

    ResponseEntity<PersonDTO> updateOne(PersonDTO personDTO);
}
