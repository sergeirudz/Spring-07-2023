package sergei.webshop.service;

import org.springframework.http.ResponseEntity;
import sergei.webshop.dto.ProductDTO;
import sergei.webshop.entity.Product;
import sergei.webshop.exception.NotEnoughInStockException;

import java.util.List;

public interface ProductService {

    ResponseEntity<ProductDTO> addProduct(Product productDTO);

    ResponseEntity<List<ProductDTO>> getAllProducts();

    ResponseEntity<List<ProductDTO>> deleteProduct(Long id);

    ResponseEntity<ProductDTO> getProduct(Long id);

    ResponseEntity<ProductDTO> updateProduct(Long id, ProductDTO productDTO);

    ResponseEntity<List<ProductDTO>> increaseStock(Long id);

    ResponseEntity<List<ProductDTO>> decreaseStock(Long id) throws NotEnoughInStockException;
}
