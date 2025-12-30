package it.unibg.accessibilita.base.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;

import it.unibg.accessibilita.base.ui.component.AppFooter;
import it.unibg.accessibilita.base.ui.component.AppTabs;

@Route(value = "edifici", layout = MainLayout.class)
public class EdificiView extends VerticalLayout{
	
	private final VerticalLayout contentContainer = new VerticalLayout();
	
	public EdificiView(){
		
		setSpacing(false);
		setPadding(true);
		setSizeFull();
		
		H2 titolo = new H2("Edificio A"); // da modificare dopo collegamento con database
		titolo.addClassNames(LumoUtility.Margin.Bottom.SMALL);
		
		Hr divisore = new Hr();
		
		AppTabs edificioTab = new AppTabs();
		edificioTab.addTab("Generale", createGeneraleContent());
		edificioTab.addTab("Ingressi", createIngressiContent());
		edificioTab.addTab("Servizi", createServiziContent());
		edificioTab.addTab("Mappa", createMappaContent());
        
		AppFooter footer = new AppFooter();
		add(titolo, divisore, edificioTab, footer);
	}
	
	//TAB GENERALE
	private VerticalLayout createGeneraleContent() {
	    VerticalLayout layout = new VerticalLayout();
	    layout.setPadding(false);
	    layout.setSpacing(true);
	    return layout;
	}
	//TAB INGRESSI
	private VerticalLayout createIngressiContent() {
	    VerticalLayout layout = new VerticalLayout();
	    layout.setPadding(false);
	    layout.setSpacing(true);

	    return layout;
	}
	//TAB SERVIZI
	private VerticalLayout createServiziContent() {
	    VerticalLayout layout = new VerticalLayout();
	    layout.setPadding(false);
	    layout.setSpacing(true);

	    return layout;
	}
	//TAB MAPPA
	private VerticalLayout createMappaContent() {
	    VerticalLayout layout = new VerticalLayout();
	    layout.setPadding(false);
	    layout.setSpacing(true);

	    return layout;
	}

	
}
