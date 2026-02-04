package it.unibg.accessibilita.base.ui.component;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class AppButton extends Button {
	
	/**
	 * 
	 * @param text
	 * @param listener azione da eseguire
	 */
	public AppButton(String text, ComponentEventListener<ClickEvent<Button>> listener) {
		super(text);
		configureStyle();
		if(listener != null) {
			this.addClickListener(listener);
		}
	}
	/**
	 * 
	 * @param text
	 * @param icon icona di vaadin
	 * @param listener azione da eseguire
	 */
	public AppButton(String text, Icon icon, ComponentEventListener<ClickEvent<Button>> listener) {
		this(text,listener);
		this.setIcon(icon);
		configureStyle();
	}
	/**
	 * 
	 */
	public AppButton() {
		super();
		configureStyle();
	}
	/**
	 *  css
	 */
	private void configureStyle() {
        this.addClassNames(
            LumoUtility.FontWeight.SEMIBOLD,       // Font più marcato
            LumoUtility.TextTransform.UPPERCASE,   // Testo maiuscolo
            LumoUtility.FontSize.SMALL,   		   // Testo compatto
            
            LumoUtility.BorderRadius.LARGE,        // Bordi molto arrotondati
            LumoUtility.BoxShadow.SMALL,           // Ombreggiatura leggera
            
            LumoUtility.Height.MEDIUM,				// altezza 
            LumoUtility.Padding.Horizontal.LARGE,   // Pulsante più largo ai lati
            

            LumoUtility.AlignItems.CENTER,
            LumoUtility.JustifyContent.CENTER,
            LumoUtility.Gap.SMALL
            
        );}
}
 