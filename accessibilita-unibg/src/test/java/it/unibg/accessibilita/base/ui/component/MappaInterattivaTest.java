package it.unibg.accessibilita.base.ui.component;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class MappaInterattivaTest {
	@Test
	void mappa_nonVuota(){
		MappaInterattiva mi = new MappaInterattiva();
		assertNotNull(mi);
	}
}
