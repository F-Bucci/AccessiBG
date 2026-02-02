package it.unibg.accessibilita.base.ui.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;

import struttura.Distributore;
import struttura.ElementoMappa;
import struttura.Ostacolo;
import struttura.Stanza;

public class MapPin extends Div{
	public MapPin(ElementoMappa e) {
        // Crea delle icone in base al tipo di elemento
        VaadinIcon icona = VaadinIcon.CIRCLE;
        String colore = "gray";

        if (e instanceof Ostacolo) {
            icona = VaadinIcon.WARNING;
            colore = "#ffc107"; // Giallo
        } 
        else if (e instanceof Distributore d) {
        	switch (d.getTipo()) {
        	case BEVANDE_CALDE:
                icona = VaadinIcon.COFFEE;
                colore = "#964B00"; // Marrone
                break;
        	case ACQUA:
        		icona = VaadinIcon.DROP;
        		colore = "#343a90"; // blu chiarissimo
        		break;
        	
        	case SNACK_E_BEVANDE:
        		icona = VaadinIcon.CART_O;
        		colore = "#90ec53"; // verde chiaro
        		break;
        	default: 
        		//icona grigia
        		break;
        	}
        } 
        else if (e instanceof Stanza s) {
            switch (s.getTipoStan()) {
                case AULA:
                    icona = VaadinIcon.ACADEMY_CAP;
                    colore = "#ff6347"; // Rosso pomodoro
                    break;
                case AULA_STUDIO:
                    icona = VaadinIcon.ACADEMY_CAP;
                    colore = "ffd10a"; //
                    break;
                case BAGNO_UOMO:
                    icona = VaadinIcon.MALE;
                    colore = "#007bff"; // Blu
                    break;
                case BAGNO_DONNA:
                    icona = VaadinIcon.FEMALE;
                    colore = "#ffb6c1"; // Rosa chiaro
                    break;
                default:
                    // Colore grigio di default già impostato sopra
                    break;
            }
        }

        graficaMappa(icona, colore);
    }
	
	private void graficaMappa(VaadinIcon icon, String colore) {
		
		setWidth("32px");
        setHeight("32px");
        getStyle().set("background-color", colore);
        
        addClassNames(
                LumoUtility.Display.FLEX,            
                LumoUtility.AlignItems.CENTER,       
                LumoUtility.JustifyContent.CENTER,   
                LumoUtility.BorderRadius.FULL,      
                LumoUtility.BoxShadow.MEDIUM    
                );
        
        getStyle().set("border", "2px solid white");// bordo 2px
        //TRANSIZIONE
        getStyle().set("transition", "transform 0.2s ease-out");
        //ICONA
        Icon icona = icon.create();
        icona.setSize("18px"); //grandezza 18px
        icona.setColor("white"); //colore icona bianco
        add(icona);
        //REAZIONI ALL'UTENTE
        getElement().addEventListener("mouseover", event -> {
        	//aumenta la grandezza del 120% quando ci si passa il mnouse sopra
            getStyle().set("transform", "translate(-50%, -50%) scale(1.2)");
            getStyle().set("z-index", "10");
        });
        //l'icona quando il mouse non e' piu sopra torna normale
        getElement().addEventListener("mouseout", event -> {
            getStyle().set("transform", "translate(-50%, -50%) scale(1.0)");
            getStyle().set("z-index", "1");
        });
	}
}