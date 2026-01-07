package it.unibg.accessibilita.base.ui.component;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.vaadin.flow.component.html.Paragraph;

public class AppFooterTest {

	@Test
	//VOGLIO TESTARE CHE L'ANNO CHE VIENE MOSTRATO NEL FOOTER SIA QUELLO CORRENTE.
	//COMUNQUE E' STATO VERIFICATO DI PERSONA IL CAMBIO DI ANNO AUTOMATICO.
	//SUCCESS
	public void deveMostrareTestoEAnnoCorrente() {
		
		AppFooter footer = new AppFooter();
		Paragraph paragrafo =(Paragraph) footer.getComponentAt(1);
		
		int annoCorrente = LocalDate.now().getYear();
		String risultato = "@" + annoCorrente + " AccessiBG";
		
		assertEquals(risultato, paragrafo.getText());
	}
}
