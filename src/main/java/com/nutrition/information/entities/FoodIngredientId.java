package com.nutrition.information.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FoodIngredientId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Food.class)
	@JoinColumn(name = "food_id", columnDefinition = "VARCHAR(200) default 'Not Specified'", nullable = false)
	private Food foodId;

	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Ingredient.class)
	@JoinColumn(name = "ingredient_id", columnDefinition = "VARCHAR(200) default 'Not Specified'", nullable = false)
	private Ingredient ingredientId;

}
