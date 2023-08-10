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

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody PersonDTO personDTO
    ){
        return authenticationService.register(personDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login (
            @RequestBody LoginDTO loginDTO
    ){
        return authenticationService.login(loginDTO);
    }

}
