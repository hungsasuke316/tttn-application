package ptit.example.tttnapplication.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Orders_Item {
    @EmbeddedId
    private OrdersItem_ID id;
    private Integer quantity;

    @ManyToOne
    @MapsId("ordersId")
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;
}
