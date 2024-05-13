package logic.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiApplication implements WebMvcConfigurer{
    
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://danielromero-porfoliocode.web.app")
                .allowedMethods("POST")
                .allowedHeaders("Content-Type");
    }

}
