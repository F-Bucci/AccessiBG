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
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import it.unibg.accessibilita.base.ui.component.AppFooter;
import it.unibg.accessibilita.base.ui.component.ImageCard;
import it.unibg.accessibilita.base.ui.component.ViewToolbar;

@Route(value = "home", layout = MainLayout.class) 
public class HomeView extends VerticalLayout { 

    public HomeView() {
    	
    	setSpacing(true);
    	setPadding(true);
    	setSizeFull();
    	setDefaultHorizontalComponentAlignment(Alignment.CENTER);

    	VerticalLayout header = createHeader();
    	
    	Div grigliaCard = createGrigliaCards();
    	addCards(grigliaCard);
    	
    	AppFooter footer = new AppFooter();
    	
    	add(header, grigliaCard, footer);
    	
    	//espande la griglia su tutta la pagina spingendo il footer in fondo.
    	expand(grigliaCard);
    }
    
    private VerticalLayout createHeader() {
    	VerticalLayout header = new VerticalLayout();
    	header.setPadding(false);
    	header.setSpacing(false);
    	header.setAlignItems(Alignment.CENTER);
    	
    	H1 titolo = new H1("AccessiBg");
    	titolo.addClassName(LumoUtility.Margin.Bottom.SMALL);
    	
    	H2 sottotitolo = new H2("Sedi universitarie di Bergamo");
    	sottotitolo.addClassNames(LumoUtility.TextColor.SECONDARY, LumoUtility.FontSize.LARGE);
    	
    	header.add(titolo, sottotitolo);
    	return header;
    }
    
    private Div createGrigliaCards(){
    	Div griglia = new Div();
    	griglia.setWidthFull();
    	griglia.setMaxWidth("1400px");
    	
    	griglia.getStyle()
    		//CSS
    		.set("display", "flex")
    		.set("flex-wrap", "wrap")
    		.set("gap", "30px")
    		.set("justify-content", "center");
    	return griglia;
    }
    
    private void addCards(Div container) {
    	container.add(new ImageCard("Sede di Dalmine", "via Pasubio, 3", null));
        container.add(new ImageCard("Sede di Kilometro Rosso", "via Stezzano, 87", null));
        container.add(new ImageCard("Sede di Caniana", "via dei Caniana, 2", null));
        container.add(new ImageCard("Sede di Pignolo", "via Pignolo, 123", null));
        container.add(new ImageCard("Sede di Sant'Agostino", "piazzale Sant'Agostino, 2", null));
        container.add(new ImageCard("Sede di Rosate", "piazza Rosate, 2", null));
        container.add(new ImageCard("Sede di Salvecchio", "via Salvecchio, 19", null));
        container.add(new ImageCard("Sede di Palazzo Bassi-Rathgeb", "via Pignolo, 76", null));
    }
    
}