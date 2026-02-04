package it.unibg.accessibilita.base.ui.views;

import java.util.List;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import dao.SedeDAO;
import it.unibg.accessibilita.base.ui.component.AppFooter;
import it.unibg.accessibilita.base.ui.component.ImageCard;
import struttura.Sede;

@Route(value = "", layout = MainLayout.class) 
/**
 * Home della webapp
 */
public class HomeView extends VerticalLayout { 
	
	private final transient SedeDAO sedeDAO;
	/**
	 * Inizializza la struttura verticale, aggiunge intestazioni, il contenitore delle card e il footer.
	 * @param sedeDAO Data Access Object iniettato per il recupero delle sedi universitarie.
	 */
    public HomeView(SedeDAO sedeDAO) {
    	this.sedeDAO = sedeDAO;
    	
    	setSizeFull();
    	setAlignItems(Alignment.CENTER);
    	
    	H1 titolo = new H1("Università degli Studi di Bergamo");
    	titolo.addClassNames(LumoUtility.FontSize.XLARGE, LumoUtility.TextAlignment.CENTER);
    	H2 sottotitolo = new H2("Sedi universitarie");
    	sottotitolo.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.TextAlignment.CENTER);
    	Div container = createGrigliaCards(); 
    	Div spacer = new Div();
        spacer.addClassName(LumoUtility.Flex.GROW);
    	AppFooter footer = new AppFooter();
    	footer.setWidthFull();
    	add(titolo, sottotitolo, container, spacer,  footer);
        addCards(container);
    }
    /**
     * Configura il contenitore grafico per le card.
     * @return un Div configurato come griglia flessibile
     */ 
    private Div createGrigliaCards(){
    	Div griglia = new Div();
    	griglia.setWidthFull();
    	griglia.setMaxWidth("1400px");
    	
    	griglia.getStyle()
    		//CSS
    		.set("display", "flex")
    		.set("flex-wrap", "wrap")
    		.set("gap", "30px")
    		.set("justify-content", "center");
    	return griglia;
    }
    /**
     * 
     * @param container il Div in cui inserire le card generate
     */
    private void addCards(Div container) {
    	try {
    		List<Sede> sedi = sedeDAO.findAll();
    		
    		for(Sede s : sedi) {
        		ImageCard card = new ImageCard(s.getFacolta(), s.getIndirizzo(), s.getPathFoto());
                card.getStyle().set("cursor", "pointer");
                card.addClickListener(event ->
                    card.getUI().ifPresent(ui ->  ui.navigate(SediView.class, s.getFacolta())
                    ));
                

        		container.add(card);
        	}
    	} catch (Exception e) {
    		e.printStackTrace();
    		container.add(new Paragraph("Errore Database: " + e.getMessage()));
    	}
    }
}
