package com.nutrition.information.entities;

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
@Table(name = "unit")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Unit {

	@Getter
	@Setter
	@Id
	@Column(name = "unit_id")
	private String unitId;

	@Getter
	@Setter
	@Column(name = "to_gram")
	private double toGram;

}
