package it.unibg.accessibilita.base.ui;

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

import Accessibilita.AccessiBG_Backend.Edificio;
import Accessibilita.AccessiBG_Backend.Sede;
import Accessibilita.AccessiBG_sqlite.EdificioDAO;
import Accessibilita.AccessiBG_sqlite.SedeDAO;
import it.unibg.accessibilita.base.ui.component.AppFooter;
import it.unibg.accessibilita.base.ui.component.AppTabs;
import it.unibg.accessibilita.base.ui.component.Box;
import it.unibg.accessibilita.base.ui.component.ImageCard;

import com.vaadin.flow.router.BeforeEvent;

@Route(value = "edifici", layout = MainLayout.class)
public class EdificiView extends VerticalLayout implements HasUrlParameter<String>{
	
	private final VerticalLayout contentContainer = new VerticalLayout();
	private final SedeDAO sedeDAO;
	private final EdificioDAO edificioDAO;
	public EdificiView(SedeDAO sedeDAO, EdificioDAO edificioDAO){
		this.sedeDAO = sedeDAO;
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
		H2 titolo = new H2(edificio.getNome());
		titolo.addClassNames(LumoUtility.Margin.Bottom.SMALL);
		
		Hr divisore = new Hr();
		
		AppTabs edificioTab = new AppTabs();
		edificioTab.addTab("Generale", createGeneraleContent(edificio));
		edificioTab.addTab("Ingressi", createIngressiContent());
		edificioTab.addTab("Servizi", createServiziContent());
		edificioTab.addTab("Mappa", createMappaContent());
        
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
		infoEdificio.setHeight("500px");
		rowCentrale.add(card, infoEdificio);
		layout.add(rowCentrale);
		return layout;
		
	}
	//TAB INGRESSI
	private VerticalLayout createIngressiContent() {
	    VerticalLayout layout = new VerticalLayout();
	    layout.setPadding(false);
	    layout.setSpacing(true);

	    return layout;
	}
	//TAB SERVIZI
	private VerticalLayout createServiziContent() {
	    VerticalLayout layout = new VerticalLayout();
	    layout.setPadding(false);
	    layout.setSpacing(true);

	    return layout;
	}
	//TAB MAPPA
	private VerticalLayout createMappaContent() {
	    VerticalLayout layout = new VerticalLayout();
	    layout.setPadding(false);
	    layout.setSpacing(true);

	    return layout;
	}

	
}
