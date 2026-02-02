package it.unibg.accessibilita.base.ui.component;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

class AppTabsTest {
	@Test
	//Test per verificare che quandp si cambia tab cambia anche il contenuto
	void cambiaScheda_cambiaContenuto() {
		
		AppTabs tab = new AppTabs();
		Span c1 = new Span("C1");
		Span c2 = new Span("C2");
		
		tab.addTab("tab1", c1);
		tab.addTab("tab2", c2);
		
		Tabs tComponent = (Tabs) tab.getComponentAt(0);
		Div cContainer = (Div) tab.getComponentAt(1);
		
		assertEquals(c1, cContainer.getComponentAt(0));
		
		Tab tab2 = (Tab) tComponent.getTabAt(1);
		tComponent.setSelectedTab(tab2);
		
		assertEquals(c2, cContainer.getComponentAt(0));
	}
}
