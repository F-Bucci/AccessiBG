package it.unibg.accessibilita.base.ui.component;

import java.util.List;
import java.util.function.Consumer;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;


import struttura.Piano;
import struttura.Stanza;
import struttura.Distributore;
import struttura.ElementoMappa;

public class MappaInterattiva extends Div {
	private static final String STYLE_DISPLAY = "display";
	private static final String FULL_WIDTH = "100%";
	private static final String POSITION = "position";
	private final Div containerImg;
	private final Image mappaImg;
	private String mappaOriginale;
	private transient Consumer<ElementoMappa> onElementClick;
	public MappaInterattiva() {
	    getStyle().set(POSITION, "relative");
	    getStyle().set(STYLE_DISPLAY, "inline-block");
	    setWidthFull();
	    setMaxWidth("1024px");

	    // CONTENITORE IMMAGINE
	    containerImg = new Div();
	    containerImg.getStyle().set(POSITION, "relative");
	    containerImg.getStyle().set(STYLE_DISPLAY, "inline-block");
	    containerImg.setWidth("100%");

	    // IMMAGINE
	    mappaImg = new Image();
	    mappaImg.setWidth("100%");
	    mappaImg.getStyle().set(FULL_WIDTH, "block");

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
		pin.getStyle().set(POSITION, "absolute");
        pin.getStyle().set("left", e.getX() + "%");
        pin.getStyle().set("top", e.getY() + "%");
        pin.getStyle().set("transform", "translate(-50%, -50%)");
		pin.addClickListener(event ->{
		String imgPercorso = null;
		if(e instanceof Stanza s) {
			imgPercorso = s.getPathPercorso();
		} else if (e instanceof Distributore d){
			imgPercorso = d.getPathPercorso();
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
	public void mapReset() {
		if (this.mappaOriginale != null) {
            mappaImg.setSrc(this.mappaOriginale);
	}
	}
}
