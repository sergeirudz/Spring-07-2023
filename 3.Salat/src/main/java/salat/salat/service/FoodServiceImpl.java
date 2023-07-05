package salat.salat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salat.salat.dto.FoodItemDTO;

@Service
public class FoodServiceImpl implements FoodService {

//    @Autowired
    private FoodService foodService;

    @Override
    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {

//        FoodItemDTO foodItem = new FoodItemDTO();
//        foodItem.setFoodName(foodItemDTO.getFoodName());
//        foodItem.setProtein(foodItemDTO.getProtein());
//        foodItem.setFat(foodItemDTO.getFat());
//        foodItem.setCarbs(foodItemDTO.getCarbs());
//        foodService.addFoodItem(foodItem);
//        return foodItem;
        return null;
    }
}
