package ptit.example.tttnapplication.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrdersItem {
    @EmbeddedId
    private OrdersItemId id;
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
