package com.devops.product_api;

import com.devops.product_api.entity.Product;
import com.devops.product_api.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
    @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable Long id) {
    productRepository.deleteById(id);
}
    @PutMapping("/{id}")
public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
    Product product = productRepository.findById(id).orElseThrow();

    product.setName(updatedProduct.getName());
    product.setPrice(updatedProduct.getPrice());

    return productRepository.save(product);
}
}
