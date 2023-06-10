package com.nutrition.information.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
import lombok.ToString;

@Entity
@Table
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Food implements Comparable<Food> {
	
	@Getter
	@Setter
	@Id
	@Column(name = "foodId", columnDefinition = "VARCHAR(200) default 'Not Specified' ", nullable = false)
	private String foodId;
	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = DishType.class)
	@JoinColumn(name="dishTypeId",columnDefinition="varchar(100) default 'Not Specified'" ,nullable = false)
	private DishType dishType;
	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = CuisineType.class)
	@JoinColumn(name="cuisineTypeId",columnDefinition="varchar(100) default 'Not Specified'" , nullable = false)
	private CuisineType cuisineType;
	@Getter
	@Setter
	@Column(columnDefinition = "VARCHAR(13) default 'Not Specified' CHECK (foodType IN ('Not Specified', 'Vegetarian', 'Carnivore'))", nullable = false, name = "foodType")
	private String foodType;
	@Override
	public int compareTo(Food o) {
		
		return this.foodId.compareTo(o.foodId);
	}
	
	
}
