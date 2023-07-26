package sergei.webshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sergei.webshop.cache.ProductCache;
import sergei.webshop.dto.ProductDTO;
import sergei.webshop.entity.Category;
import sergei.webshop.entity.Product;
import sergei.webshop.exception.NotEnoughInStockException;
import sergei.webshop.repository.CategoryRepository;
import sergei.webshop.repository.ProductRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ProductCache productCache;

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
        List<Product> products = productRepository.findAllByOrderById();
        List<ProductDTO> productDTOs = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> deleteProduct(Long id) {
        productRepository.deleteById(id);
        List<Product> products = productRepository.findAllByOrderById();
        List<ProductDTO> productDTOs = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> getProduct(Long id) throws ExecutionException {
//        Product product = productRepository.findById(id).get();
        Product product = productCache.getProduct(id);
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(Long id, ProductDTO productDTO) throws ExecutionException {
//        Product productToUpdate = productRepository.findById(id).orElse(null);
        Product productToUpdate = productCache.getProduct(id);
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

    @Override
    public ResponseEntity<List<ProductDTO>> increaseStock(Long id) throws ExecutionException {
//        Product product = productRepository.findById(id).orElse(null); // Replace with cache
        Product product = productCache.getProduct(id);
        product.setStock(product.getStock() + 1);
        productRepository.save(product);
        productCache.refreshProduct(id, product); // Update cache to have the latest version of the product
        List<Product> products = productRepository.findAllByOrderById();

        return new ResponseEntity<>(products.stream()
                .map(product1 -> modelMapper.map(product1, ProductDTO.class))
                .toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> decreaseStock(Long id) throws NotEnoughInStockException, ExecutionException {
//        Product product = productRepository.findById(id).orElse(null); // Replace with cache
        Product product = productCache.getProduct(id);
        if (product.getStock() == 0) {
            throw new NotEnoughInStockException("Product is out of stock.");
        }
        product.setStock(product.getStock() - 1);
        productRepository.save(product);
        productCache.refreshProduct(id, product); // Update cache to have the latest version of the product
        List<Product> products = productRepository.findAllByOrderById();

        return new ResponseEntity<>(products.stream()
                .map(product1 -> modelMapper.map(product1, ProductDTO.class))
                .toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<ProductDTO>> getAllProducts(Pageable pageable) {
//        return productRepository.findAllByOrderById(pageable);

        Page<Product> products = productRepository.findAllByOrderById(pageable);
        Page<ProductDTO> productDTOs = products.map(product -> modelMapper.map(product, ProductDTO.class));
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }
}
