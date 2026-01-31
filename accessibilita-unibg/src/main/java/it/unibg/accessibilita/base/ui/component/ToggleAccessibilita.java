package it.unibg.accessibilita.base.ui.component;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.theme.lumo.LumoUtility;
import it.unibg.accessibilita.base.ui.manager.SessionManager;

public class ToggleAccessibilita extends Checkbox{
	
	public ToggleAccessibilita() {
		//etichetta
		super("Modalità Accessibilità");
		this.addClassNames(
	            LumoUtility.Width.FULL,
	            LumoUtility.Padding.Horizontal.MEDIUM, 
	            LumoUtility.Padding.Vertical.SMALL,
	            LumoUtility.Display.FLEX,
	            LumoUtility.AlignItems.CENTER
	        );
		
		//leggo stato iniziale della sessione
		this.setValue(SessionManager.isAccessibilitaMode());
		//listener
		this.addValueChangeListener(event ->{
			boolean isActive = event.getValue();
			
			SessionManager.setAccessibilitaMode(isActive);
			//Messaggio all'utente
			String messaggio = isActive ? "Modalità accessibilità attivata" : "Modalità accessibilità disattivata";
			//la notifica viene mostrata in alto a sinistra per 3000 ms
			Notification.show(messaggio, 3000, Notification.Position.TOP_START);
			
			//ricarica la pagine per applicare i filtri
			UI.getCurrent().getPage().reload();
		});
	}
 }
