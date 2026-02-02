package it.unibg.accessibilita.base.ui.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;

class ImageCardTest {

		@Test
		//VOGLIO TESTARE CHE SE URL=NULL VIENE MOSTRATA L'ICONA
		//SUCCESS
		void aggiungeSlashAUrl() {
			String url = "img/foto.webp";
			ImageCard card = new ImageCard("titolo", url);
			Div imageContainer = (Div) card.getComponentAt(0);
			Component contenuto = imageContainer.getComponentAt(0);
			
			assertTrue(contenuto instanceof Image);
			
			Image image = (Image) contenuto;
			assertEquals("/img/foto.webp", image.getSrc());
		}
		
		@Test
		//verifico che la card viene creata senza errori in caso di valori null 
		void creaImageCard_ValoriNull() {
			ImageCard card = new ImageCard("esempio", null, null, null);

			assertNotNull(card);
			assertEquals(2, card.getComponentCount());
		}
		
		@Test
		//TEST VERIFICA CON URL NON VALIDO VIENE MOSTRATA ICONA
		void conUrlNonValido_MostraIcona() {
			ImageCard card = new ImageCard("Nome", "documento.txt");
			Div imageContainer = (Div) card.getComponentAt(0);
	        Component contenuto = imageContainer.getComponentAt(0);
			assertTrue(contenuto instanceof Icon);
			assertFalse(contenuto instanceof Image);
					
			
		}
}
