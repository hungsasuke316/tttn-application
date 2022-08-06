package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.OrdersItem_ID;
import ptit.example.tttnapplication.data.entity.Orders_Item;

@Repository
public interface OrdersItemRepository extends JpaRepository<Orders_Item, OrdersItem_ID> {
}
