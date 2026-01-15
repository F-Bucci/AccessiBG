package it.unibg.accessibilita.base.ui.component;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ThemeToggleButtonTest {
	
	@Test
	public void visualizzaTemaChiaro(){
		ThemeToggleButton btn = new ThemeToggleButton();
		btn.update(true);
		assertEquals("Tema Chiaro", btn.getText());
	}
	
	@Test
	public void visualizzaTemaScuro(){
		ThemeToggleButton btn = new ThemeToggleButton();
		btn.update(false);
		assertEquals("Tema Scuro", btn.getText());
	
	}
}