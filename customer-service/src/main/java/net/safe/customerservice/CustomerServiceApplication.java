package net.safe.customerservice;

import net.safe.customerservice.config.GlobalConfig;
import net.safe.customerservice.entities.Customer;
import net.safe.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {

            List<Customer> customerList = List.of(
                    Customer.builder()
                            .firstName("Safe")
                            .lastName("Ben Abdrabah")
                            .email("safe@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Dhia")
                            .lastName("Ben Abdrabah")
                            .email("dhia@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    }

}
