package it.unibg.accessibilita.base.ui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
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

import it.unibg.accessibilita.base.ui.component.ImageCard;
import it.unibg.accessibilita.base.ui.component.ViewToolbar;

@Route(value = "mainpage", layout = MainLayout.class) 
@PageTitle("Hello, Vaadin!") 
public class MainPageView extends Composite<VerticalLayout> { 

    public MainPageView() {
    	
    	HorizontalLayout layoutForHeader = new HorizontalLayout();
    	VerticalLayout mainLayout = new VerticalLayout();
    	Div layoutForCards = new Div();
    	HorizontalLayout layoutForFooter = new HorizontalLayout();
    	
    	
    	H1 textForHeader = new H1();
    	textForHeader.setText("AccessiBG");
    	getContent().setAlignSelf(FlexComponent.Alignment.START, textForHeader);
    	
    	H2 textForLayoutForCards = new H2();
    	textForLayoutForCards.setText("Sedi universitarie di Bergamo");
    	getContent().setAlignSelf(FlexComponent.Alignment.CENTER, textForLayoutForCards);
    	textForLayoutForCards.setWidth("max-content");
    	
    	layoutForHeader.setWidthFull();
    	
    	Paragraph textForFooter = new Paragraph();
    	textForFooter.setText("@ 2026   AccessiBG");
    	textForFooter.setWidth("max-content");
    	textForFooter.getStyle().set("font-size", "var(--lumo-font-size-m)");

    	layoutForCards.setWidthFull();
    	layoutForCards.getStyle()
            .set("display", "grid")
            .set("grid-template-columns", "repeat(auto-fit, minmax(335px, 1fr))")
            .set("gap", "var(--lumo-space-m)")
            .set("justify-items", "center");
    	layoutForFooter.setHeight("min-content");
    	layoutForCards.addClassName(Gap.MEDIUM);
        
        mainLayout.setWidthFull();
        mainLayout.setAlignItems(Alignment.CENTER);
        getContent().setFlexGrow(1.0, mainLayout);
        
        layoutForFooter.setWidthFull();
        layoutForFooter.setJustifyContentMode(JustifyContentMode.CENTER);
      
        getContent().setSizeFull();
        getContent().getStyle().set("flex-grow", "1");
        getContent().setAlignSelf(FlexComponent.Alignment.END, layoutForFooter);
        
        getContent().add(layoutForHeader);
        layoutForHeader.add(textForHeader);
        getContent().add(mainLayout);
        mainLayout.add(textForLayoutForCards);
        mainLayout.add(layoutForCards);
 
        layoutForCards.add(new ImageCard("Sede di Dalmine", "via Pasubio, 3", "null"));
        layoutForCards.add(new ImageCard("Sede di Kilometro Rosso", "via Stezzano, 87, Bergamo e viale Europa, 4, Stezzano", "null"));
        layoutForCards.add(new ImageCard("Sede di Caniana", "via dei Caniana, 2", "null"));
        layoutForCards.add(new ImageCard("Sede di Pignolo", "via Pignolo, 123", "null"));
        layoutForCards.add(new ImageCard("Sede di Sant'Agostino", "piazzale Sant'Agostino, 2", "null"));
        layoutForCards.add(new ImageCard("Sede di Rosate", "piazza Rosate, 2", "null"));
        layoutForCards.add(new ImageCard("Sede di Salvecchio", "via Salvecchio, 19", "null"));
        layoutForCards.add(new ImageCard("Sede di Palazzo Bassi-Rathgeb", "via Pignolo, 76", "null"));
        getContent().add(layoutForFooter);
        layoutForFooter.add(textForFooter);
        

    }
}