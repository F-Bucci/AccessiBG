package it.unibg.accessibilita.e2e.views;

import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Locator;
import it.unibg.accessibilita.e2e.BaseE2ETest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class EdificiViewIT extends BaseE2ETest{
	
	@Test
	void edificiView_CaricaCorrettamente() {
		//test per visualizzare se la pagina si vede correttamente
		String urlTest = "/Edificio%20A";
		page.navigate("http://localhost:8080/edifici" + urlTest);
		assertThat(page.getByText("Edificio A"));
		assertThat(page.getByText("Generale"));
		assertThat(page.getByText("Ingressi"));
		assertThat(page.getByText("Informazioni generali"));
	}
	@Test
	void cambiaTabCorrettamente() {
		//Test per verificare che la tab viene cambiata correttamente quando viene cliccata
		String urlTest = "/Edificio%20A";
		page.navigate("http://localhost:8080/edifici" + urlTest);
		Locator tabIngressi = page.locator("vaadin-tab:has-text('Ingressi')");
		tabIngressi.click();
		assertThat(tabIngressi).hasAttribute("selected", "");
	}
}
