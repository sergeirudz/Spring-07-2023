package sergei.webshop.service;

import org.springframework.http.ResponseEntity;
import sergei.webshop.dto.AuthenticationResponse;
import sergei.webshop.dto.LoginDTO;
import sergei.webshop.dto.PersonDTO;

public interface AuthenticationService {
    ResponseEntity<AuthenticationResponse> login(LoginDTO loginDTO);

    ResponseEntity<AuthenticationResponse> register(PersonDTO personDTO);
}
