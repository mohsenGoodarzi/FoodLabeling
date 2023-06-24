package com.nutrition.information.entities;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "IngredientType")
@NoArgsConstructor
@AllArgsConstructor
public class IngredientType implements Comparable<IngredientType> {

	@Override
	public int hashCode() {
		return Objects.hash(ingredientTypeId, member.getIngredientTypeId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IngredientType other = (IngredientType) obj;
		return Objects.equals(ingredientTypeId, other.ingredientTypeId)
				&& Objects.equals(member.getIngredientTypeId(), other.member.getIngredientTypeId());
	}

	@Getter
	@Setter
	@Id
	@Column(name = "ingredientTypeId")
	private String ingredientTypeId;

	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "member", nullable = true)
	private IngredientType member;

	@Override
	public int compareTo(IngredientType o) {

		return this.getIngredientTypeId().compareTo(o.getIngredientTypeId());
	}

	@Override
	public String toString() {
		return "IngredientType [ingredientTypeId=" + ingredientTypeId + ", member=" + member.ingredientTypeId + "]";
	}

}
