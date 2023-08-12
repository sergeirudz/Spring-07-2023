package sergei.webshop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
/*
TODO refactor https://youtu.be/TeBt0Ike_Tk?t=1687
https://github.com/unknownkoder/spring-security-login-system/blob/main/AuthenticatedBackend/src/main/java/com/unkownkoder/configuration/SecurityConfiguration.java
 */
        http
                .cors(AbstractHttpConfigurer::disable)
                .headers(headers -> headers
                        .xssProtection(HeadersConfigurer.XXssConfig::disable
                        ))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> {
                    requests
                            .requestMatchers("/public-products").permitAll()
                            .requestMatchers("/categories").permitAll()
                            .requestMatchers("/login").permitAll()
                            .requestMatchers("/signup").permitAll()
                            .anyRequest().authenticated();
                });

        http.sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

//        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // PREVIOUS VERSION
        http.addFilterBefore(tokenParser, BasicAuthenticationFilter.class);

        return http.build();

//        http
//            .cors()
//            .and()
//            .headers()
//            .xssProtection()
//            .disable()
//            .and()
//            .csrf() // TODO refactor
//            .disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/auth/**" )
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
    }

}
