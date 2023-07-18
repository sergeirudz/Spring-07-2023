package sergei.webshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sergei.webshop.dto.ProductDTO;
import sergei.webshop.entity.Category;
import sergei.webshop.entity.Product;
import sergei.webshop.repository.CategoryRepository;
import sergei.webshop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<ProductDTO> addProduct(Product productDTO) {

        Category category = categoryRepository.findById(productDTO.getCategory().getId()).get();

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        product.setActive(productDTO.isActive());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        product.setCategory(category);
        product.setCategory(category);
        productRepository.save(product);

        ProductDTO createdProductDTO = modelMapper.map(product, ProductDTO.class);

        return new ResponseEntity<>(createdProductDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> deleteProduct(Long id) {
        productRepository.deleteById(id);
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> getProduct(Long id) {
        Product product = productRepository.findById(id).get();
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(Long id, ProductDTO productDTO) {
        Product productToUpdate = productRepository.findById(id).orElse(null);

        if (productToUpdate == null) {
            throw new IllegalArgumentException("Product with the given id does not exist.");
        }

        productToUpdate.setName(productDTO.getName());
        productToUpdate.setPrice(productDTO.getPrice());
        productToUpdate.setImage(productDTO.getImage());
        productToUpdate.setActive(productDTO.isActive());
        productToUpdate.setDescription(productDTO.getDescription());
        productToUpdate.setStock(productDTO.getStock());

        if (productDTO.getCategory() != null && productDTO.getCategory().getId() != null) {
            Category newCategory = categoryRepository.findById(productDTO.getCategory().getId()).orElse(null);
            if (newCategory == null) {
                throw new IllegalArgumentException("Category with the given id does not exist.");
            }
            productToUpdate.setCategory(newCategory);
        }

        productRepository.save(productToUpdate);

        return new ResponseEntity<>(modelMapper.map(productToUpdate, ProductDTO.class), HttpStatus.OK);
    }
}
