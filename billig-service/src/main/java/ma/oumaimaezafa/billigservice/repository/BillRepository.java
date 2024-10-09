package ma.oumaimaezafa.billigservice.repository;

import ma.oumaimaezafa.billigservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill,Long> {
}
