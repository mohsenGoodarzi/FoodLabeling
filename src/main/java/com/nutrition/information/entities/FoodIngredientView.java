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

@NoArgsConstructor
@AllArgsConstructor

public class FoodIngredientView {
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
	@Getter
	@Setter
	@Column(nullable = true, name = "fat", insertable = false, updatable = false)
	private float fat;
	@Getter
	@Setter
	@Column(nullable = true, name = "carbs", insertable = false, updatable = false)
	private float carbs;
	@Getter
	@Setter
	@Column(nullable = true, name = "protein", insertable = false, updatable = false)
	private float protein;
	@Getter
	@Setter
	@Column(nullable = true, name = "calory", insertable = false, updatable = false)
	private float calory;
}
