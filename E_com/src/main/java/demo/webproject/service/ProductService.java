package demo.webproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import demo.webproject.entity.Product;
import demo.webproject.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    // Optional: update product by ID
    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> existing = repository.findById(id);
        if (existing.isEmpty()) {
            return null;
        }

        Product product = existing.get();
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setImg(productDetails.getImg());
        product.setRating(productDetails.getRating());
        product.setStock(productDetails.getStock());
        product.setPrice(productDetails.getPrice());

        return repository.save(product);
    }

    // Add this delete method
    public boolean deleteProduct(Long id) {
        Optional<Product> existing = repository.findById(id);
        if (existing.isEmpty()) {
            return false; // product not found
        }
        repository.deleteById(id);
        return true; // product deleted
    }
}
