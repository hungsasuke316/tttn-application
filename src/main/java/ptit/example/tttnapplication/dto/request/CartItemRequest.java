package ptit.example.tttnapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemRequest {
    private int productId;

    private int productQuantity;

    @Override
    public String toString() {
        return "CartItemRequest{" +
                "productId=" + productId +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
