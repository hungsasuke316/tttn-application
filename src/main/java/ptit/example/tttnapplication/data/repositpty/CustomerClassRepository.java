package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.CustomerClass;

@Repository
public interface CustomerClassRepository extends JpaRepository<CustomerClass, Integer> {
    CustomerClass findByName(String name);
}
