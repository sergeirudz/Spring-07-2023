package sergei.webshop.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sergei.webshop.dto.AuthenticationResponse;
import sergei.webshop.dto.LoginDTO;
import sergei.webshop.dto.PersonDTO;

@Service
public class AuthenticationService2Impl implements AuthenticationService2 {
    @Override
    public ResponseEntity<AuthenticationResponse> register(PersonDTO personDTO) {
        return null;
    }

    @Override
    public ResponseEntity<AuthenticationResponse> login(LoginDTO loginDTO) {
        return null;
    }
}
