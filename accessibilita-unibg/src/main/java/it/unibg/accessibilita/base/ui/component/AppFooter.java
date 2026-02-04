package it.unibg.accessibilita.base.ui.component;

import org.threeten.bp.LocalDate;

import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class AppFooter extends VerticalLayout {
	/**
	 * Componente che rappresenta il piè di pagina standard dell'applicazione.
	 */
	public AppFooter(){
	setWidthFull();
	setPadding(false);
	setSpacing(true);
	setAlignItems(Alignment.CENTER);
	addClassNames(LumoUtility.Margin.Top.XLARGE);
	
	Hr lineaFooter = new Hr();
	lineaFooter.setWidthFull();
	 //HO AGGIUNTO L'ANNO AUTOMATICO PER MANUTENIBILITA'
	int year = LocalDate.now().getYear();
	Paragraph testoFooter = new Paragraph("@" + year + " AccessiBG" );
	testoFooter.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);
	
	add(lineaFooter, testoFooter);
	}
}