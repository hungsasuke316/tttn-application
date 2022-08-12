package ptit.example.tttnapplication.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.example.tttnapplication.data.entity.Product;
import ptit.example.tttnapplication.data.repositpty.ProductRepository;
import ptit.example.tttnapplication.dto.request.ProductRequest;
import ptit.example.tttnapplication.dto.response.ProductResponse;
import ptit.example.tttnapplication.exceptions.ResourceNotAcceptException;
import ptit.example.tttnapplication.exceptions.ResourceNotFoundException;
import ptit.example.tttnapplication.services.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public ProductResponse getProductByIdDto(Integer productId) {
        Optional<Product> productOptional = this.productRepository.findById(productId);
        if (productOptional.isPresent()){
            Product product = productOptional.get();
            return modelMapper.map(product, ProductResponse.class);
        }
        throw new ResourceNotFoundException("Product Not Found");
    }

    @Override
    public ProductResponse createProduct(ProductRequest dto) {
        Optional<Product> productOptional = this.productRepository.findByName(dto.getName());

        if (productOptional.isPresent()){
            throw new ResourceNotAcceptException("Product Name already exist");
        }
        Product product = modelMapper.map(dto, Product.class);
        product.setStatus(true);
        Product saveProduct =productRepository.save(product);
        return modelMapper.map(saveProduct, ProductResponse.class);
    }

    @Override
    public ProductResponse updateProduct(Integer productId, ProductRequest dto) {
        Product product = productRepository.findById(productId).get();
        modelMapper.map(dto,product);
        product = productRepository.save(product);
        return  modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public ProductResponse deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId).get();

        if(product.getStatus().equals(true)){
            product.setStatus(false);
            product = productRepository.save(product);
        }
        else if(product.getStatus().equals(false)){
            product.setStatus(true);
            product = productRepository.save(product);
        }
        return  modelMapper.map(product, ProductResponse.class);
    }
}
