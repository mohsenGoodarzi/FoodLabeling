package com.nutrition.information.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ErrorView {

	@Getter
	@Setter
	private int status;

	@Getter
	@Setter
	private String title;

	@Getter
	@Setter
	private String message;

}
