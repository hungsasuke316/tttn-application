package ptit.example.tttnapplication.controllers.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ptit.example.tttnapplication.data.entity.Product;
import ptit.example.tttnapplication.dto.request.ProductRequest;
import ptit.example.tttnapplication.dto.response.ProductResponse;
import ptit.example.tttnapplication.services.ProductService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/employee")
public class ProductManagementController {
    private final ProductService productService;

    @Autowired
    public ProductManagementController(ProductService productService) {
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

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponse createProduct(@Valid @RequestBody ProductRequest dto){
        return this.productService.createProduct(dto);
    }

    @PutMapping("/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    ProductResponse updateProduct(@PathVariable("productId") Integer productId, @Valid @RequestBody ProductRequest dto){
        return this.productService.updateProduct(productId,dto);
    }

    @DeleteMapping("/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    ProductResponse deleteProduct(@PathVariable("productId") Integer productId){
        return this.productService.deleteProduct(productId);
    }
}
