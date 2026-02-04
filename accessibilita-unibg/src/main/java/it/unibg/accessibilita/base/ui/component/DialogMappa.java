package it.unibg.accessibilita.base.ui.component;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import struttura.ElementoMappa;
import struttura.Ostacolo;
/**
 * Questa classe estende il componente {@link Dialog} nativo di Vaadin, personalizzandolo per:
 * Mostrare un'immagine rappresentativa (se presente).
 * Adattare il messaggio di testo in base al tipo di elemento (es. avvisi per gli ostacoli).
 */
public class DialogMappa extends Dialog {
	
	/**
	 * Costruisce e apre il dialog popolandolo con i dati dell'elemento passato.
	 * * @param elemento L'oggetto {@link ElementoMappa} di cui visualizzare i dettagli.
	 * Viene controllato dinamicamente se è un {@link Ostacolo} per cambiare lo stile dell'avviso.
	 */
	public DialogMappa(ElementoMappa elemento) {
		//titoletto
		setHeaderTitle(elemento.getNome());
		//rende il dialog draggable e resizable
        setDraggable(true);
        setResizable(false);
        //rende possibile la chiusura del dialog cliccando ovunque
        setCloseOnOutsideClick(true);
        
        //layout
        VerticalLayout content = new VerticalLayout();
        content.setSpacing(true);
        content.setPadding(false);
        content.setAlignItems(FlexComponent.Alignment.CENTER);
        
        //Immagine
        if (elemento.getPathFoto() != null && !elemento.getPathFoto().isEmpty()) {
            Image img = new Image(elemento.getPathFoto(), elemento.getNome());
            //uniformo le immagine per renderle simili
            img.setWidth("100%");
            img.setMaxHeight("500px");
            //css
            img.getStyle().set("border-radius", "8px");
            img.getStyle().set("object-fit", "cover");
            content.add(img);
        }
       
        if(elemento instanceof Ostacolo) {
        	Span badge = new Span("ATTENZIONE: " + elemento.getDescrizione());
            badge.getElement().getThemeList().add("badge error");
            content.add(badge);
        } else {
        	Span badge = new Span( elemento.getDescrizione());
        	content.add(badge);
        }
        add(content);
        //bottone nel footer
        Button chiudi = new Button("Chiudi", e -> close());
        chiudi.getStyle().set("cursor", "pointer");
        getFooter().add(chiudi);
	}	
}
