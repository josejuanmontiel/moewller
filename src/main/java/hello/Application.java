package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hello.model.CustomerEntity;
import hello.model.CustomerRepository;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new CustomerEntity("Jack", "Bauer"));
			repository.save(new CustomerEntity("Chloe", "O'Brian"));
			repository.save(new CustomerEntity("Kim", "Bauer"));
			repository.save(new CustomerEntity("David", "Palmer"));
			repository.save(new CustomerEntity("Michelle", "Dessler"));

			// save a couple of customers
			repository.save(new CustomerEntity("Jack", "Bauer"));
			repository.save(new CustomerEntity("Chloe", "O'Brian"));
			repository.save(new CustomerEntity("Kim", "Bauer"));
			repository.save(new CustomerEntity("David", "Palmer"));
			repository.save(new CustomerEntity("Michelle", "Dessler"));

		};
	}
}
