package sergei.phonesaleforward.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sergei.phonesaleforward.dto.Product;
import sergei.phonesaleforward.dto.ProductPM;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts(
            @RequestParam("category") Optional<String> category,
            @RequestParam("brand") Optional<String> brand
    ) {
        RestTemplate restTemplate = new RestTemplate();

        ProductPM productPM = restTemplate.getForObject(
                "https://dummyjson.com/products",
                ProductPM.class);


        List<Product> allProducts = productPM.getProducts();
        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : allProducts) {
            boolean includeProduct = true;

            // Check if the provided category is present and match the product's category
            if (category.isPresent() && !product.getCategory().equalsIgnoreCase(category.get())) {
                includeProduct = false;
            }

            // Check if the provided brand is present and match the product's brand
            if (brand.isPresent() && !product.getBrand().equalsIgnoreCase(brand.get())) {
                includeProduct = false;
            }

            if (includeProduct) {
                filteredProducts.add(product);
            }
        }

        return filteredProducts;
    }
}