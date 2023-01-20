package ArgProg4.CV_Dynamic1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CvDynamic1Application {

	public static void main(String[] args) {
		SpringApplication.run(CvDynamic1Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer(){
   	String[] allowDomains = new String[2];
   	allowDomains[0] = "http://localhost:4200";
   	allowDomains[1] = "http://localhost:8081";

   	System.out.println("CORS configuration....");
   	return new WebMvcConfigurer() {
    	@Override
    	public void addCorsMappings(CorsRegistry registry) {
        	registry.addMapping("/**")
			.allowedOrigins(allowDomains)
			.allowedMethods("*")
			.allowedHeaders("*");
      }
   };
}

}
