package ptit.example.tttnapplication.services.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ptit.example.tttnapplication.data.entity.Cart;
import ptit.example.tttnapplication.data.entity.CartItem;
import ptit.example.tttnapplication.data.entity.CartItemId;
import ptit.example.tttnapplication.data.entity.Product;
import ptit.example.tttnapplication.data.repositpty.CartItemRepository;
import ptit.example.tttnapplication.data.repositpty.CartRepository;
import ptit.example.tttnapplication.data.repositpty.ProductRepository;
import ptit.example.tttnapplication.dto.request.CartRequest;
import ptit.example.tttnapplication.dto.response.CartItemDto;
import ptit.example.tttnapplication.dto.response.CartItemResponse;
import ptit.example.tttnapplication.dto.response.CartResponse;
import ptit.example.tttnapplication.exceptions.ResourceNotFoundException;
import ptit.example.tttnapplication.services.CartItemService;
import ptit.example.tttnapplication.services.CartService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartService cartService;

    private final CartItemRepository cartItemRepository;

    private final CartRepository cartRepository;

    private final ProductRepository productRepository;

    private final ModelMapper mapper;

    private final AuthenticationServiceImpl authenticationService;


    @Override
    public CartResponse getAllCartItemsOfCustomer() {
        String username = authenticationService.getAuthentication();
        Cart cart = cartService.findCartByEmail(username);
        List<CartItemResponse> cartItemsResponses = cartItemRepository.findAllByCart_Id(cart.getId())
                .stream()
                .map(this::mapToCartResponse)
                .collect(Collectors.toList());

        int totalPrice = cartItemsResponses.stream()
                .mapToInt(s -> (s.getCartItemQuantity() * s.getProductPrice()))
                .sum();

        CartResponse cartResponse = new CartResponse();
        cartResponse.setCartId(cart.getId());
        cartResponse.setTotalPrice(totalPrice);
        cartItemsResponses.stream()
                .map(item -> cartResponse.getCartDetails().add(item))
                .collect(Collectors.toList());
        return cartResponse;
    }


    @Override
    public CartItemDto addProductToCart(int productId) {
        String username = authenticationService.getAuthentication();

        Cart cart = cartService.findCartByEmail(username);

        Product product = productRepository.findById(productId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Product not found"));

        Optional<CartItem> item = cartItemRepository.findCartDetailsByProductAndCart(product, cart);

        //if exist -> add +1 quantity to exist item
        if (item.isPresent()) {
            CartItem cartItem = item.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            CartItem savedItem = cartItemRepository.save(cartItem);
            return mapToCartItemDto(savedItem);
        }
        //if new -> create new
        CartItem cartItem = new CartItem();
        cartItem.setId(new CartItemId(productId, cart.getId()));
        cartItem.setProduct(product);
        cartItem.setCart(cart);
        cartItem.setQuantity(1);
        CartItem savedItem = cartItemRepository.save(cartItem);
        return mapToCartItemDto(savedItem);
    }

    @Override
    public CartItemDto removeProductFromCart(int productId) {
        productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        String username = authenticationService.getAuthentication();

        Cart cart = cartService.findCartByEmail(username);
        int cartId = cart.getId();
        int rowEffected = cartItemRepository.deleteFromCartDetailByID(productId, cartId);
        if(rowEffected < 1) throw new ResourceNotFoundException("Server error, try again!");
        else {
            System.out.println("rs: " +rowEffected);
            return CartItemDto.builder()
                    .cartId(cartId)
                    .productId(productId)
                    .quantity(0)
                    .build();
        }
    }

    @Override
    public CartResponse updateCartItems(CartRequest cartRequest) {
        String username = authenticationService.getAuthentication();

        Cart cart = cartService.findCartByEmail(username);
        List<CartItem> cartItems =  cart.getCartItem();
        cartItems.clear();
        //update every item in cart after changing quantity...
        List<Product> products = productRepository.findAll();
        Map<Integer, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getProductId, Function.identity()));

        cartRequest.getCartItem().forEach(item -> {
            if (!productMap.containsKey(item.getProductId())) {
                throw new ResourceNotFoundException(
                        String.format("Product with ID: %s not found", item.getProductId()));
            }

            CartItemId cartItemId = new CartItemId(item.getProductId(), cart.getId());

            CartItem cartItem = new CartItem();
            cartItem.setId(cartItemId);

            cartItem.setQuantity(item.getProductQuantity()); //update new quantity from request

            Product product = productMap.get(item.getProductId());
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            //add item with updated to cart again
            cart.getCartItem().add(cartItem);
            System.out.println(cartItem.getQuantity());
        });

        Cart savedCart = cartRepository.save(cart);
        //map
        CartResponse cartResponse = new CartResponse();
        cartResponse.setCartId(savedCart.getId());
        savedCart.getCartItem().forEach(item -> {
            cartResponse.getCartDetails().add(mapToCartResponse(item));
        });

        return cartResponse;
    }

    private CartItemDto mapToCartItemDto(CartItem cartItem) {
        return mapper.map(cartItem, CartItemDto.class);
    }

    private CartItemResponse mapToCartResponse(CartItem cartItem) {
        return CartItemResponse.builder()
                //.cartId(cartDetail.getId().getCartID())
                .productId(cartItem.getProduct().getProductId())
                .productName(cartItem.getProduct().getName())
                .productPrice(cartItem.getProduct().getPrice())
                .cartItemQuantity(cartItem.getQuantity())
                .productThumbnail(cartItem.getProduct().getThumbnail())
                .build();
    }
}
