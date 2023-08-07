package sergei.webshop.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    //    @CrossOrigin(origins = "http://localhost:4200")

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
//                WebMvcConfigurer.super.addCorsMappings(registry); DEFAULT
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                        .allowedHeaders("*");
//                registry.addMapping("/admin/**")
//                        .allowedOrigins("http://localhost:3000")
//                        .allowedMethods("GET")
//                        .allowedHeaders("*");
            }
        };
    }


}

/*

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(
                    CorsRegistry registry) {
//                WebMvcConfigurer.super.addCorsMappings(registry);// DEFAULT
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200", "http://localhost:3000") // "http://localhost:4200", "http://localhost:3000"
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                        .allowedHeaders("*");
//                        .allowCredentials(true);

//                registry.addMapping("/admin/**")
//                        .allowedOrigins("http://localhost:4300")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
//                        .allowedHeaders("*");
//                        .allowCredentials(true);
            }
        };
    }
* */