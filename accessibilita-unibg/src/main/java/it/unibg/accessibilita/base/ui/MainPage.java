package it.unibg.accessibilita.base.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoIcon;

import it.unibg.accessibilita.base.ui.component.ViewToolbar;

@Route("") 
@PageTitle("Hello, Vaadin!") 
@Menu(order = 0, icon = "vaadin:clipboard-check", title = "Main Page")
public class MainPage extends VerticalLayout { 

	private Card createCard(String testo) {
		Card card = new Card();
		
		Icon iconTemp = LumoIcon.PHOTO.create();
		
		card.setMedia(iconTemp);
		card.add(testo);
		
		return card;
	};

    public MainPage() {
    	
    	add(new H1("AccessiBG")); 
    	
    	add(new ViewToolbar("", new Button("Login")));
    	
        add(new H3("Ciao, Vaadin!")); 

        
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
        
        add(iconCard1);
        add(iconCard2);
        add(iconCard3);
        add(iconCard4);
        add(iconCard5);
        add(iconCard6);
        add(iconCard7);
        add(iconCard8);

    }
}