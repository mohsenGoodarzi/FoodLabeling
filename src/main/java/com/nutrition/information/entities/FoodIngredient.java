package com.nutrition.information.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class FoodIngredient  {
	@Getter
	@Setter
	@EmbeddedId
	private FoodIngredientId foodIngredientId;
	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Unit.class)
	@JoinColumn(name="unitId",columnDefinition="varchar(100) default 'Not Specified'" ,nullable = false)
	private Unit unitId;
	@Getter
	@Setter
	@Column(columnDefinition = "float default 0 ", nullable = true, name = "amount")
	private float amount;
	
}
