package sergei.webshop.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {
    String extractUserPersonalCode(String jwt);

    boolean isTokenValid(String token, UserDetails userDetails);

    String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    );

    String generateToken(UserDetails userDetails);
}
