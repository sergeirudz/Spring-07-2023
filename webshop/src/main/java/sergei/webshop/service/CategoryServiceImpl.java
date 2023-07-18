package sergei.webshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sergei.webshop.dto.CategoryDTO;
import sergei.webshop.entity.Category;
import sergei.webshop.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = categoryRepository.findAll();
        HttpStatus status = HttpStatus.OK;

        if (categories.isEmpty()) {
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(categories, status);
    }

    @Override
    public ResponseEntity<CategoryDTO> addOne(CategoryDTO categoryDTO) {

        Category existingCategory = categoryRepository.findByName(categoryDTO.getName());
        if (existingCategory != null) {
            throw new IllegalArgumentException("Category with the same name already exists.");
        }

        Category category = new Category();
        category.setName(categoryDTO.getName());
        categoryRepository.save(category);

        CategoryDTO createdCategoryDTO = modelMapper.map(category, CategoryDTO.class);
        return new ResponseEntity<>(createdCategoryDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteOne(CategoryDTO categoryDTO) {
        Category foundCategory = categoryRepository.findByName(categoryDTO.getName());


        if (foundCategory != null) {
            categoryRepository.delete(foundCategory);
            String successMessage = "Category " + categoryDTO.getName() + " deleted";
            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        } else {
            String errorMessage = "Category " + categoryDTO.getName() + " not found";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> findOne(Long id) { // HOW TO SET RETURN TYPE STRING OR CATEGORY?
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()) {
            Category foundCategory = optionalCategory.get();
            return new ResponseEntity<>(foundCategory, HttpStatus.OK);
        } else {
            String errorMessage = "Category with id " + id + " not found";
            return new ResponseEntity<>(errorMessage ,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<CategoryDTO> updateOne(Long id, CategoryDTO categoryDTO) {
        Category foundCategory = categoryRepository.findById(id).orElse(null);

        if (foundCategory != null) {
            foundCategory.setName(categoryDTO.getName());
            categoryRepository.save(foundCategory);
            CategoryDTO updatedCategoryDTO = modelMapper.map(foundCategory, CategoryDTO.class);
            return new ResponseEntity<>(updatedCategoryDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
