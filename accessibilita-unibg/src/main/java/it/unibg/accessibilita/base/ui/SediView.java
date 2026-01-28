package it.unibg.accessibilita.base.ui;

import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
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

import Accessibilita.AccessiBG_Backend.Edificio;
import Accessibilita.AccessiBG_Backend.EdificioDAO;
import Accessibilita.AccessiBG_Backend.Parcheggio;
import Accessibilita.AccessiBG_Backend.ParcheggioDAO;
import Accessibilita.AccessiBG_Backend.Sede;
import Accessibilita.AccessiBG_Backend.SedeDAO;

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
	private final EdificioDAO edificioDAO;
	private final ParcheggioDAO parcheggioDAO;
	
	public SediView(SedeDAO sedeDAO, EdificioDAO edificioDAO, ParcheggioDAO parcheggioDAO) {
		this.sedeDAO = sedeDAO;
		this.edificioDAO = edificioDAO;
		this.parcheggioDAO = parcheggioDAO;
		setSpacing(false);
		setPadding(true);
		setWidthFull();
		setSizeFull();
	}
	
	@Override
	public void setParameter(BeforeEvent event, String facolta) {
		removeAll();
		try {Sede sede = sedeDAO.findByFacolta(facolta);
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
		layout.addClassNames(LumoUtility.Margin.Horizontal.AUTO);
		
		HorizontalLayout rowCentrale = new HorizontalLayout();
        rowCentrale.setWidthFull();
        rowCentrale.setSpacing(true);
        rowCentrale.setAlignItems(Alignment.STRETCH);
		
		ImageCard card = new ImageCard(sede.getFacolta(), sede.getPathFoto());
		
		Box infoSede = new Box("Informazioni Generali");
		infoSede.add(new Paragraph("Indirizzo: " + sede.getIndirizzo()));
		infoSede.add(new Paragraph("Orario: " + sede.getOrarioApertura()));
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
		
		Div griglia = new Div();
		griglia.getMaxWidth();
        griglia.getStyle()
        .set("display", "grid")
        .set("grid-template-columns", "repeat(auto-fill, minmax(300px, 1fr))")
        .set("gap", "40px")
        .set("padding", "20px 0")
        .set("justify-content", "center");
        
        Div spacer = new Div();
        spacer.addClassName(LumoUtility.Flex.GROW);
        
        List<Edificio> edifici = sedeDAO.findEdificiBySede(sede.getFacolta());
		if(edifici.isEmpty()) {return null;}
		for(Edificio e : edifici) {
			ImageCard card = new ImageCard(e.getNome(), e.getIndirizzo(), e.getOrario(), e.getPathFoto());
            card.getStyle().set("cursor", "pointer");
            card.addClickListener(event -> {
                card.getUI().ifPresent(ui ->  ui.navigate(EdificiView.class, e.getNome())
                );
            });
            griglia.add(card, spacer);
		}
		return griglia;
	}	
	
	private Component createMappaContent(Sede sede){
		VerticalLayout layout = new VerticalLayout();
		layout.setWidthFull();
		layout.setMaxWidth("1200px");
		layout.addClassName(LumoUtility.Margin.Horizontal.AUTO);
		
		H3 titoloMappa = new H3("MAPPA DELLA " + sede.getFacolta());
		titoloMappa.addClassNames(LumoUtility.Margin.Horizontal.AUTO);
		
		GoogleMapCard mappaSede = new GoogleMapCard(sede.getPathMaps());
		
		layout.add(titoloMappa, mappaSede);
		return layout;
	}
	
	private Component createParcheggiContent(Sede sede) {
		
		Div griglia = new Div();
		griglia.getMaxWidth();
        griglia.getStyle()
        .set("display", "grid")
        .set("grid-template-columns", "repeat(auto-fill, minmax(300px, 1fr))")
        .set("gap", "40px")
        .set("padding", "20px 0")
        .set("justify-content", "center");
        
        Div spacer = new Div();
        spacer.addClassName(LumoUtility.Flex.GROW);
        
        List<Parcheggio> parcheggi = sedeDAO.findParcheggioBySede(sede.getFacolta());
        if(parcheggi.isEmpty()) {return null;}
        for(Parcheggio p : parcheggi) {
			ImageCard card = new ImageCard(p.getNome(), p.getIndirizzo(), p.getPathFoto());
            card.getStyle().set("cursor", "pointer");
            griglia.add(card, spacer);
		}
		return griglia;
	}
}
