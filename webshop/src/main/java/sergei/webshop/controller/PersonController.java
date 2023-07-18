package sergei.webshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sergei.webshop.dto.PersonDTO;
import sergei.webshop.entity.Person;
import sergei.webshop.service.PersonService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonService personService;

    @GetMapping("persons") // http://localhost:8080/persons
    public ResponseEntity<List<Person>> getAllPersons() {
        return personService.findAll();
    }

    @PostMapping("persons")
    public ResponseEntity<PersonDTO> addPerson(
            @RequestBody PersonDTO personDTO) {
        /*
        {
    "personalCode": "1",
    "firstName": "John",
    "lastName": "Doe",
    "password": "password",
    "contactData": {
        "email": "john.doe1@example.com",
        "phone": "+372555555",
        "address": {
            "country": "Estonia",
            "county": "Harju",
            "street": "123 Main Street",
            "number": "12",
            "postalIndex": "12345"
        }
    }
}
        * */
        return personService.addOne(personDTO);
    }

    @DeleteMapping("person/{id}")
    public ResponseEntity<PersonDTO> deletePerson(
            @PathVariable Long id) {
        return personService.deleteOne(id);
    }

    @GetMapping("/person")
    public ResponseEntity<PersonDTO> getPerson(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName,
            @RequestParam(name = "personalCode", required = false) String personalCode) {
/*
http://localhost:8080/person?firstName=John&lastName=Doe
http://localhost:8080/person?personalCode=1
http://localhost:8080/person?id=2
* */

        return personService.findOne(id, firstName, lastName, personalCode);
    }

    @PatchMapping("person/{id}")
    public ResponseEntity<PersonDTO> updatePerson(
            @RequestBody PersonDTO personDTO
    ) {
        /* Update all fields at once or only the ones that are provided
        {
          "id": 2,
          "personalCode": "1234567890",
          "firstName": "Updated First Name",
          "lastName": "Updated Last Name",
          "password": "updated_password",
          "contactData": {
            "email": "updated_email@example.com",
            "phone": "9876543210",
            "address": {
              "country": "Updated Country",
              "county": "Updated County",
              "street": "Updated Street",
              "number": "456",
              "postalIndex": "67890"
            }
          }
        }
        * */
        return personService.updateOne(personDTO);
    }
}
