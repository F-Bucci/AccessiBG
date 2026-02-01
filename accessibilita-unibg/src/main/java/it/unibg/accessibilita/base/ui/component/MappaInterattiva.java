package it.unibg.accessibilita.base.ui.component;

import java.util.List;
import java.util.function.Consumer;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;

import struttura.Piano;
import struttura.Stanza;
import struttura.Distributore;
import struttura.ElementoMappa;
import struttura.Ostacolo;

public class MappaInterattiva extends Div {
	private final Div containerImg;
	private final Image mappaImg;
	private String mappaOriginale;
	private Consumer<ElementoMappa> onElementClick;
	public MappaInterattiva() {
	    getStyle().set("position", "relative");
	    getStyle().set("display", "inline-block");
	    setWidthFull();
	    setMaxWidth("1024px");

	    // CONTENITORE IMMAGINE
	    containerImg = new Div();
	    containerImg.getStyle().set("position", "relative");
	    containerImg.getStyle().set("display", "inline-block");
	    containerImg.setWidth("100%");

	    // IMMAGINE
	    mappaImg = new Image();
	    mappaImg.setWidth("100%");
	    mappaImg.getStyle().set("display", "block");

	    containerImg.add(mappaImg);
	    add(containerImg);
	}
	public void setOnElementClick(Consumer<ElementoMappa> handler) {
        this.onElementClick = handler;
    }
	//metodo per costruire la mappa
	public void mapBuilder(Piano piano, List<? extends ElementoMappa> elemento) {
		if(piano.getPathFoto() != null && !piano.getPathFoto().isEmpty()) {
			this.mappaOriginale = piano.getPathFoto();
			mappaImg.setSrc(this.mappaOriginale);
			containerImg.removeAll();
			containerImg.add(mappaImg);
			for(ElementoMappa e : elemento) {
				aggiungiPin(e);
			}
		}
		
		
	}
	private void aggiungiPin(ElementoMappa e) {
		MapPin pin = new MapPin(e);
		pin.getStyle().set("position", "absolute");
        pin.getStyle().set("left", e.getX() + "%");
        pin.getStyle().set("top", e.getY() + "%");
        pin.getStyle().set("transform", "translate(-50%, -50%)");
		pin.addClickListener(event ->{
		String imgPercorso = null;
		if(e instanceof Stanza) {
			imgPercorso = ((Stanza) e).getPathPercorso();
		} else if (e instanceof Distributore){
			imgPercorso = ((Distributore) e).getPathPercorso();
		}
		
		//logica cambio immagine
		if (imgPercorso != null && !imgPercorso.isEmpty()) {
			String newSrc = imgPercorso;
			mappaImg.setSrc(newSrc);
			}
		if (this.onElementClick != null) {
            this.onElementClick.accept(e);
        }
		});
		containerImg.add(pin);
	}
	public void Mapreset() {
		if (this.mappaOriginale != null) {
            mappaImg.setSrc(this.mappaOriginale);
	}
	}
}
