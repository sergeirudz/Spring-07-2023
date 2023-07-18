package sergei.webshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sergei.webshop.dto.CategoryDTO;
import sergei.webshop.entity.Category;
import sergei.webshop.service.CategoryService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("categories") // http://localhost:8080/categories
    public ResponseEntity<List<Category>> getCategories() {
        return categoryService.findAll();
    }

    @PostMapping("categories")
    public ResponseEntity<CategoryDTO> addCategory(
            @RequestBody CategoryDTO categoryDTO) {
        return categoryService.addOne(categoryDTO);
    }

    @DeleteMapping("categories")
    public ResponseEntity<String> deleteCategory(
            @RequestBody CategoryDTO category) {
        return categoryService.deleteOne(category);
    }

    @GetMapping("categories/{id}")
    public ResponseEntity<?> getCategory(
            @PathVariable Long id) {
        return categoryService.findOne(id);
    }

    @PatchMapping("categories/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateOne(id, categoryDTO);
    }
}
