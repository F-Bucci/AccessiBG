package it.unibg.accessibilita.base.ui.component;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.theme.lumo.Lumo;

public class ThemeToggleButton extends Button{
	
	public ThemeToggleButton() {
		
		super("Tema Scuro", VaadinIcon.MOON_O.create());
		
		addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_SMALL);
		getStyle().set("padding-left", "0");
		getElement().setAttribute("aria-label", "Cambia tema");
		
		addClickListener(this::handleClick);
	}
	
	private void handleClick(ClickEvent<Button> e) {
		ThemeList themeList = UI.getCurrent().getElement().getThemeList();
		boolean isDark = themeList.contains(Lumo.DARK);
		
		if (isDark) {
			//scuro -> chiaro
			themeList.remove(Lumo.DARK);
			update(false);
		} else {
			//chiaro -> scuro
			themeList.add(Lumo.DARK);
			update(true);
		}
	}
	
	public void update(boolean isDarkActive) {
	if(isDarkActive) {
		setIcon(VaadinIcon.SUN_O.create());
        setText("Tema Chiaro");
	} else {
		setIcon(VaadinIcon.MOON_O.create());
        setText("Tema Scuro");
		}
	}
}
