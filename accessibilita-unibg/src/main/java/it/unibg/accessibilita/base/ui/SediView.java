package it.unibg.accessibilita.base.ui;

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
		
		TabSheet tabSheet = new TabSheet();
		tabSheet.setWidthFull();
		
		VerticalLayout tabGenerale = new VerticalLayout();
		tabGenerale.setPadding(false);
		tabGenerale.setSpacing(true);
		tabGenerale.setWidthFull();
		tabGenerale.setMaxWidth("1200px");
		tabGenerale.addClassNames(LumoUtility.Margin.Horizontal.AUTO);
		
		HorizontalLayout bodySedi = new HorizontalLayout();
		bodySedi.setWidthFull();
		bodySedi.setSpacing(true);

		
		ImageCard card = new ImageCard("Sede di Dalmine", "Via via Pasubio, 3", null);//modificare dopo aver completato database
		card.setMinWidth("320px");
		card.setHeight("500px");
		card.setWidth("65%");
		
		//BOX SUPERIORE TAB GENERALE
		BoxInfo infoSedeDalmine = new BoxInfo("orario", "mail e telefono", "aperto"); //modificare dopo aver completato database
		infoSedeDalmine.setWidth("35%");
		infoSedeDalmine.setMinWidth("250px");
		infoSedeDalmine.setHeight("500px");
		
		bodySedi.add(card, infoSedeDalmine);
		
		//BOX PARTE INFERIORE DELLA TAB GENERALE
		BoxInfo boxSotto = new BoxInfo("Sulla Sede di Dalmine", "aggiungere informazioni aggiuntive", "altro info");
		boxSotto.setWidthFull();
		boxSotto.addClassName(LumoUtility.Margin.Top.XLARGE);
		
		tabGenerale.add(bodySedi, boxSotto);
		
		tabSheet.add("Generale", tabGenerale);

		
		//TAB EDIFICI
		VerticalLayout edificioTab = new VerticalLayout();
		edificioTab.setWidthFull();
		edificioTab.setMaxWidth("1200px");
		edificioTab.addClassName(LumoUtility.Margin.Horizontal.AUTO);
		edificioTab.add(new Paragraph("prova"));
		tabSheet.add("Edifici", edificioTab);
		
		//TAB MAPPA
		
		VerticalLayout mappaTab = new VerticalLayout();
		mappaTab.setWidthFull();
		mappaTab.setMaxWidth("1200px");
		mappaTab.addClassName(LumoUtility.Margin.Horizontal.AUTO);
		/*modificare in seguito, l'url si ottiene andando su Google Maps
		 * cliccare sulla posizione che  si vuole ottenere
		 * infine cliccare su "incorpora mappa"
		 * copiare la parte tra virgolette dopo src.
		 */
		mappaTab.setPadding(true);
		H3 titoloMappa = new H3("MAPPA DELLA SEDE DI "); // aggiungere dopo implementazione del database
		titoloMappa.addClassNames(LumoUtility.Margin.Bottom.SMALL);
		String urlDalmine = "https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d1172.714378374875!2d9.598500453105066!3d45.64679386157501!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sit!2sit!4v1767047582946!5m2!1sit!2sit";
		GoogleMapCard mappaSede = new GoogleMapCard(urlDalmine);
		
		mappaTab.add(titoloMappa, mappaSede);
		tabSheet.add("Mappa", mappaTab);
		
		expand(tabSheet);
		
		//FOOTER
		AppFooter footer = new AppFooter();
		
		add(titolo, divisoreTitolo, tabSheet, footer);
	}
}
