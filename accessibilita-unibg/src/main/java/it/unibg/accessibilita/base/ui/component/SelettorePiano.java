package it.unibg.accessibilita.base.ui.component;

import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.select.Select;
import it.unibg.accessibilita.base.ui.views.StrutturaView;
import struttura.Piano;

public class SelettorePiano extends Select<Piano>{
	
	public SelettorePiano(List<Piano> piani) {
		super();
		
		this.setLabel("Visualizza piani edificio");
		this.setPlaceholder("Seleziona un piano...");
		this.setWidthFull();
		
		this.setItems(piani);
		this.setItemLabelGenerator(p -> "Piano " + p.getNumero());
		this.addValueChangeListener(event -> {
			Piano p = event.getValue();
			if(p!= null) {
			String nomeEdificio = p.getEdificio();
			UI.getCurrent().navigate(StrutturaView.class, nomeEdificio);
			this.clear();
			}
		});
	}
}
