package com.antkorwin.stringtemplate;

import java.util.HashMap;
import java.util.Map;

public class StringTemplate {

	private String stringPattern;
	private Map<String, ValuePattern> params = new HashMap<>();

	public StringTemplate pattern(String pattern) {
		this.stringPattern = pattern;
		return this;
	}

	public StringTemplate param(String name, String pattern, Object value) {
		params.put(name, new ValuePattern(pattern, value));
		return this;
	}

	public StringTemplate param(String name, Object value) {
		params.put(name, new ValuePattern("%s", value));
		return this;
	}

	public String build() {
		params.forEach((k, v) -> {
			stringPattern = stringPattern.replace(String.format("{%s}", k), String.format(v.getPattern(), v.getValue()));
		});
		return stringPattern;
	}
}