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

@Entity(name = "DishType")
@Table(name = "DishType")
@NoArgsConstructor
@AllArgsConstructor
public class DishType implements Comparable<DishType> {

	@Override
	public String toString() {
		return "DishType [dishTypeId=" + dishTypeId + ", member=" + member.getDishTypeId() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dishTypeId, member.getDishTypeId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DishType other = (DishType) obj;
		return Objects.equals(dishTypeId, other.dishTypeId)
				&& Objects.equals(member.getDishTypeId(), other.member.getDishTypeId());
	}

	@Getter
	@Setter
	@Id
	@Column
	private String dishTypeId;

	@Setter
	@Getter
	// CascadeType.ALL is equivalent to cascade={PERSIST, MERGE, REMOVE, REFRESH, DETACH}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "member", nullable = true)
	private DishType member;

	@Override
	public int compareTo(DishType o) {

		return this.getDishTypeId().compareTo(o.getDishTypeId());
	}

}
