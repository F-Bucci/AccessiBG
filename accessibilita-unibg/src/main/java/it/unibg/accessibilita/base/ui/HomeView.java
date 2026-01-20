package it.unibg.accessibilita.base.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import Accessibilita.AccessiBG_sqlite.CreateDB;
import Accessibilita.AccessiBG_sqlite.Sede;
import Accessibilita.AccessiBG_sqlite.SedeDAO;
import it.unibg.accessibilita.base.ui.component.AppFooter;
import it.unibg.accessibilita.base.ui.component.ImageCard;
import it.unibg.accessibilita.base.ui.component.ViewToolbar;

@Route(value = "", layout = MainLayout.class) 
public class HomeView extends VerticalLayout { 
	
	private final SedeDAO sedeDAO;
	
    public HomeView(SedeDAO sedeDAO, CreateDB createDB) {
    	
    	this.sedeDAO = sedeDAO;
    	
    	createDB.crea();
    	
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
    		}for(Sede s : sedi) {
        		
        		container.add(new ImageCard(s.getFacolta(), s.getIndirizzo(), s.getPathFoto()));
        	}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		container.add(new Paragraph("Errore Database: " + e.getMessage()));
    	}
    }
}
  /*  
    private VerticalLayout createHeader() {
    	VerticalLayout header = new VerticalLayout();
    	header.setPadding(false);
    	header.setSpacing(false);
    	header.setAlignItems(Alignment.CENTER);
    	
    	H1 titolo = new H1("Università degli Studi di Bergamo");
    	titolo.addClassName(LumoUtility.Margin.Bottom.SMALL);
    	
    	H2 sottotitolo = new H2("Sedi universitarie");
    	sottotitolo.addClassNames(LumoUtility.TextColor.SECONDARY, LumoUtility.FontSize.LARGE);
    	
    	header.add(titolo, sottotitolo);
    	return header;
    }
    

    
    private void addCards(Div container) {
    	Connection conn=CreateDB.getConnection();
    	for (Sede s: SedeDAO.findAll()) {
			container.add(new ImageCard(s.getFacolta(), s.getIndirizzo(), s.getPathFoto()));
		}
    }
 */   
