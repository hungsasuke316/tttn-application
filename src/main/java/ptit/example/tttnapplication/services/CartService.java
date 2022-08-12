package ptit.example.tttnapplication.services;

import ptit.example.tttnapplication.data.entity.Cart;

public interface CartService {
    Cart findCartByEmail(String  email);
}
