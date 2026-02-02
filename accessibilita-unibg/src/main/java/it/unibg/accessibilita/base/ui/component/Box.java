package it.unibg.accessibilita.base.ui.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Box extends Div {
	
	public Box(String titoloBox) {
		
		setWidthFull();
		addClassNames(
				LumoUtility.Background.CONTRAST_5,
				LumoUtility.Padding.LARGE,
				LumoUtility.BorderRadius.LARGE,
				LumoUtility.BorderColor.CONTRAST_10,
				LumoUtility.Border.ALL
				);
		
		if(titoloBox !=null && !titoloBox.isEmpty()) {
			H3 titolo = new H3(titoloBox);
			titolo.addClassName(LumoUtility.Margin.Top.NONE);
			add(titolo);
		}
		
	}
	
	// SE VOGLIAMO AGGIUNGERE UN TELEFONO, UNA MAIL, UN ORARIO ES.(ORARIO: 8:00-19:00)
	public void addInfo(String soggetto, String valore) {
		Span soggettoSpan = new Span(soggetto + ": ");
		soggettoSpan.addClassName(LumoUtility.FontWeight.BOLD);
		
		Span valoreSpan = new Span(valore);
		
		Div riga = new Div(soggettoSpan, valoreSpan);
		add(riga);
	}
	// SE VOGLIAMO AGGIUNGERE UN PARAGRAFO DI TESTO
	public void addParagrafo(String testo) {
		if(testo != null && !testo.isEmpty()) {
			Paragraph p = new Paragraph(testo);
			p.addClassNames(LumoUtility.TextColor.SECONDARY, LumoUtility.Margin.Bottom.SMALL);
			add(p);
		}
	}
}
	
