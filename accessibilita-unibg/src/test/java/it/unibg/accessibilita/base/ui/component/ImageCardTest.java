package it.unibg.accessibilita.base.ui.component;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;

public class ImageCardTest {

		@Test
		//VOGLIO TESTARE CHE SE URL=NULL VIENE MOSTRATA L'ICONA
		//SUCCESS
		public void noUrl_MostraIcona() {
			ImageCard card = new ImageCard("Nome", "Via", null);
			Component imageContainer = card.getChildren().findFirst().get();
			Component contenuto = imageContainer.getChildren().findFirst().get();
			
			assertTrue(contenuto instanceof Icon);
		}
		
		@Test
		//VOGLIO TESTARE CHE SE E' PRESENTE UN URL DI UN IMMAGINE, MOSTRI QUEST'ULTIMA
		//SUCCESS
		public void conUrlValido_MostraImmagine() {
			String url = "http://esempio.it/immagine.jpg";
			ImageCard card = new ImageCard("Nome", "Via", url);
			Component imageContainer = card.getChildren().findFirst().get();
			Component contenuto = imageContainer.getChildren().findFirst().get();
			
			assertTrue(contenuto instanceof Image);
		}
		
		@Test
		//TEST ESTENSIONE NON VALIDA (.txt o .pdf) DOVREBBE MOSTRARE UNA ICONA
		public void conUrlNonValido_MostraIcona() {
			String url = "http://esempio.it/file.txt";
			ImageCard card = new ImageCard("Nome", "Via", url);
			Component imageContainer = card.getChildren().findFirst().get();
			Component contenuto = imageContainer.getChildren().findFirst().get();
			assertTrue(contenuto instanceof Icon);
					
			
		}
}
