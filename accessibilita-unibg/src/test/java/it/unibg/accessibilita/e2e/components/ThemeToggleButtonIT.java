package it.unibg.accessibilita.e2e.components;

import it.unibg.accessibilita.e2e.BaseE2ETest;
import com.microsoft.playwright.Locator;

import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

 class ThemeToggleButtonIT extends BaseE2ETest {
	
	@Test
	void clickCambiaTema() {
		page.navigate("http://localhost:8080/");
		
		Locator themeButton = page.getByLabel("Cambia Tema");
		Locator body = page.locator("body");
		
		String currentTheme = body.getAttribute("theme");
		boolean startsThemeDark = "dark".equals(currentTheme);
		
		if(startsThemeDark) {
			assertThat(body).hasAttribute("theme", "dark");
			assertThat(themeButton).containsText("Tema Chiaro");
			
			themeButton.click();
            assertThat(body).not().hasAttribute("theme", "dark");
            assertThat(themeButton).containsText("Tema Scuro");
            
            themeButton.click();
            assertThat(body).hasAttribute("theme", "dark");
		}else {
			assertThat(body).not().hasAttribute("theme", "dark");
			assertThat(themeButton).containsText("Tema Scuro");
			
			themeButton.click();
            assertThat(body).hasAttribute("theme", "dark");
            assertThat(themeButton).containsText("Tema Chiaro");
            
            themeButton.click();
            assertThat(body).not().hasAttribute("theme", "dark");
		}
	}
}
