package ptit.example.tttnapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    List<CartItemRequest> cartItemRequests = new ArrayList<>();
    private int total;
    private int addressId;
}
