package sergei.webshop.service;

import org.springframework.http.ResponseEntity;
import sergei.webshop.dto.ProductDTO;
import sergei.webshop.entity.Product;

import java.util.List;

public interface ProductService {

    ResponseEntity<ProductDTO> addProduct(Product productDTO);

    ResponseEntity<List<ProductDTO>> getAllProducts();

    ResponseEntity<List<ProductDTO>> deleteProduct(Long id);

    ResponseEntity<ProductDTO> getProduct(Long id);

    ResponseEntity<ProductDTO> updateProduct(Long id, ProductDTO productDTO);
}
