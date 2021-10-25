package tn.esprit.spring;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ReservationVoituresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationVoituresApplication.class, args);
	}
	@Bean
    ApplicationRunner init(VoituresRepository repository) {
        return args -> {
            Stream.of("Golf", "Polo", "Passat").forEach(marque -> {
                repository.save(new Voitures(marque));
            });
            repository.findAll().forEach(System.out::println);
        };
    }

}
