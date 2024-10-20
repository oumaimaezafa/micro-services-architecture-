package ma.oumaimaezafa.billigservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "fullBill", types = Bill.class)
public interface BillProjection {
    Long getId();              // Correspond à 'id'
    Date getBillingDate();      // Correspond à 'billingDate'
    Long getCustomerID();       // Correspond à 'customerID'
    // Si tu veux aussi projeter les produits associés à la facture :
    //Collection<ProductItem> getProductItems();
}

