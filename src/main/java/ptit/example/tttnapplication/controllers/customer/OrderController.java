package ptit.example.tttnapplication.controllers.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ptit.example.tttnapplication.dto.request.OrderRequest;
import ptit.example.tttnapplication.dto.response.OrderDetailResponse;
import ptit.example.tttnapplication.dto.response.OrderResponse;
import ptit.example.tttnapplication.services.OrdersService;


import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
public class OrderController {
    private final OrdersService ordersService;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse purchaseBill(@RequestBody OrderRequest orderRequest) {
        return ordersService.orderProduct( orderRequest);
    }

    @GetMapping("/bill/{id}")

    @ResponseStatus(HttpStatus.OK)
    public OrderResponse getBillDetailById(@PathVariable("id") int id) {
        return ordersService.getBillById(id);
    }

    @GetMapping("/bill/all")

    @ResponseStatus(HttpStatus.OK)
    public List<OrderDetailResponse> getBillDetailByAccount() {
        return ordersService.getBillByAccount();
    }
}
