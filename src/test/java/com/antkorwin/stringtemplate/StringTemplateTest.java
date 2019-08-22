package com.antkorwin.stringtemplate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StringTemplateTest {

	private StringTemplate template = new StringTemplate();


	@Test
	void decimalValue() {
		// Act
		String result = template.pattern("Distance = {distance} mm")
		                        .param("distance", 123)
		                        .build();
		// Assert
		assertThat(result).isEqualTo("Distance = 123 mm");
	}

	@Test
	void hexValue() {
		// Act
		String result = template.pattern("size = {size} bytes")
		                        .param("size", "0x%x",255)
		                        .build();
		// Assert
		assertThat(result).isEqualTo("size = 0xff bytes");
	}

	@Test
	void mixedParams() {
		// Act
		String result = template.pattern("{distance}00{temperature}00__{direction}")
		                        .param("distance", "%02x", 123)
		                        .param("temperature", 25)
		                        .param("direction", "%d", 1)
		                        .build();
		// Assert
		assertThat(result).isEqualTo("7b002500__1");
	}

	@Test
	void withoutPattern() {
		assertThat(template.build()).isEqualTo(null);
	}

	@Test
	void withoutParams() {
		String result = template.pattern("{distance}{power}").build();
		assertThat(result).isEqualTo("{distance}{power}");
	}
}