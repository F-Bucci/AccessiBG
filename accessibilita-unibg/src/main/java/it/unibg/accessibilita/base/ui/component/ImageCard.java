package it.unibg.accessibilita.base.ui.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class ImageCard extends Div{

	public ImageCard(String titolo, String pathFoto) {
		this(titolo, null, null, pathFoto);
	}
	public ImageCard(String titolo, String sottotitolo, String pathFoto) {
		this(titolo, sottotitolo, null, pathFoto);
	}
	public ImageCard(String titolo, String sottotitolo, String descrizione, String pathFoto) {
		
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
		
		setWidth("300px");
		// NON HO IMPOSTATO IL SET HEIGHT COSI VEDIAMO SE LA CARD SI ADATTA AL CONTENUTO
		
		//IMMAGINE
		Div imageContainer = new Div();
		imageContainer.setWidthFull();
		imageContainer.setHeight("180 px");
		imageContainer.addClassNames(LumoUtility.Display.FLEX, LumoUtility.JustifyContent.CENTER, LumoUtility.AlignItems.CENTER, LumoUtility.Background.CONTRAST_5);
		
		String url = fixUrl(pathFoto);
		if(isUrlValid(url)) {
			Image img = new Image(url, titolo);
			img.setWidthFull();
			img.setHeightFull();
			img.getStyle().set("object-fit", "cover");
			imageContainer.add(img);
		}else {
			Icon icon = LumoIcon.PHOTO.create();
			icon.setSize("48px");
            icon.setColor("gray");
            imageContainer.add(icon);
		}
		//TESTO
		
		VerticalLayout testo = new VerticalLayout();
		testo.setPadding(true);
		testo.setSpacing(false);
		
		//TITOLO
		Span titoloSpan = new Span(titolo);
		titoloSpan.addClassNames(LumoUtility.FontWeight.BOLD, LumoUtility.FontSize.LARGE);
		testo.add(titoloSpan);
		
		//SOTTOTILO
		if(sottotitolo != null && !sottotitolo.isEmpty()){
			Span sottoSpan = new Span(sottotitolo);
			sottoSpan.addClassNames(LumoUtility.TextColor.SECONDARY, LumoUtility.FontSize.SMALL);
			testo.add(sottoSpan);
		}
		
		//DESCRIZIONE 
		if(descrizione != null && !descrizione.isEmpty()) {
			Paragraph descP = new Paragraph(descrizione);
			descP.getStyle().set("display", "-webkit-box");
            descP.getStyle().set("-webkit-line-clamp", "3"); // Max 3 righe
            descP.getStyle().set("-webkit-box-orient", "vertical");
            descP.getStyle().set("overflow", "hidden");
            
            testo.add(descP);
		}
		
		add(imageContainer, testo);
		
	}
	
	//evita che java vada in crash se dal database arriva un campo vuoto
	//toglie gli spazi in caso di inserimento accidentale
	private String fixUrl(String url) {
        if (url == null || url.trim().isEmpty()) return "";
        if (url.startsWith("http") || url.startsWith("/")) return url;
        return "/" + url.trim();
    }
	//verifica che le immagini finiscano con .webp
    private boolean isUrlValid(String url) {
        if (url == null || url.isEmpty()) return false;
        String lower = url.toLowerCase();
        return lower.endsWith(".webp");
    }
}