package ma.oumaimaezafa.billigservice.feign;


import ma.oumaimaezafa.billigservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping(path = "/customers/{id}")
    Customer getCustomerById(@PathVariable("id") Long id);

}
