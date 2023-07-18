package sergei.webshop.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sergei.webshop.dto.PersonDTO;
import sergei.webshop.entity.Address;
import sergei.webshop.entity.ContactData;
import sergei.webshop.entity.Person;
import sergei.webshop.repository.AddressRepository;
import sergei.webshop.repository.ContactDataRepository;
import sergei.webshop.repository.PersonRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContactDataRepository contactDataRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<Person>> findAll() {
        List<Person> allPersons = personRepository.findAll();
        HttpStatus status = HttpStatus.OK;

        if (allPersons.isEmpty()) {
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(allPersons, status);
    }

    @Override
    public ResponseEntity<PersonDTO> addOne(PersonDTO personDTO) {
        Person existingPerson = personRepository.findByPersonalCode(personDTO.getPersonalCode());
        if (existingPerson != null) {
            throw new IllegalArgumentException("Person with the same personal code already exists.");
        }


        Address address = new Address();
        address.setCountry(personDTO.getContactData().getAddress().getCountry());
        address.setCounty(personDTO.getContactData().getAddress().getCounty());
        address.setStreet(personDTO.getContactData().getAddress().getStreet());
        address.setNumber(personDTO.getContactData().getAddress().getNumber());
        address.setPostalIndex(personDTO.getContactData().getAddress().getPostalIndex());
        addressRepository.save(address);

        // Create and save the ContactData
        ContactData contactData = new ContactData();
        contactData.setEmail(personDTO.getContactData().getEmail());
        contactData.setPhone(personDTO.getContactData().getPhone());
        contactData.setAddress(address);
        contactDataRepository.save(contactData);

        // Create and save the Person
        Person person = new Person();
        person.setPersonalCode(personDTO.getPersonalCode());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setPassword(personDTO.getPassword());
        person.setContactData(contactData);
        personRepository.save(person);

        PersonDTO createdPersonDTO = modelMapper.map(person, PersonDTO.class);
        return new ResponseEntity<>(createdPersonDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PersonDTO> deleteOne(Long id) {

        Person person = personRepository.findById(id).get();
        if (person == null) {
            throw new IllegalArgumentException("Person with the given id does not exist.");
        }

        personRepository.delete(person);
        return new ResponseEntity<>(modelMapper.map(person, PersonDTO.class), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<PersonDTO> findOne(Long id, String firstName, String lastName, String personalCode) {
        Person person;

        if (id != null) {
            person = personRepository.findById(id).orElse(null);
        } else if (firstName != null && lastName != null) {
            person = personRepository.findByFirstNameAndLastName(firstName, lastName);
        } else if (personalCode != null) {
            person = personRepository.findByPersonalCode(personalCode);
        } else {
            throw new IllegalArgumentException("Please provide at least one search parameter.");
        }

        if (person == null) {
            throw new IllegalArgumentException("Person not found.");
        }

        return new ResponseEntity<>(modelMapper.map(person, PersonDTO.class), HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<PersonDTO> updateOne(PersonDTO personDTO) {
        Person person = personRepository.findById(personDTO.getId()).orElse(null);
        if (person == null) {
            throw new IllegalArgumentException("Person with the given id does not exist.");
        }

        if (personDTO.getFirstName() != null) {
            person.setFirstName(personDTO.getFirstName());
        }
        if (personDTO.getLastName() != null) {
            person.setLastName(personDTO.getLastName());
        }
        if (personDTO.getPersonalCode() != null) {
            person.setPersonalCode(personDTO.getPersonalCode());
        }
        if (personDTO.getPassword() != null) {
            person.setPassword(personDTO.getPassword());
        }

        if (personDTO.getContactData() != null) {
            ContactData contactData = person.getContactData();
            if (contactData == null) {
                contactData = new ContactData();
            }

            if(personDTO.getContactData().getEmail() != null) {
                contactData.setEmail(personDTO.getContactData().getEmail());
            }

            if (personDTO.getContactData().getPhone() != null) {
                contactData.setPhone(personDTO.getContactData().getPhone());
            }

            if (personDTO.getContactData().getAddress() != null) {
                Address address = contactData.getAddress();
                if (address == null) {
                    address = new Address();
                }

                if(personDTO.getContactData().getAddress().getCountry() != null) {
                    address.setCountry(personDTO.getContactData().getAddress().getCountry());
                }

                if(personDTO.getContactData().getAddress().getCounty() != null) {
                    address.setCounty(personDTO.getContactData().getAddress().getCounty());
                }

                if(personDTO.getContactData().getAddress().getStreet() != null) {
                    address.setStreet(personDTO.getContactData().getAddress().getStreet());
                }

                if(personDTO.getContactData().getAddress().getNumber() != null) {
                    address.setNumber(personDTO.getContactData().getAddress().getNumber());
                }

                if(personDTO.getContactData().getAddress().getPostalIndex() != null) {
                    address.setPostalIndex(personDTO.getContactData().getAddress().getPostalIndex());
                }

                contactData.setAddress(address);
            }

            person.setContactData(contactData);
        }

        personRepository.save(person);

        return new ResponseEntity<>(modelMapper.map(person, PersonDTO.class), HttpStatus.OK);
    }
}
