package ma.oumaimaezafa.billigservice;

import ma.oumaimaezafa.billigservice.entities.Bill;
import ma.oumaimaezafa.billigservice.entities.ProductItem;
import ma.oumaimaezafa.billigservice.feign.CustomerRestClient;
import ma.oumaimaezafa.billigservice.feign.ProductItemRestClient;
import ma.oumaimaezafa.billigservice.model.Customer;
import ma.oumaimaezafa.billigservice.model.Product;
import ma.oumaimaezafa.billigservice.repository.BillRepository;
import ma.oumaimaezafa.billigservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableFeignClients
public class BilligServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilligServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient){
        return  args -> {
            //ajouter une facture

             Customer customer=customerRestClient.getCustomerById(1L);
             Bill bill=billRepository.save(new Bill(null,new Date(),null,customer.getId(),null));
             PagedModel<Product> productPageModel=productItemRestClient.pageProducts(0,3);

             productPageModel.forEach(p->{
                 ProductItem productItem =new ProductItem();
                 productItem.setPrice(p.getPrice());
                 productItem.setQuantity(1+new Random().nextInt(100));
                 productItem.setBill(bill);
                 productItem.setProductID(p.getId());
                 productItemRepository.save(productItem);

             });



        };
    }
}
