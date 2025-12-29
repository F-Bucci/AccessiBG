package it.unibg.accessibilita.base.ui.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class BoxInfo extends Div {
	
	public BoxInfo(String orario, String contatti, String stato) {
		
		setWidthFull();
		addClassNames(
				LumoUtility.Background.CONTRAST_5,
				LumoUtility.Padding.LARGE,
				LumoUtility.BorderRadius.LARGE,
				LumoUtility.BorderColor.CONTRAST_10,
				LumoUtility.Border.ALL
				);
		
		H3 titolo = new H3("Informazioni");
		Paragraph pOrario = new Paragraph("Orario: " + orario); // modificare dopo aver sistemato database
		Paragraph pContatti = new Paragraph("Contatti: "); // modificare dopo aver sistemato database
		
		Span labelStato = new Span("Stato: ");
		Span badgeStato = createStatusBadge(stato);
		
		add(titolo, pOrario, pContatti, labelStato, badgeStato);
		
	}
	
	private Span createStatusBadge(String text) {
		Span badge = new Span(text);
		badge.getElement().getThemeList().add("Badge success");
		return badge;
	}
}
