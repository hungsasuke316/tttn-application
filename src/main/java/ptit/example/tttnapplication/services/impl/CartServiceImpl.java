package ptit.example.tttnapplication.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.example.tttnapplication.data.entity.Cart;
import ptit.example.tttnapplication.data.entity.Customer;
import ptit.example.tttnapplication.data.repositpty.AccountRepository;
import ptit.example.tttnapplication.data.repositpty.CustomerRepository;
import ptit.example.tttnapplication.exceptions.ResourceNotFoundException;
import ptit.example.tttnapplication.services.CartService;

@Service
public class CartServiceImpl implements CartService {

    private final AuthenticationServiceImpl authenticationService;
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CartServiceImpl(AuthenticationServiceImpl authenticationService, AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.authenticationService = authenticationService;
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Cart findCartByEmail(String email) {
        Customer customer = this.customerRepository.findByEmail(authenticationService.getAuthentication()).orElseThrow(() ->
                new ResourceNotFoundException("Not Found User"));
        Cart cart = customer.getCart();
        return cart;
    }
}
