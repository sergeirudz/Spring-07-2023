package sergei.webshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import sergei.webshop.dto.ProductDTO;
import sergei.webshop.entity.Product;
import org.springframework.web.bind.annotation.*;
import sergei.webshop.exception.NotEnoughInStockException;
import sergei.webshop.service.ProductService;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
     return productService.getAllProducts();
    }

    @GetMapping("public-products")
    public ResponseEntity<Page<ProductDTO>> getPublicProducts(
            Pageable pageable
    ) {
        // localhost:8080/public-products?page=0&size=2&sort=id,desc„
        // http://localhost:8080/public-products?pageIndex=1&size=2
        /*
        size of page is: 2
        return 1st page with 2 products
        * */
        return productService.getAllProducts(pageable);
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
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) throws ExecutionException {
        return productService.getProduct(id);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<ProductDTO> editProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) throws ExecutionException {
        return productService.updateProduct(id, productDTO);
    }

    @PatchMapping("increase-stock/{id}")
    public ResponseEntity<List<ProductDTO>> increaseStock(
            @PathVariable Long id
    ) throws ExecutionException {
        return productService.increaseStock(id);
    }

    @PatchMapping("decrease-stock/{id}")
    public ResponseEntity<List<ProductDTO>> decreaseStock(
            @PathVariable Long id
    ) throws NotEnoughInStockException, ExecutionException {
        return productService.decreaseStock(id);
    }
}
