package it.unibg.accessibilita.e2e.views;


import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.regex.Pattern;
import it.unibg.accessibilita.e2e.BaseE2ETest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeViewIT extends BaseE2ETest {
	
	@Test
	//verifica che l'home page viene caricata correttamente
	public void homePage_caricaCorrettamente(){
		
		page.navigate("http://localhost:8080/");
		assertThat(page.getByText("Università degli Studi di Bergamo")).isVisible();
		assertThat(page.getByText("Sedi universitarie")).isVisible();
		//footer
		assertThat(page.getByText("@2026 AccessiBG")).isVisible();
	}
	@Test
	//verifica che le ImageCard vengpno visualizzate in modo corretto
	public void grigliaContieneImageCard() {
		page.navigate("http://localhost:8080/");
		//recupero componente css per selezionare le card
		Locator card = page.locator("div[style*='cursor: pointer']");
		assertThat(card).not().hasCount(0);
	}
	
	@Test
	//verifica corretta navigazione a view successiva tramite ImageCard
	public void navigazioneClickImageCard() {
		page.navigate("http://localhost:8080/");
		Locator card = page.locator("div[style*='cursor: pointer']");
		//esegue click sul primo elemento che trova
		card.nth(0).click();
		//cerca la parola "sedi" ignorando cosa ci sia prima o dopo
	    assertThat(page).hasURL(Pattern.compile(".*sedi.*"));
	}
}
