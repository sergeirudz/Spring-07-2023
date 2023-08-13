package sergei.webshop.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Log4j2
public class TokenParser extends BasicAuthenticationFilter {


    // @Lazy() is needed to avoid circular dependency. Import to SecurityConfiguration creates a circular dependency.
    public TokenParser(@Lazy AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

//        System.out.println(request.getMethod());
//        log.info(request.getMethod()); // IN PRODUCTION
//        log.debug(request.getMethod()); // ONLY DURING DEVELOPMENT
//        log.error(request.getMethod()); // SEND AN EMAIL TO ADMIN

        if (request.getHeader(HttpHeaders.AUTHORIZATION) != null &&
                request.getHeader(HttpHeaders.AUTHORIZATION).equals("Bearer 123")) {
            Authentication authentication = new UsernamePasswordAuthenticationToken("USER1", null, null);
            // Following code gives access to all endpoints
            SecurityContextHolder.getContext().setAuthentication(
                    authentication
            );
        }

        // default behavior. Allows to access endpoints only if user is authenticated
        super.doFilterInternal(request, response, chain);
    }
}
