package it.unibg.accessibilita.base.ui.component;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class AppButtonTest {

	@Test
	void bottone_nonVuoto() {
		AppButton btn = new AppButton();
		assertNotNull(btn);
	}
}
