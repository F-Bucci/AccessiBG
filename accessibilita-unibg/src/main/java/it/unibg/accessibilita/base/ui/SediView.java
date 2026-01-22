package it.unibg.accessibilita.base.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import Accessibilita.AccessiBG_Backend.Sede;
import Accessibilita.AccessiBG_sqlite.SedeDAO;

import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;

import it.unibg.accessibilita.base.ui.MainLayout;
import it.unibg.accessibilita.base.ui.component.AppFooter;
import it.unibg.accessibilita.base.ui.component.AppTabs;
import it.unibg.accessibilita.base.ui.component.Box;
import it.unibg.accessibilita.base.ui.component.GoogleMapCard;
import it.unibg.accessibilita.base.ui.component.ImageCard;

//TEMPORANEAMENTE PER VEDERE LA VIEW FARE: http://localhost:8080/sedi
//Alcuni attributi vanno modificati dopo aver implementato il Database
@Route(value = "sedi", layout = MainLayout.class)
public class SediView extends VerticalLayout implements HasUrlParameter<String>{
	
	private final SedeDAO sedeDAO;
	
	public SediView(SedeDAO sedeDAO) {
		
		this.sedeDAO = sedeDAO;
		
		setSpacing(false);
		setPadding(true);
		setWidthFull();
		setSizeFull();
		
	}
	
	@Override
	public void setParameter(BeforeEvent event, String facolta) {
		removeAll();
		
		try {
			Sede sede = sedeDAO.findByFacolta(facolta);
			if(sede != null){interfacciaSede(sede);
			}
		}catch (Exception e){
			e.getMessage();
		}
	}
	
	private void interfacciaSede(Sede sede) {
		H2 titolo = new H2(sede.getFacolta());
		titolo.addClassNames(LumoUtility.Margin.Bottom.NONE);
Hr divisoreTitolo = new Hr();
		
		AppTabs tabs = new AppTabs();
		
		tabs.addTab("Generale", createGeneraleContent(sede));
		tabs.addTab("Edifici", createEdificioContent(sede));
		tabs.addTab("Mappa", createMappaContent(sede));
		tabs.addTab("Parcheggi", createParcheggiContent(sede));
		
		AppFooter footer = new AppFooter();
		
		add(titolo, divisoreTitolo, tabs, footer);
	}
	private Component createGeneraleContent(Sede sede) {
		VerticalLayout layout = new VerticalLayout();
		layout.setPadding(false);
		layout.setSpacing(true);
		layout.setWidthFull();
		layout.setMaxWidth("1200px");
		layout.addClassNames(LumoUtility.Margin.Horizontal.AUTO);
		
		HorizontalLayout rowCentrale = new HorizontalLayout();
		rowCentrale.setWidthFull();
		rowCentrale.setSpacing(true);
		rowCentrale.setAlignItems(Alignment.START);
		
		ImageCard card = new ImageCard(sede.getFacolta(), sede.getIndirizzo(), sede.getPathFoto());
		card.setWidth("65%");
		card.setMinWidth("320px");
		card.setHeight("500px");
		
		Box infoSede = new Box("Informazioni Generali");
		infoSede.setWidth("30%");
		infoSede.setMinWidth("250px");
		infoSede.setHeight("500px");
		
		rowCentrale.add(card, infoSede);
		
		Box descBox = new Box("Sulla " + sede.getFacolta());
		descBox.setWidthFull();
		descBox.addClassNames(LumoUtility.Margin.Top.LARGE);
		
		layout.add(rowCentrale, descBox);
		
		return layout;
	}

	private Component createEdificioContent(Sede sede) {
		VerticalLayout layout = new VerticalLayout();
		layout.setWidthFull();
		layout.setMaxWidth("1200px");
		layout.addClassName(LumoUtility.Margin.Horizontal.AUTO);
		layout.setPadding(true);
		
		layout.add(new Paragraph("In manutenzione"));
	
		return layout;
		
	}
	
	private Component createMappaContent(Sede sede){
		VerticalLayout layout = new VerticalLayout();
		layout.setWidthFull();
		layout.setMaxWidth("1200px");
		layout.addClassName(LumoUtility.Margin.Horizontal.AUTO);
		
		H3 titoloMappa = new H3("MAPPA DELLA SEDE");
		titoloMappa.addClassNames(LumoUtility.Margin.Horizontal.AUTO);
		
		String urlMappa = "https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d1172.714378374875!2d9.598500453105066!3d45.64679386157501!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sit!2sit!4v1767047582946!5m2!1sit!2sit";
		GoogleMapCard mappaSede = new GoogleMapCard(urlMappa);
		
		layout.add(titoloMappa, mappaSede);
		return layout;

	}
	
	private Component createParcheggiContent(Sede sede) {
		
		VerticalLayout layout = new VerticalLayout();
		return layout;
	}
}
