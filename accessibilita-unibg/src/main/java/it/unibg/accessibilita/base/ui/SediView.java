package it.unibg.accessibilita.base.ui;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import it.unibg.accessibilita.base.ui.MainLayout;
import it.unibg.accessibilita.base.ui.component.BoxInfo;
import it.unibg.accessibilita.base.ui.component.ImageCard;

//TEMPORANEAMENTE PER VEDERE LA VIEW FARE: http://localhost:8080/sedi
@Route(value = "sedi", layout = MainLayout.class)
public class SediView extends VerticalLayout{
	
	public SediView() {
		
		setSpacing(false);
		setPadding(true);
		setWidthFull();
		
		H2 titolo = new H2("Sede di Dalmine"); // modificare dopo aver sistemato database
		titolo.addClassNames(LumoUtility.Margin.Bottom.NONE);
		
		Hr divisoreTitolo = new Hr();
		
		TabSheet tabSheet = new TabSheet();
		tabSheet.setWidthFull();
		
		VerticalLayout contenutoTab = new VerticalLayout();
		contenutoTab.setPadding(false);
		contenutoTab.setSpacing(true);
		contenutoTab.setWidthFull();
		contenutoTab.setMaxWidth("1200px");
		
		HorizontalLayout bodySedi = new HorizontalLayout();
		bodySedi.setWidthFull();
		bodySedi.setSpacing(true);

		
		ImageCard card = new ImageCard("Sede di Dalmine", "Via via Pasubio, 3", null);//modificare dopo aver completato database
		card.setMinWidth("320px");
		card.setWidth("65%");
		
		BoxInfo infoSedeDalmine = new BoxInfo("orario", "mail e telefono", "aperto"); //modificare dopo aver completato database
		infoSedeDalmine.setWidth("35%");
		infoSedeDalmine.setMinWidth("250px");
		
		bodySedi.add(card, infoSedeDalmine);
		
		BoxInfo boxSotto = new BoxInfo("Sulla Sede di Dalmine", "aggiungere informazioni aggiuntive", "altro info");
		boxSotto.setWidthFull();
		
		contenutoTab.add(bodySedi, boxSotto);
		
		tabSheet.add("Generale", contenutoTab);
		
		add(titolo, divisoreTitolo, tabSheet, new Hr(), new Paragraph("@AccessiBG 2026"));
	}
}
