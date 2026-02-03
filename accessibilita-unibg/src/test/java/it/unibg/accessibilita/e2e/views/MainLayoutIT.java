package it.unibg.accessibilita.e2e.views;


import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Locator;
import it.unibg.accessibilita.e2e.BaseE2ETest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MainLayoutIT extends BaseE2ETest{
	@Test
	//test per verificare che il meny a tendina sia presente
	void menuTendina_Presente() {
		page.navigate("http://localhost:8080/");
		assertThat(page.locator("vaadin-app-layout")).containsText("AccessiBg");
	}
	
	@Test
	//test per verificare che cliccando sul pulsante home si torni alla home
	void navigaAllaHome() {
		page.navigate("http://localhost:8080/");
		Locator homeBtn = page.locator("vaadin-button:has-text('Home')");
        homeBtn.click();
        assertThat(page).hasURL("http://localhost:8080/");
	}
}
