package it.unibg.accessibilita.base.ui.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H3;

class BoxTest {

	@Test
	//test per verificare se quando il box ha un titolo quest'ultimo viene effettivamente creato col conternuto corretto
	void boxConTitolo_CreaTitolo() {
		String titoloAtteso = "Prova";
		Box box = new Box(titoloAtteso);
		
		Component c = box.getChildren().findFirst().orElse(null);
		
		assertTrue(c instanceof H3);
		assertEquals(titoloAtteso, ((H3)c).getText());
	}
	
	@Test
	//testare nel caso il titolo sia null il boc non dovrebbe essere inizialmente vuoto (zero figli)
	void boxSenzaTitolo_DeveEssereVuoto() {
	Box box = new Box(null);
	
	long l = box.getChildren().count();
	assertEquals(0,l);
	}
	
	@Test
	//test per verificare se viene aggiunto correttamente il testo in una riga 
	void addInfo_AggiungeRigaInfo() {
	Box box = new Box(null);
	box.addInfo("telefono", "12345");
	Component riga = box.getChildren().findFirst().get();
	
	String soggettoAtteso = riga.getElement().getChild(0).getText();
	String valoreAtteso = riga.getElement().getChild(1).getText();
	
	assertEquals("telefono: ", soggettoAtteso);
	assertEquals("12345", valoreAtteso);
	
	}
	@Test
	//testare se viene aggiungo il paragrafo con il testo correttamente
	void addParagrafo_TestoCorretto() {
		Box box = new Box(null);
		String testo = "prova";
		
		box.addParagrafo(testo);
		var e = box.getElement().getChild(0);
		
		assertEquals(testo, e.getText());
		assertEquals("p", e.getTag());
		
	}
}
