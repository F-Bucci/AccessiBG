package it.unibg.accessibilita.base.ui.component;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.vaadin.flow.component.button.Button;

 class ViewToolbarTest {

		@Test
		 void nonVuota() {
			ViewToolbar tb = new ViewToolbar("home");
			assertNotNull(tb);
			assertTrue(tb.getContent().getChildren().count() > 0);
		}
		
		@Test
		 void creaComponente() {
			Button b = new Button("Prova");
			ViewToolbar tb = new ViewToolbar("home", b);
			assertNotNull(tb);
		}
}
