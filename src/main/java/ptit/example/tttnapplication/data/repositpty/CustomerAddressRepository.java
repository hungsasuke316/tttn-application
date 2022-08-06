package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.Customer_Address;

@Repository
public interface CustomerAddressRepository extends JpaRepository<Customer_Address, Integer> {
}
