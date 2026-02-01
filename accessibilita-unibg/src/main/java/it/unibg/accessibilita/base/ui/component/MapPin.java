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
		VaadinIcon icona = VaadinIcon.CIRCLE;
        String colore = "gray";
        
        switch (e) {
        case Ostacolo o -> {
            icona = VaadinIcon.WARNING;
            colore = "#ffc107"; // Giallo
        }
        case Distributore d -> {
            icona = VaadinIcon.COFFEE;
            colore = "#d2691e"; // Marrone
        }
        case Stanza s -> {
            switch (s.getTipoStan()) {
                case AULA -> {
                    icona = VaadinIcon.ACADEMY_CAP;
                    colore = "#ff6347"; // Rosso pomodoro
                }
                case BAGNO_UOMO -> {
                    icona = VaadinIcon.MALE;
                    colore = "#007bff"; // Blu
                }
                case BAGNO_DONNA -> {
                    icona = VaadinIcon.FEMALE;
                    colore = "#ffb6c1"; // Rosa chiaro
                }
                default -> {} 
            }
        }

        default -> {}
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