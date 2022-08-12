package ptit.example.tttnapplication.services;

import ptit.example.tttnapplication.data.entity.Product;
import ptit.example.tttnapplication.dto.request.ProductRequest;
import ptit.example.tttnapplication.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    ProductResponse getProductByIdDto(Integer productId);
    ProductResponse createProduct(ProductRequest dto);
    ProductResponse updateProduct(Integer productId, ProductRequest dto);
    ProductResponse deleteProduct(Integer productId);
}
