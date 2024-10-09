package ma.oumaimaezafa.billigservice.repository;

import ma.oumaimaezafa.billigservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;


@RepositoryRestResource
public interface ProductItemRepository  extends JpaRepository<ProductItem,Long> {

    // chercher dans la BD tous le produits de la facture associe a id
    public Collection<ProductItem> findByBillId(Long id) ;

}
