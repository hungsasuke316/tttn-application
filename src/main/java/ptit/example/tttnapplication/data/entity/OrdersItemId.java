package ptit.example.tttnapplication.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class OrdersItemId implements Serializable {
    private Integer ordersId;
    private Integer productId;
}
