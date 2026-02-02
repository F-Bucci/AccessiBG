package it.unibg.accessibilita.base.ui.manager;

import com.vaadin.flow.server.VaadinSession;

//questa classe serve a ricordare se l'utente e' in modalita accessibilita
//utilizzando la sessione (memoria temporanea)
public class SessionManager {
	
	private SessionManager() {}
    
	private static final String KEY_PREFERENZA = "accessibilita.mode";
	//se l'utente attiva questa modalita' per tutta la sessione sara' attiva
	public static void setAccessibilitaMode(boolean active) {
		VaadinSession.getCurrent().setAttribute(KEY_PREFERENZA, active);
		}
	// legge se la sessione accessibilita e' attiva
	public static boolean isAccessibilitaMode(){
		Object oggetto = VaadinSession.getCurrent().getAttribute(KEY_PREFERENZA);
		return oggetto != null && (boolean) oggetto;
	}
}