package com.impact.karma.common.business.bom;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Company {
	private String name;
	private String catchPhrase;
	private String bs;
}
