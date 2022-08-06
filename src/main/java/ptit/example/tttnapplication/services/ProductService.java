package ptit.example.tttnapplication.services;

import ptit.example.tttnapplication.data.entity.Product;
import ptit.example.tttnapplication.dto.request.ProductRequestDto;
import ptit.example.tttnapplication.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    ProductResponse getProductByIdDto(Integer productId);
    ProductResponse createProduct(ProductRequestDto dto);
    ProductResponse updateProduct(Integer productId, ProductRequestDto dto);
    ProductResponse deleteProduct(Integer productId);
}
