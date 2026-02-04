package it.unibg.accessibilita.base.ui.component;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import struttura.Ostacolo;
import struttura.Stanza;

class DialogMappaTest {
	
	@Test
	void dialogOstacolo_nonVuoto() {
		Ostacolo ostacolo = new Ostacolo(1, "Gradino", null, "esempio", 0, 0, null, null, 0);
		DialogMappa dm = new DialogMappa(ostacolo);	
		assertNotNull(dm);
	}
	@Test
	void dialogElemento_nonVuoto() {
		Stanza s = new Stanza(0, null, 0, null, false, 0, 0, null, null, null, 0);
		DialogMappa dm = new DialogMappa(s);
		assertNotNull(dm);
	}
}
