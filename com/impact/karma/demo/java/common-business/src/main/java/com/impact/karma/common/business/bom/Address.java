package com.impact.karma.common.business.bom;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	@Embedded
	private Geo geo;

}
