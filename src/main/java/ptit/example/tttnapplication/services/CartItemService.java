package ptit.example.tttnapplication.services;

import ptit.example.tttnapplication.dto.request.CartRequest;
import ptit.example.tttnapplication.dto.response.CartItemDto;
import ptit.example.tttnapplication.dto.response.CartResponse;

public interface CartItemService {
    CartResponse getAllCartItemsOfCustomer();

    CartItemDto addProductToCart(int productId);

    CartItemDto removeProductFromCart(int productId);

    CartResponse updateCartItems(CartRequest cartRequest);
}
