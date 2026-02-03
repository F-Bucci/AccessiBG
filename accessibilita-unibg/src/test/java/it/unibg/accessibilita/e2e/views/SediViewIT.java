package it.unibg.accessibilita.e2e.views;

import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Locator;
import it.unibg.accessibilita.e2e.BaseE2ETest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class SediViewIT extends BaseE2ETest{
	
	@Test
	//test per verificare che la view viene caricata correttamente
	void sediViewCaricaCorrettamente() {
		String urlTest = "/Sede%20di%20Dalmine";
		page.navigate("http://localhost:8080/sedi" + urlTest);
		assertThat(page.getByText("Sede do Dalmine"));
		assertThat(page.getByText("Generale"));
		assertThat(page.getByText("Edifici"));
		assertThat(page.getByText("Informazioni generali"));
		assertThat(page.getByText("Mappa"));
		assertThat(page.getByText("Sulla Sede di Dalmine"));
		assertThat(page.getByText("Parcheggi"));
	}
	@Test
	void cambiaTabCorrettamente() {
		//test per verificare che la tab viene cambiata correttamentea
		String urlTest = "/Sede%20di%20Dalmine";
		page.navigate("http://localhost:8080/sedi" + urlTest);
		Locator tabEdificio = page.locator("vaadin-tab:has-text('Edifici')");
		tabEdificio.click();
		assertThat(tabEdificio).hasAttribute("selected", "");
	}
	
	@Test
	void cambiaTabEClickImmagineCorrettamente() {
		//test per verificare che la tab viene cambiata correttamente
		String urlTest = "/Sede%20di%20Dalmine";
		page.navigate("http://localhost:8080/sedi" + urlTest);
		Locator tabEdificio = page.locator("vaadin-tab:has-text('Edifici')");
		tabEdificio.click();
		Locator immagine = page.locator("img[alt='Edificio A']");
		immagine.waitFor();
		immagine.click();
		String urlattesto = "http://localhost:8080/edifici/Edificio%20A";
		assertThat(page).hasURL(urlattesto);
	}
}