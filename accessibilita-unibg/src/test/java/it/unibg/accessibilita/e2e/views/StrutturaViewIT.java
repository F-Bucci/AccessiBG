package it.unibg.accessibilita.e2e.views;

import org.junit.jupiter.api.Test;
import it.unibg.accessibilita.e2e.BaseE2ETest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class StrutturaViewIT extends BaseE2ETest{
	@Test
	//test oer verificare che la view viene caricata correttamente
	void strutturaViewCaricaCorrettamente() {
		String urlTest = "/Edificio%20D";
		page.navigate("http://localhost:8080/struttura" + urlTest);
		assertThat(page.getByText("Mappa iterattiva del Piano 0"));
	}
}
