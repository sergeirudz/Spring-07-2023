package sergei.webshop.service;

import org.springframework.http.ResponseEntity;
import sergei.webshop.dto.ProductDTO;
import sergei.webshop.entity.Product;
import sergei.webshop.exception.NotEnoughInStockException;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ProductService {

    ResponseEntity<ProductDTO> addProduct(Product productDTO);

    ResponseEntity<List<ProductDTO>> getAllProducts();

    ResponseEntity<List<ProductDTO>> deleteProduct(Long id);

    ResponseEntity<ProductDTO> getProduct(Long id) throws ExecutionException;

    ResponseEntity<ProductDTO> updateProduct(Long id, ProductDTO productDTO) throws ExecutionException;

    ResponseEntity<List<ProductDTO>> increaseStock(Long id) throws ExecutionException;

    ResponseEntity<List<ProductDTO>> decreaseStock(Long id) throws NotEnoughInStockException, ExecutionException;
}
