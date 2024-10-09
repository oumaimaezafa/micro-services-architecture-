package ma.oumaimaezafa.billigservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.oumaimaezafa.billigservice.model.Customer;

import java.beans.Customizer;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity  @AllArgsConstructor @NoArgsConstructor
@Data
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long id;
    private Date billingDate;
    @OneToMany (mappedBy = "bill")
    private Collection<ProductItem> productItems;
    private Long  customerID;
    @Transient
    private Customer customer;
}
