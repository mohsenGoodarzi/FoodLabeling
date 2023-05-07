package com.nutrition.information.entities;

import java.util.function.Predicate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="unit")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Unit implements Comparable<Unit>, Predicate<Unit>{
	
	@Getter
	@Setter
	@Id
	@Column(name="unit_id")
	private String unitId;
	@Getter
	@Setter
	@Column(name="to_gram")
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
