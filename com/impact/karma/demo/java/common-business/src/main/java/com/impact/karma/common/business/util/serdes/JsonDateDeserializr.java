package com.impact.karma.common.business.util.serdes;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.impact.karma.common.business.util.DateUtil;

import lombok.Getter;
import lombok.Setter;

/**
 * @author user
 * Default DateFormat is DateUtil.DATE_001
 */
public final class JsonDateDeserializr extends JsonDeserializer<LocalDateTime> {
	@Setter
	@Getter
	private String pattern = DateUtil.DATE_001;

	public JsonDateDeserializr() {
	}

	private JsonDateDeserializr(String pattern) {
		setPattern(pattern);
	}

	@Override
	public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		ObjectCodec oc = jp.getCodec();
		TextNode node = (TextNode) oc.readTree(jp);
		String dateString = node.textValue();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPattern());
		return LocalDateTime.parse(dateString, formatter);
	}

	public static JsonDateDeserializr of(String pattern) {
		return new JsonDateDeserializr(pattern);
	}
}