package com.impact.karma.common.business.util.serdes;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.impact.karma.common.business.util.DateUtil;

import lombok.Getter;
import lombok.Setter;

/**
 * @author user Default DateFormat is DateUtil.DATE_001
 */
public class JsonDateSerializr extends JsonSerializer<Date> {
	@Setter
	@Getter
	private String pattern = DateUtil.DATE_001;

	public JsonDateSerializr() {
	}

	private JsonDateSerializr(String pattern) {
		setPattern(pattern);
	}

	/**
	 * Default Date format will be DateUtil.DATE_001
	 */
	public void serialize(Date dt, JsonGenerator jsonGen, SerializerProvider serProv)
			throws IOException, JsonProcessingException {
		DateFormat sdf = new SimpleDateFormat(getPattern());
		String formattedDate = sdf.format(dt);
		jsonGen.writeString(formattedDate);
	}

	public static JsonDateSerializr of(String pattern) {
		return new JsonDateSerializr(pattern);
	}
}
