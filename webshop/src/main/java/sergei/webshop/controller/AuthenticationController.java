package sergei.webshop.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sergei.webshop.dto.AuthenticationResponse;
import sergei.webshop.dto.LoginDTO;
import sergei.webshop.dto.PersonDTO;
import sergei.webshop.service.AuthenticationService;
import sergei.webshop.service.AuthenticationService2;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final AuthenticationService2 authenticationService2;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody PersonDTO personDTO
    ){
        return authenticationService.register(personDTO);
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
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login (
            @RequestBody LoginDTO loginDTO
    ){
        return authenticationService.login(loginDTO);
    }

    @PostMapping("/register2")
    public ResponseEntity<AuthenticationResponse> register2 (
            @RequestBody PersonDTO personDTO
    ){
        return authenticationService2.register(personDTO);
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
    }

    @PostMapping("/login2")
    public ResponseEntity<AuthenticationResponse> login2 (
            @RequestBody LoginDTO loginDTO
    ){
        return authenticationService2.login(loginDTO);
    }

}
