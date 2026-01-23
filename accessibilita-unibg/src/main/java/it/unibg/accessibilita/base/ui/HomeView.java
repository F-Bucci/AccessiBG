package it.unibg.accessibilita.base.ui;

import java.util.List;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import Accessibilita.AccessiBG_Backend.Sede;
import Accessibilita.AccessiBG_sqlite.CreateDB;
import Accessibilita.AccessiBG_sqlite.SedeDAO;
import it.unibg.accessibilita.base.ui.component.AppFooter;
import it.unibg.accessibilita.base.ui.component.ImageCard;

@Route(value = "", layout = MainLayout.class) 
public class HomeView extends VerticalLayout { 
	
	private final SedeDAO sedeDAO;
	
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
    
    private void addCards(Div container) {
    	try {
    		List<Sede> sedi = sedeDAO.findAll();
    		
    		if(sedi.isEmpty()) {
    			System.out.println("DB vuoto");
    		}
    		for(Sede s : sedi) {
        		ImageCard card = new ImageCard(s.getFacolta(), s.getIndirizzo(), s.getPathFoto());
                card.getStyle().set("cursor", "pointer");
                card.addClickListener(e -> {
                    card.getUI().ifPresent(ui ->  ui.navigate(SediView.class, s.getFacolta())
                    );
                });

        		container.add(card);
        	}
    	} catch (Exception e) {
    		e.printStackTrace();
    		container.add(new Paragraph("Errore Database: " + e.getMessage()));
    	}
    }
}
