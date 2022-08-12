package ptit.example.tttnapplication.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartItemResponse {
    private int productId;

    private String productName;

    private int productPrice;

    private int cartItemQuantity;

    private String productThumbnail;
}
