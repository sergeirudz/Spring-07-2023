package sergei.webshop.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sergei.webshop.dto.AuthenticationResponse;

import java.util.Date;

@Component
public class TokenGenerator {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expires-in-days}")
    private int expiresInDays;

    public AuthenticationResponse getToken() {

        Date expirationDate = new Date(System.currentTimeMillis() + expiresInDays * 24L * 60 * 60 * 1000);

        AuthenticationResponse token = new AuthenticationResponse("token", null);
        String jwtToken = Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret)), SignatureAlgorithm.HS512)
                .setSubject("test")
                .setAudience("Webshop")
                .setExpiration( expirationDate)
                .claim("roles", "user")
                .compact();

        token.setToken(jwtToken);
        return token;
    }
}
