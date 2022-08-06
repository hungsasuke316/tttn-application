package ptit.example.tttnapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ptit.example.tttnapplication.data.entity.Product;
import ptit.example.tttnapplication.dto.request.ProductRequestDto;
import ptit.example.tttnapplication.dto.response.ProductResponse;
import ptit.example.tttnapplication.services.ProductService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    ProductResponse getProductById(@PathVariable("productId") Integer productId){
        return this.productService.getProductByIdDto(productId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponse createProduct(@Valid @RequestBody ProductRequestDto dto){
        return this.productService.createProduct(dto);
    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    ProductResponse updateProduct(@PathVariable("productId") Integer productId, @Valid @RequestBody ProductRequestDto dto){
        return this.productService.updateProduct(productId,dto);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    ProductResponse deleteProduct(@PathVariable("productId") Integer productId){
        return this.productService.deleteProduct(productId);
    }
}
