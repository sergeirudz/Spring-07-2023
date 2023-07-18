package sergei.webshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import sergei.webshop.dto.ProductDTO;
import sergei.webshop.entity.Product;
import org.springframework.web.bind.annotation.*;
import sergei.webshop.service.ProductService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
     return productService.getAllProducts();
    }

    @PostMapping("products")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product productDTO) {
        return productService.addProduct(productDTO);
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<List<ProductDTO>> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }
}
