package it.unibg.accessibilita.e2e;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public abstract class BaseE2ETest {
	
	//variabili statiche condivise tra tutti i test
	protected static Playwright playwright;
	private static Browser browser;
	
	//variabili di istanza create per ogni test
	private BrowserContext browserContext;
	protected Page page;
	
	@BeforeAll
	static void beforeAll() {
		playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
		launchOptions.setHeadless(false);
		browser = browserType.launch(launchOptions);
	}
	
	@AfterAll
	static void AfterAll() {
		if (browser != null) browser.close();
		if (playwright != null) playwright.close();
		
	}
	
	@BeforeEach
	void beforeEach() {
		browserContext = browser.newContext();
		page = browserContext.newPage();
	}
	
	@AfterEach
	void afterEach() {
		page.close();
		browserContext.close();
	}
	
}
