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

@EqualsAndHashCode
@Entity
@Table(name="dish_type")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DishType implements Comparable<DishType> {
	
	@Getter
	@Setter
	@Id
	@Column(name="dish_type_id")
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
