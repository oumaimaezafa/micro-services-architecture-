package ma.oumaimaezafa.billigservice.web;


import ma.oumaimaezafa.billigservice.entities.Bill;
import ma.oumaimaezafa.billigservice.feign.CustomerRestClient;
import ma.oumaimaezafa.billigservice.feign.ProductItemRestClient;
import ma.oumaimaezafa.billigservice.model.Customer;
import ma.oumaimaezafa.billigservice.model.Product;
import ma.oumaimaezafa.billigservice.repository.BillRepository;
import ma.oumaimaezafa.billigservice.repository.ProductItemRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private ProductItemRestClient productItemRestClient;
    private CustomerRestClient customerRestClient;

    public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository, ProductItemRestClient productItemRestClient, CustomerRestClient customerRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.productItemRestClient = productItemRestClient;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping(path = "/bills/full/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill=billRepository.findById(id).get();
        Customer customer=customerRestClient.getCustomerById(bill.getId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(pi->{
            Product  product=productItemRestClient.getProductById(pi.getProductID());
            //pi.setProduct(product);
            pi.setProductName(product.getName());
        });
        return bill;
    }
}
