package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ptit.example.tttnapplication.data.entity.Cart;
import ptit.example.tttnapplication.data.entity.CartItemId;
import ptit.example.tttnapplication.data.entity.CartItem;
import ptit.example.tttnapplication.data.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, CartItemId> {
    List<CartItem> findAllByCart_Id(int cartId);

    Optional<CartItem> findCartDetailsByProductAndCart(Product product, Cart cart);

    @Transactional
    @Modifying
    @Query(value = "delete from cart_item  " +
            "where product_id = ?1 and cart_id = ?2", nativeQuery = true)
    int deleteFromCartDetailByID(int productId, int cartId);
}
