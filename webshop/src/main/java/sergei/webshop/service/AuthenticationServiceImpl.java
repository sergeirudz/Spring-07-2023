package sergei.webshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sergei.webshop.dto.AuthenticationResponse;
import sergei.webshop.dto.LoginDTO;
import sergei.webshop.dto.PersonDTO;
import sergei.webshop.entity.Person;
import sergei.webshop.entity.PersonAddress;
import sergei.webshop.entity.PersonContactData;
import sergei.webshop.entity.Role;
import sergei.webshop.repository.AddressRepository;
import sergei.webshop.repository.ContactDataRepository;
import sergei.webshop.repository.PersonRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContactDataRepository contactDataRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public ResponseEntity<AuthenticationResponse> register(PersonDTO personDTO) {
        // Should check email and personal code uniqueness
        Person existingPerson = personRepository.findByPersonalCode(personDTO.getPersonalCode());
        if (existingPerson != null) {
            throw new IllegalArgumentException("Person with the same personal code already exists.");
        }

        PersonAddress personAddress = new PersonAddress();
        personAddress.setCountry(personDTO.getContactData().getAddress().getCountry());
        personAddress.setCounty(personDTO.getContactData().getAddress().getCounty());
        personAddress.setStreet(personDTO.getContactData().getAddress().getStreet());
        personAddress.setNumber(personDTO.getContactData().getAddress().getNumber());
        personAddress.setPostalIndex(personDTO.getContactData().getAddress().getPostalIndex());
        addressRepository.save(personAddress);

        // Create and save the PersonContactData
        PersonContactData personContactData = new PersonContactData();
        personContactData.setEmail(personDTO.getContactData().getEmail());
        personContactData.setPhone(personDTO.getContactData().getPhone());
        personContactData.setPersonAddress(personAddress);
        contactDataRepository.save(personContactData);

        // Create and save the Person
        Person person = new Person();
        person.setPersonalCode(personDTO.getPersonalCode());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setPassword(passwordEncoder.encode(personDTO.getPassword()));
        person.setPersonContactData(personContactData);
        person.setRole(Role.USER);
        Person createdPerson = personRepository.save(person);

        var jwt = jwtService.generateToken(createdPerson);
        return ResponseEntity.ok(AuthenticationResponse
                .builder()
                .token(jwt)
                .build()
        );
    }


    @Override
    public ResponseEntity<AuthenticationResponse> login(LoginDTO loginDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()
                )
        );
        Person person = personRepository.findByPersonContactDataEmail(loginDTO.getEmail());
                // TODO throw exception if the person does not exist.
        System.out.println("person: " + person);

        var jwt = jwtService.generateToken(person);
        return ResponseEntity.ok(AuthenticationResponse
                .builder()
                .token(jwt)
                .build()
        );
    }

}
