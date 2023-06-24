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

@Entity
@Table(name = "warning")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Warning implements Comparable<Warning> {

	@Getter
	@Setter
	@Id
	@Column(name = "warning_id", columnDefinition = "nvarchar(100)")
	private String warningId;

	@Getter
	@Setter
	@Column(columnDefinition = "nvarchar(100) not null check (warning_type in ('Not Specified' ,'Allergic','Children Attention'))",
			name = "warning_type")
	private String warningType;

	@Getter
	@Setter
	@Column(columnDefinition = "nvarchar (6000)")
	private String message;

	@Override
	public int compareTo(Warning o) {

		return this.getWarningId().compareTo(o.getWarningId());
	}

}
