package com.nutrition.information.entities;

import java.util.function.Predicate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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
public class Unit implements Comparable<Unit>, Predicate<Unit>{
	
	@Getter
	@Setter
	@Id
	private String unitId;
	@Getter
	@Setter
	private double toGram;
	@Override
	public int compareTo(Unit o) {
		
		return this.getUnitId().compareTo(o.getUnitId());
	}
	@Override
	public boolean test(Unit t) {
		
		int result = this.compareTo(t);
		if (result == 0) {
			
			return true;
		}
		return false;
	}
	
	

}
