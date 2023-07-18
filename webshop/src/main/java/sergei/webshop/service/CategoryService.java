package sergei.webshop.service;

import org.springframework.http.ResponseEntity;
import sergei.webshop.dto.CategoryDTO;
import sergei.webshop.entity.Category;

import java.util.List;

public interface CategoryService {

    ResponseEntity<List<Category>> findAll();

    ResponseEntity<CategoryDTO> addOne(CategoryDTO categoryDTO);

    ResponseEntity<String> deleteOne(CategoryDTO category);

    ResponseEntity<?> findOne(Long id);

    ResponseEntity<CategoryDTO> updateOne(Long id, CategoryDTO categoryDTO);
}
