package salat.salat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "food_item")
public class FoodItem {


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
