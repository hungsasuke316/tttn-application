package ptit.example.tttnapplication.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemId implements Serializable {
    @Column(name = "cart_id")
    private Integer cartId;
    @Column(name = "product_id")
    private Integer productId;
}
