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


    public MainPage() {
    	
    	add(new H1("AccessiBG")); 
    	
    	add(new ViewToolbar("", new Button("Login")));
    	
        add(new H3("Ciao, Vaadin!")); 

        Card iconCard = new Card();
        Icon icon = LumoIcon.PHOTO.create();
        iconCard.setMedia(icon);
        iconCard.add(
                "Sede di Dalmine");
        add(iconCard);

    }
}