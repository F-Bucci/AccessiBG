package it.unibg.accessibilita.base.ui.views;

import java.util.List;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import dao.EdificioDAO;

import it.unibg.accessibilita.base.ui.component.AppFooter;
import it.unibg.accessibilita.base.ui.component.AppTabs;
import it.unibg.accessibilita.base.ui.component.Box;
import it.unibg.accessibilita.base.ui.component.ImageCard;
import it.unibg.accessibilita.base.ui.component.SelettorePiano;
import struttura.Edificio;
import struttura.Piano;
import struttura.PuntoDiIngresso;


@Route(value = "edifici", layout = MainLayout.class)
public class EdificiView extends VerticalLayout implements HasUrlParameter<String>{
	
	private final transient EdificioDAO edificioDAO;
	
	public EdificiView(EdificioDAO edificioDAO){
		this.edificioDAO = edificioDAO;
		
		setSpacing(false);
		setPadding(true);
		setSizeFull();
	}
	@Override
	public void setParameter(BeforeEvent event, String nome) {
		removeAll();
		try {Edificio edificio = edificioDAO.findByName(nome);
			if(edificio != null){interfacciaEdificio(edificio);
			}
		}catch (Exception e){
			e.getMessage();
		}
	}
		public void interfacciaEdificio(Edificio edificio) {
		//TITOLO
		H2 titolo = new H2(edificio.getNome());
		titolo.addClassNames(LumoUtility.Margin.Bottom.SMALL);
		//DIVISORE TITOLO
		Hr divisore = new Hr();
		//TABS
		AppTabs edificioTab = new AppTabs();
		edificioTab.addTab("Generale", createGeneraleContent(edificio));
		edificioTab.addTab("Ingressi", createIngressiContent(edificio));
        //FOOTER
		AppFooter footer = new AppFooter();
		add(titolo, divisore, edificioTab, footer);
	}
	
	//TAB GENERALE
	private VerticalLayout createGeneraleContent(Edificio edificio) {
		VerticalLayout layout = new VerticalLayout();
		layout.setPadding(false);
		layout.setSpacing(true);
		layout.setWidthFull();
		layout.addClassNames(LumoUtility.Margin.Horizontal.AUTO);
		// zona immagine edificio + box
		HorizontalLayout rowCentrale = new HorizontalLayout();
        rowCentrale.setWidthFull();
        rowCentrale.setSpacing(true);
        rowCentrale.setAlignItems(Alignment.STRETCH);
		
		ImageCard card = new ImageCard(edificio.getNome(), edificio.getPathFoto());
		Box infoEdificio = new Box("Informazioni Generali");
		infoEdificio.add(new Paragraph("Indirizzo: " + edificio.getIndirizzo()));
		infoEdificio.add(new Paragraph("Orario: " + edificio.getOrario()));
		infoEdificio.setWidth("30%");
		infoEdificio.setMinWidth("250px");
		rowCentrale.add(card, infoEdificio);
		layout.add(rowCentrale);
		// zona bottone struttura
		List<Piano> piano = edificioDAO.findPianoByEdificio(edificio.getNome());
		
		if(piano != null && !piano.isEmpty()) {
		HorizontalLayout rowInferiore = new HorizontalLayout();
        rowInferiore.setPadding(true);
        
        SelettorePiano selector = new SelettorePiano(piano);
        rowInferiore.add(selector);
        layout.add(rowInferiore);
		}
		return layout;
	}
	//TAB INGRESSI
	private Div createIngressiContent(Edificio edificio) {
		Div griglia = new Div();
		griglia.getMaxWidth();
        griglia.getStyle()
        .set("display", "grid")
        .set("grid-template-columns", "repeat(auto-fill, minmax(300px, 1fr))")
        .set("gap", "40px")
        .set("padding", "20px 0")
        .set("justify-content", "center");
	    
        Div spacer = new Div();
        spacer.addClassName(LumoUtility.Flex.GROW);
        // creazione griglia con gli ingressi
		List<PuntoDiIngresso> ingresso = edificioDAO.findIngressoByEdificio(edificio.getNome());
		if(ingresso.isEmpty()) {return null;}
		for(PuntoDiIngresso p : ingresso) {
			ImageCard card = new ImageCard(p.getNome(),p.getPathFoto());
            card.getStyle().set("cursor", "pointer");
            griglia.add(card);
		}
	    return griglia;
	}
}
