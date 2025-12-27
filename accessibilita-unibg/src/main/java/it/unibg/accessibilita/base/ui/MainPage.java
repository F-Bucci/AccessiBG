package it.unibg.accessibilita.base.ui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import it.unibg.accessibilita.base.ui.component.ViewToolbar;

@Route("") 
@PageTitle("Hello, Vaadin!") 
@Menu(order = 0, icon = "vaadin:clipboard-check", title = "Main Page")
public class MainPage extends Composite<VerticalLayout> { 

	private Card createCard(String testo) {
		Card card = new Card();
		card.setHeight("200px");
		card.setWidth("300px");
		
		Icon iconTemp = LumoIcon.PHOTO.create();
		
		card.setMedia(iconTemp);
		card.add(testo);
		
		return card;
	};

    public MainPage() {
    	
    	HorizontalLayout layoutForHeader = new HorizontalLayout();
    	VerticalLayout mainLayout = new VerticalLayout();
    	HorizontalLayout layoutForCards = new HorizontalLayout();
    	HorizontalLayout layoutForFooter = new HorizontalLayout();
    	
    	H1 textForHeader = new H1();
    	textForHeader.setText("AccessiBG");
    	getContent().setAlignSelf(FlexComponent.Alignment.START, textForHeader);
    	
    	H2 textForLayoutForCards = new H2();
    	textForLayoutForCards.setText("Sedi universitarie di Bergamo");
    	getContent().setAlignSelf(FlexComponent.Alignment.CENTER, textForLayoutForCards);
    	textForLayoutForCards.setWidth("max-content");
    	
    	
    	Paragraph textForFooter = new Paragraph();
    	textForFooter.setText("@ 2026   AccessiBG");
    	textForFooter.setWidth("max-content");
    	textForFooter.getStyle().set("font-size", "var(--lumo-font-size-m)");

    	layoutForCards.setWidthFull();
    	layoutForCards.getStyle().set("flex-wrap", "WRAP");
    	layoutForFooter.setHeight("min-content");
    	layoutForCards.addClassName(Gap.MEDIUM);
        layoutForCards.setJustifyContentMode(JustifyContentMode.CENTER);
        
        mainLayout.setWidth("100%");
        mainLayout.getStyle().set("flex-grow", "1");
        mainLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        mainLayout.setAlignItems(Alignment.CENTER);
        mainLayout.setFlexGrow(1.0, layoutForCards);
        
        layoutForFooter.addClassName(Gap.MEDIUM);
        layoutForFooter.setWidth("100%");
        layoutForFooter.setHeight("min-content");
        layoutForFooter.setAlignItems(Alignment.CENTER);
        layoutForFooter.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutForFooter.setAlignSelf(FlexComponent.Alignment.END, textForFooter);
        
    	
        /* CREAZIONE CARD */
        /*
         * Attualmente le card vengono create in questa maniera,
         * ma appena riusciremo ad effettuare la comunicazione con
         * il DB modificheremo le righe di codice sottostanti per
         * renderli più efficienti e più adatti al contesto.
         */
        
        Card iconCard1 = createCard("Sede di Dalmine");
        Card iconCard2 = createCard("Sede di Kilometro Rosso");
        Card iconCard3 = createCard("Sede di Caniana");
        Card iconCard4 = createCard("Sede Palazzo Bassi-Rathgeb");
        Card iconCard5 = createCard("Sede di Pignolo");
        Card iconCard6 = createCard("Sede di Sant'Agostino");
        Card iconCard7 = createCard("Sede di Rosate");
        Card iconCard8 = createCard("Sede di Salvecchio");
        

        
        
        // getContent().setWidth("100%");
        // getContent().setHeight("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.END);
        getContent().setAlignItems(Alignment.START);
        
        getContent().add(layoutForHeader);
        layoutForHeader.add(new ViewToolbar(""));
        layoutForHeader.add(textForHeader);
        getContent().add(mainLayout);
        mainLayout.add(textForLayoutForCards);
        mainLayout.add(layoutForCards);
        layoutForCards.add(iconCard1);
        layoutForCards.add(iconCard2);
        layoutForCards.add(iconCard3);
        layoutForCards.add(iconCard4);
        layoutForCards.add(iconCard5);
        layoutForCards.add(iconCard6);
        layoutForCards.add(iconCard7);
        layoutForCards.add(iconCard8);
        getContent().add(layoutForFooter);
        layoutForFooter.add(textForFooter);
        

    }
}