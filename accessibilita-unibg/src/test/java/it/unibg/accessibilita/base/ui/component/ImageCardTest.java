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
		public void noUrl_MostraIcon() {
			ImageCard card = new ImageCard("Nome", "Via", "");
			Component imageContainer = card.getChildren().findFirst().get();
			Component contenuto = imageContainer.getChildren().findFirst().get();
			
			assertTrue(contenuto instanceof Icon);
		}
		
		@Test
		//VOGLIO TESTARE CHE SE E' PRESENTE UN URL DI UN IMMAGINE, MOSTRI QUEST'ULTIMA
		//SUCCESS
		public void conUrl_MostraImmagine() {
			String url = "http://esempio.it/immagine.jpg";
			ImageCard card = new ImageCard("Nome", "Via", url);
			Component imageContainer = card.getChildren().findFirst().get();
			Component contenuto = imageContainer.getChildren().findFirst().get();
			
			assertTrue(contenuto instanceof Image);
		}
}
