package ptit.example.tttnapplication.controllers.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ptit.example.tttnapplication.dto.request.CartRequest;
import ptit.example.tttnapplication.dto.response.CartItemDto;
import ptit.example.tttnapplication.dto.response.CartResponse;
import ptit.example.tttnapplication.services.CartItemService;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/customer")
public class CartController {
    private final CartItemService cartItemService;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public CartResponse getAllItemsByCart() {
        return cartItemService.getAllCartItemsOfCustomer();
    }

    @PostMapping("/cart/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CartItemDto addItemToCart(@PathVariable("productId") int productId) {
        return cartItemService.addProductToCart(productId);
    }

    @PutMapping("/cart")
    @ResponseStatus(HttpStatus.OK)
    public CartResponse updateCart(@RequestBody CartRequest cartRequest) {
        return cartItemService.updateCartItems(cartRequest);
    }

    @DeleteMapping("/cart/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public CartItemDto removeProductFromShoppingCart(@PathVariable("productId") int productId) {
        return cartItemService.removeProductFromCart(productId);
    }
}
