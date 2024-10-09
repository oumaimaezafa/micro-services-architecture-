package ma.oumaimaezafa.customerservice;

import ma.oumaimaezafa.customerservice.entities.Customer;
import ma.oumaimaezafa.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class Activite2Application {

    public static void main(String[] args) {
        SpringApplication.run(Activite2Application.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Customer.class);
        return  args -> {

            customerRepository.save(new Customer(null,"Oumaima","oumaima@gmail.com","08745678344"));
            customerRepository.save(new Customer(null,"Mouad","mouad@gmail.com","08745678344"));
            customerRepository.save(new Customer(null,"Yassine","yassine@gmail.com","08745678344"));
            customerRepository.save(new Customer(null,"Salima","salima@gmail.com","08745678344"));
            customerRepository.findAll().forEach(customer -> {
                System.out.println(customer.toString());
            });

        };
    }
}
