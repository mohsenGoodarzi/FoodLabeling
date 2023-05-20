package com.nutrition.information.entities;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class CuisineType{
	
	@Getter
	@Setter
	@Id
	@Column(name="cuisineTypeId")
	private String cuisineTypeId;
	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="member", nullable=true)
	private CuisineType member;
	
	// This class is self referenced to itself. It requires manual implementation of hashCode, equals and toString
	@Override
	public String toString() {
		return "CuisineType [cuisineTypeId=" + cuisineTypeId + ", member=" + member.getCuisineTypeId() + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(this.getCuisineTypeId(), member.getCuisineTypeId());
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuisineType other = (CuisineType) obj;
		return Objects.equals(cuisineTypeId, other.cuisineTypeId) && Objects.equals(member.getCuisineTypeId(), other.member.getCuisineTypeId());
	}
}
