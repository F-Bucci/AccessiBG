package it.unibg.accessibilita.base.ui.component;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GoogleMapCardTest {
	
	@Test 
	void creazioneMappa(){
		String url = "https://www.google.com/maps/prova";
		GoogleMapCard card = new GoogleMapCard(url);
		assertNotNull(card);
	}
}
