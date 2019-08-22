package com.antkorwin.stringtemplate;


public class ValuePattern {
	private final String pattern;
	private final Object value;

	public ValuePattern(String pattern, Object value) {
		this.pattern = pattern;
		this.value = value;
	}

	public String getPattern() {
		return pattern;
	}

	public Object getValue() {
		return value;
	}
}