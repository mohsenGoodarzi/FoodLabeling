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
public class CuisineType implements Comparable <CuisineType> {
	
	@Getter
	@Setter
	@Id
	private String cuisineTypeId;
	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="member", nullable=true)
	private CuisineType member;
	
	@Override
	public int compareTo(CuisineType o) {
		
		
		return this.getCuisineTypeId().compareTo(o.getCuisineTypeId());
	}
	
	
}
