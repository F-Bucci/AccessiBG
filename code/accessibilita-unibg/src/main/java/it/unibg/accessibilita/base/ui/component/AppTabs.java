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

public class AppTabs extends VerticalLayout {
	private final Tabs tabs = new Tabs();
	private final Div contentContainer = new Div();
	private final Map<Tab, Component> tabToContentMap = new HashMap<>();
	
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
	
	public void addTab(String title,  Component content) {
		Tab tab = new Tab(title);
		addInternal(tab, content);
	}
	
	//SCHEDA TESTO = ICONA IN CASO CI SERVA
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
