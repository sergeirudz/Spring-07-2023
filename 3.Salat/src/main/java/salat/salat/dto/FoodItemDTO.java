package salat.salat.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

/*
@Data
public class FoodItemDTO implements Serializable {

    private Long id;
    private String foodName;
    private double protein;
    private double fat;
    private double carbs;
}
*/

@Entity
@Data
@Table(name = "food_item")
public class FoodItemDTO implements Serializable {


    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "protein")
    private double protein;

    @Column(name = "fat")
    private double fat;

    @Column(name = "carbs")
    private double carbs;
}
