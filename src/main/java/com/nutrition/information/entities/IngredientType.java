package com.nutrition.information.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IngredientType implements Comparable<IngredientType> {
	@Getter
	@Setter
	@Id
	private String ingredientTypeId;
	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="member",  nullable = true)
	private IngredientType member;
	@Override
	public int compareTo(IngredientType o) {
		
		return this.getIngredientTypeId().compareTo(o.getIngredientTypeId());
	}
	

}
