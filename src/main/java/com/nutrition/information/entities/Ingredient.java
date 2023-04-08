package com.nutrition.information.entities;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name =  "Ingredient")
@EqualsAndHashCode
@NoArgsConstructor
public class Ingredient {
	
	@Getter
	@Setter
	@Id
	private String ingredientId;
	
	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = IngredientType.class)
	@JoinColumn(columnDefinition = "varchar(100) default 'Not Specified'", name="ingredientType")
	private IngredientType ingredientType;
	
	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL,  targetEntity = Unit.class)
	@JoinColumn(columnDefinition = "varchar(100) default 'Not Specified'", name="unitId")
	private Unit unitId;
	
	@Getter
	@Setter
	private float amount;
	
	@Getter
	@Setter
	private float fat;
	
	@Getter
	@Setter
	private float carb;
	
	@Getter
	@Setter
	private float protein;
	
	@Getter
	@Setter
	private float calory;
	
	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL,  targetEntity = Warning.class)
	@JoinColumn(columnDefinition = "nvarchar(100) default 'Not Specified'", name="warningId")
	private Warning warningId;
	
	public Ingredient(String ingredientId,IngredientType ingredientType, Unit unitId, float amount, float fat, float carb, float protein, float calory, Warning warningId) {
		
		this.ingredientId = ingredientId;
		this.ingredientType = ingredientType;
		this.unitId = unitId;
		this.amount = amount;
		
	}

}
