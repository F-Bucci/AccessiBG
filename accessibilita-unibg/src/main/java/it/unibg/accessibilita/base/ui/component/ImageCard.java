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
	/**
	 * 
	 * @param titolo
	 * @param pathFoto percorso dell'immagine
	 */
	public ImageCard(String titolo, String pathFoto) {
		this(titolo, null, null, pathFoto);
	}
	/**
	 * 
	 * @param titolo
	 * @param sottotitolo
	 * @param pathFoto percorso dell'immagine
	 */
	public ImageCard(String titolo, String sottotitolo, String pathFoto) {
		this(titolo, sottotitolo, null, pathFoto);
	}
	/**
	 * 
	 * @param titolo
	 * @param sottotitolo
	 * @param descrizione
	 * @param pathFoto percorso dell'immagine
	 */
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
		
		
		//IMMAGINE
		Div imageContainer = new Div();
		imageContainer.setWidthFull();
		imageContainer.setHeight("200px");
		imageContainer.getStyle().set("border-radius", "8px 8px 0 0");
		imageContainer.getStyle().set("object-fit", "cover");
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
	
	/**
	 * 
	 * Se l'URL è incompleto, questo viene aggiunto automaticamente.
	 * Se l'URL è completo, rimane invariato
	 * 
	 * @param url indirizzo url da controllare. Può essere null.
	 * @return L'URL normalizzato, oppure una stringa vuota se l'input è null o vuoto.
	 */
	private String fixUrl(String url) {
        if (url == null || url.trim().isEmpty()) return "";
        if (url.startsWith("http") || url.startsWith("/")) return url;
        return "/" + url.trim();
    }
	/**
	 * 
	 * Verifica che l'URL punti a un file immagine supportato (formato .webp).
	 * 
	 * @param url  
	 * @return
	 */
	
	//verifica che le immagini finiscano con .webp
    private boolean isUrlValid(String url) {
        if (url == null || url.isEmpty()) return false;
        String lower = url.toLowerCase();
        return lower.endsWith(".webp");
    }
}