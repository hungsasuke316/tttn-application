package ptit.example.tttnapplication.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ptit.example.tttnapplication.data.entity.Product;
import ptit.example.tttnapplication.dto.response.ProductResponse;
import ptit.example.tttnapplication.services.ProductService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/customer")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    ProductResponse getProductById(@PathVariable("productId") Integer productId){
        return this.productService.getProductByIdDto(productId);
    }
}
