package it.unibg.accessibilita.e2e.components;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

import it.unibg.accessibilita.e2e.BaseE2ETest;

public class DialogMappaIT extends BaseE2ETest{
	@Test
	void dialogOstacolo_mostraFoto() {
		//test cbe cliccando su un ostacolo viene mostrato un diaslog con un messaggio di attenzione con una icona di pericolo
	page.navigate("http://localhost:8080/struttura/Edificio%20D");
	page.locator("vaadin-icon[icon='vaadin:warning']").first().click();
	Locator overlay = page.locator("vaadin-dialog-overlay >> visible=true");
	//aspetta la transizione
	overlay.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
	assertThat(overlay).isVisible();
    assertThat(overlay.locator("img")).isVisible();

    overlay.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Chiudi")).click();
	}
	
	@Test
	//test che verifica che cliccando una sstanza questo ha una foto
	void dialogStanza_MostraFoto() {
		page.navigate("http://localhost:8080/struttura/Edificio%20D");
		page.locator("vaadin-icon[icon='vaadin:academy-cap']").first().click();

	    Locator overlay = page.locator("vaadin-dialog-overlay >> visible=true");
	    overlay.waitFor();
	    assertThat(overlay.locator("img")).isVisible();
	  
	    overlay.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Chiudi")).click();
	}
	
	@Test
	//test che verifica che cliccando un distributore generico questo ha una foto
	void dialogDistributore_MostraFoto() {
		page.navigate("http://localhost:8080/struttura/Edificio%20D");
		page.locator("vaadin-icon[icon='vaadin:coffee']").first().click();

	    Locator overlay = page.locator("vaadin-dialog-overlay >> visible=true");
	    overlay.waitFor();
	    assertThat(overlay.locator("img")).isVisible();
	  
	    overlay.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Chiudi")).click();
	}
}

	