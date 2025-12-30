package it.unibg.accessibilita.base.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;

import it.unibg.accessibilita.base.ui.MainLayout;
import it.unibg.accessibilita.base.ui.component.AppFooter;
import it.unibg.accessibilita.base.ui.component.AppTabs;
import it.unibg.accessibilita.base.ui.component.BoxInfo;
import it.unibg.accessibilita.base.ui.component.GoogleMapCard;
import it.unibg.accessibilita.base.ui.component.ImageCard;

//TEMPORANEAMENTE PER VEDERE LA VIEW FARE: http://localhost:8080/sedi
//Alcuni attributi vanno modificati dopo aver implementato il Database
@Route(value = "sedi", layout = MainLayout.class)
public class SediView extends VerticalLayout{
	
	public SediView() {
		
		setSpacing(false);
		setPadding(true);
		setWidthFull();
		setSizeFull();
		
		H2 titolo = new H2("Sede di Dalmine"); // modificare dopo aver sistemato database
		titolo.addClassNames(LumoUtility.Margin.Bottom.NONE);
		
		Hr divisoreTitolo = new Hr();
		
		AppTabs tabs = new AppTabs();
		
		tabs.addTab("Generale",creatGeneraleContent());
		tabs.addTab("Edifici", createEdificioContent());
		tabs.addTab("Mappa", createMappaContent());
		AppFooter footer = new AppFooter();
		
		add(titolo, divisoreTitolo, tabs, footer);
	}
	
	private Component creatGeneraleContent() {
		VerticalLayout layout = new VerticalLayout();
		layout.setPadding(false);
		layout.setSpacing(true);
		layout.setWidthFull();
		layout.setMaxWidth("1200px");
		layout.addClassNames(LumoUtility.Margin.Horizontal.AUTO);
		
		H3 titoloSezione = new H3("Sede");
		titoloSezione.addClassNames(LumoUtility.Margin.Bottom.SMALL);
		
		HorizontalLayout rowCentrale = new HorizontalLayout();
		rowCentrale.setWidthFull();
		rowCentrale.setSpacing(true);
		rowCentrale.setAlignItems(Alignment.START);
		
		ImageCard card = new ImageCard("Sede di Dalmine", "Via Pasubio, 3", null);
		card.setWidth("65%");
		card.setMinWidth("320px");
		card.setHeight("500px");
		
		BoxInfo infoSede = new BoxInfo("Orario", "Contatti", "Aperto");
		infoSede.setWidth("30%");
		infoSede.setMinWidth("250px");
		infoSede.setHeight("500px");
		
		rowCentrale.add(card, infoSede);
		
		BoxInfo descBox = new BoxInfo("Sulla sede di Dalmine", "", "");
		descBox.setWidthFull();
		descBox.addClassNames(LumoUtility.Margin.Top.LARGE);
		
		layout.add(titoloSezione, rowCentrale, descBox);
		
		return layout;
	}

	private Component createEdificioContent() {
		VerticalLayout layout = new VerticalLayout();
		layout.setWidthFull();
		layout.setMaxWidth("1200px");
		layout.addClassName(LumoUtility.Margin.Horizontal.AUTO);
		layout.setPadding(true);
		
		layout.add(new Paragraph("In manutenzione"));
	
		return layout;
		
	}
	
	private Component createMappaContent(){
		VerticalLayout layout = new VerticalLayout();
		layout.setWidthFull();
		layout.setMaxWidth("1200px");
		layout.addClassName(LumoUtility.Margin.Horizontal.AUTO);
		
		H3 titoloMappa = new H3("MAPPA DELLA SEDE");
		titoloMappa.addClassNames(LumoUtility.Margin.Horizontal.AUTO);
		
		String urlDalmine = "https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d1172.714378374875!2d9.598500453105066!3d45.64679386157501!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sit!2sit!4v1767047582946!5m2!1sit!2sit";
		GoogleMapCard mappaSede = new GoogleMapCard(urlDalmine);
		
		layout.add(titoloMappa, mappaSede);
		return layout;

	}
}
