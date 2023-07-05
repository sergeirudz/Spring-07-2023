package salat.salat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import salat.salat.dto.FoodItemDTO;
import salat.salat.service.FoodService;

@RequiredArgsConstructor
@RestController
public class FoodController {

    private final FoodService foodService;

    @PostMapping("food/add") // http://localhost:8080/food/add
    public FoodItemDTO addFoodItem(
            @RequestBody FoodItemDTO foodItemDTO) {
        {
            return foodService.addFoodItem(foodItemDTO);
        }

    }
}
