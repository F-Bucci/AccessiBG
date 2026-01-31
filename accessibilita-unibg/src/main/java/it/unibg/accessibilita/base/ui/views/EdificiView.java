package it.unibg.accessibilita.base.ui.views;

import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;

import dao.EdificioDAO;
import dao.PianoDAO;
import dao.SedeDAO;
import it.unibg.accessibilita.base.ui.component.AppButton;
import it.unibg.accessibilita.base.ui.component.AppFooter;
import it.unibg.accessibilita.base.ui.component.AppTabs;
import it.unibg.accessibilita.base.ui.component.Box;
import it.unibg.accessibilita.base.ui.component.ImageCard;
import it.unibg.accessibilita.base.ui.component.SelettorePiano;
import struttura.Edificio;
import struttura.Piano;
import struttura.Sede;

import com.vaadin.flow.router.BeforeEvent;

@Route(value = "edifici", layout = MainLayout.class)
public class EdificiView extends VerticalLayout implements HasUrlParameter<String>{
	
	private final SedeDAO sedeDAO;
	private final EdificioDAO edificioDAO;
	private final PianoDAO pianoDAO;
	
	public EdificiView(SedeDAO sedeDAO, EdificioDAO edificioDAO, PianoDAO pianoDAO){
		this.sedeDAO = sedeDAO;
		this.edificioDAO = edificioDAO;
		this.pianoDAO = pianoDAO;
		
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
		H2 titolo = new H2(edificio.getNome());
		titolo.addClassNames(LumoUtility.Margin.Bottom.SMALL);
		
		Hr divisore = new Hr();
		
		AppTabs edificioTab = new AppTabs();
		edificioTab.addTab("Generale", createGeneraleContent(edificio));
		edificioTab.addTab("Ingressi", createIngressiContent(edificio));
		edificioTab.addTab("Servizi", createServiziContent(edificio));
		edificioTab.addTab("Mappa", createMappaContent(edificio));
        
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
	private VerticalLayout createIngressiContent(Edificio edificio) {
	    VerticalLayout layout = new VerticalLayout();
	    layout.setPadding(false);
	    layout.setSpacing(true);

	    return layout;
	}
	//TAB SERVIZI
	private VerticalLayout createServiziContent(Edificio edificio) {
	    VerticalLayout layout = new VerticalLayout();
	    layout.setPadding(false);
	    layout.setSpacing(true);

	    return layout;
	}
	//TAB MAPPA
	private VerticalLayout createMappaContent(Edificio edificio) {
	    VerticalLayout layout = new VerticalLayout();
	    layout.setPadding(false);
	    layout.setSpacing(true);

	    return layout;
	}

	
}
