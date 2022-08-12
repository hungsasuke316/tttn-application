package ptit.example.tttnapplication.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private int cartId;

    private int productId;

    private int quantity;
}
