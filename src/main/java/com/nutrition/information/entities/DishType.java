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

@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DishType implements Comparable<DishType> {
	
	@Getter
	@Setter
	@Id
	private String dishTypeId;
	@Setter
	@Getter
	@ManyToOne(cascade = CascadeType.ALL , targetEntity = DishType.class)
	@JoinColumn(name="member", nullable=true)
	private DishType member;
	@Override
	public int compareTo(DishType o) {
		
		return this.getDishTypeId().compareTo(o.getDishTypeId());
	}
}
