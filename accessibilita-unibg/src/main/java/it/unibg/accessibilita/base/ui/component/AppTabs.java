package it.unibg.accessibilita.base.ui.component;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.theme.lumo.LumoUtility;
/**
 * Componente personalizzato che gestisce un layout a schede
 */
public class AppTabs extends VerticalLayout {
	private final Tabs tabs = new Tabs();
	private final Div contentContainer = new Div();
	private final Map<Tab, Component> tabToContentMap = new HashMap<>();
	
	/**
	 * Inizializza il layout e configura il listener per il cambio scheda.
	 * Quando l'utente seleziona una scheda, il contenuto precedente viene rimosso
	 */
	public AppTabs() {
		setSpacing(true);
		setPadding(false);
		setSizeFull();
		
		tabs.setWidthFull();
		
		contentContainer.setSizeFull();
		contentContainer.addClassName(LumoUtility.Padding.MEDIUM);
		
		tabs.addSelectedChangeListener(event ->{
			Tab selectedTab = event.getSelectedTab();
			Component content = tabToContentMap.get(selectedTab);
			
			contentContainer.removeAll();
			if (content != null) {
				contentContainer.add(content);
			}
			
		});
		
		add(tabs, contentContainer);
	}
	
	//SCHEDA SOLO TESTO
	/**
	 * 
	 * @param title
	 * @param content il componente da visualizzare quando la scheda cambia
	 */
	public void addTab(String title,  Component content) {
		Tab tab = new Tab(title);
		addInternal(tab, content);
	}
	
	//SCHEDA TESTO = ICONA IN CASO CI SERVA
	/**
	 * 
	 * @param title
	 * @param icon icona di vaadin
	 * @param content il componente da visualizzare la quando la scheda cambia
	 */
	public void addTab(String title, Icon icon, Component content) {
		Tab tab = new Tab(icon, new com.vaadin.flow.component.html.Span(title));
		addInternal(tab, content);
	}
	
	private void addInternal(Tab tab, Component content) {
		tabToContentMap.put(tab, content);
		tabs.add(tab);
		
		if (tabToContentMap.size() == 1) {
			tabs.setSelectedTab(tab);
			contentContainer.add(content);
		}
	}
}
