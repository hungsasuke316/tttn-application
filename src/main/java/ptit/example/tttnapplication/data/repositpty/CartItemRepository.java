package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.CartItem_ID;
import ptit.example.tttnapplication.data.entity.Cart_Item;

@Repository
public interface CartItemRepository extends JpaRepository<Cart_Item, CartItem_ID> {
}
