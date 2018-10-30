package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hello.moewller.*;
import hello.model.CustomerMo;
import hello.model.CustomerMoRepository;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
	public CommandLineRunner demo(CustomerMoRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new CustomerMo("Jack", "Bauer"));
			repository.save(new CustomerMo("Chloe", "O'Brian"));
			repository.save(new CustomerMo("Kim", "Bauer"));
			repository.save(new CustomerMo("David", "Palmer"));
			repository.save(new CustomerMo("Michelle", "Dessler"));
		};
	}
}
