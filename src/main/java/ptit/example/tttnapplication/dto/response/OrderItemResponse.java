package ptit.example.tttnapplication.dto.response;

import lombok.*;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse {
    private int productId;

    private String productName;

    private int productQuantity;

    private int productPrice;
}
