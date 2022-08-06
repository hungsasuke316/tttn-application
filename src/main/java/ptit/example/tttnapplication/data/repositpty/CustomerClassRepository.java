package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.Customer_Class;

import java.util.Optional;

@Repository
public interface CustomerClassRepository extends JpaRepository<Customer_Class, Integer> {
    Customer_Class findByName(String name);
}
