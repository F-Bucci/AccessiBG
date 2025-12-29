package it.unibg.accessibilita.base.ui.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class ImageCard extends Div{

	public ImageCard(String nome, String indirizzo, String urlImmagine) {
		
		addClassNames(
				LumoUtility.Background.BASE,
				LumoUtility.BoxShadow.SMALL,
				LumoUtility.BorderRadius.LARGE,
				LumoUtility.Padding.MEDIUM,
				LumoUtility.Display.FLEX,
				LumoUtility.FlexDirection.COLUMN,
				LumoUtility.AlignItems.CENTER,
				LumoUtility.Border.ALL,
				LumoUtility.BorderColor.CONTRAST_10
				);
		
		
		// DA MODIFICARE APPENA ABBIAMO FATTO UN COLLEGAMENTO COL DATABASE
		setWidth("300px");
		// NON HO IMPOSTATO IL SET HEIGHT COSI VEDIAMO SE LA CARD SI ADATTA AL CONTENUTO
		
		// FACCIO UN ELSE IF PER METTERE UNA ICON AL POSTO DI UNA IMMAGINE SE NON TROVATA
		Div imageContainer = new Div();
		if(urlImmagine != null && !urlImmagine.isEmpty()){
			Image img = new Image(urlImmagine, nome);
			img.setWidth("100%");
			img.setHeight("150px");
			img.addClassName(LumoUtility.BorderRadius.MEDIUM);
			img.getStyle().set("object-fit", "cover");
			imageContainer.add(img);
		} else {
			Icon icon = LumoIcon.PHOTO.create();
			icon.setSize("50px");
			imageContainer.add(icon);
		}
		
		Span nomeSpan = new Span(nome);
		nomeSpan.addClassNames(LumoUtility.FontWeight.BOLD, LumoUtility.FontSize.LARGE);
		
		Span indirizzoSpan = new Span(indirizzo);
		indirizzoSpan.addClassNames(LumoUtility.TextColor.SECONDARY, LumoUtility.FontSize.SMALL);
		
		add(imageContainer, nomeSpan, indirizzoSpan);
		
		
		
	}
}
