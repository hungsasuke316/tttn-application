package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.OrdersItemId;
import ptit.example.tttnapplication.data.entity.OrdersItem;

@Repository
public interface OrdersItemRepository extends JpaRepository<OrdersItem, OrdersItemId> {
}
