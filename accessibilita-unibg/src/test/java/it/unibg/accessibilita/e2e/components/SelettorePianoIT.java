package it.unibg.accessibilita.e2e.components;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import java.util.regex.Pattern;
import it.unibg.accessibilita.e2e.BaseE2ETest;

public class SelettorePianoIT extends BaseE2ETest {
	@Test
	//test per verificare che la navigazione funzioni
	void selezionaPianoCorrettaNavigazione(){
		String urlTest = "/Edificio%20D";
		page.navigate("http://localhost:8080/edifici" + urlTest);
		
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		Locator select = page.locator("vaadin-select");
        select.waitFor();
        select.click();
        
        Locator item = page.locator("vaadin-select-item").first();
        item.waitFor();
        item.click(new Locator.ClickOptions().setForce(true));
        
        assertThat(page).hasURL(Pattern.compile(".*struttura/Edificio.*"));
		assertThat(page.getByText("Mappa iterattiva del Piano 0"));
	}
}
