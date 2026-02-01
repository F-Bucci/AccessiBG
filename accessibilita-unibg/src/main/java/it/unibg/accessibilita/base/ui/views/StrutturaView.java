package it.unibg.accessibilita.base.ui.views;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import dao.DistributoreDAO;
import dao.EdificioDAO;
import dao.OstacoloDAO;
import dao.PianoDAO;
import dao.StanzaDAO;
import it.unibg.accessibilita.base.ui.component.AppButton;
import it.unibg.accessibilita.base.ui.component.MappaInterattiva;
import struttura.Distributore;
import struttura.Edificio;
import struttura.ElementoMappa;
import struttura.Ostacolo;
import struttura.Piano;
import struttura.Stanza;

@Route(value = "struttura", layout = MainLayout.class)
public class StrutturaView extends VerticalLayout implements HasUrlParameter<String>{
	
	private final EdificioDAO edificioDAO;
	private final PianoDAO pianoDAO;
	private final StanzaDAO stanzaDAO;
	private final OstacoloDAO ostacoloDAO;
	private DistributoreDAO distributoreDAO;
	public StrutturaView(EdificioDAO edificioDAO, PianoDAO pianoDAO,StanzaDAO stanzaDAO, OstacoloDAO ostacoloDAO, DistributoreDAO distributoreDAO) {
		this.edificioDAO = edificioDAO;
		this.pianoDAO = pianoDAO;
		this.stanzaDAO = stanzaDAO;
		this.ostacoloDAO = ostacoloDAO;
		this.distributoreDAO = distributoreDAO;
				
		setSpacing(false);
		setPadding(true);
		setSizeFull();
		
	}
	@Override
	public void setParameter(BeforeEvent event, String nome) {
		removeAll();
		try {List<Piano> piano = edificioDAO.findPianoByEdificio(nome);
			if(piano != null && !piano.isEmpty()){
				Piano iniPiano = piano.get(0);
				interfacciaPiano(iniPiano);
			}
		}catch (Exception e){
			e.getMessage();
		}
	}
	private void interfacciaPiano(Piano piano) {
		//creazione mappa utilizziamo una interfaccia
		MappaInterattiva mappa = new MappaInterattiva();
		List<ElementoMappa> elemento = new ArrayList<>();
		
		List<Stanza> s = pianoDAO.findStanzaByPiano(piano.getNumero());
		List<Ostacolo> o = pianoDAO.findOstacoloByPiano(piano.getNumero());
		List<Distributore> d = pianoDAO.findDistributoreByPiano(piano.getNumero());
		
		
		if(s != null) elemento.addAll(s);
		if(o != null) elemento.addAll(o);
		if(d != null) elemento.addAll(d);
		
		mappa.setOnElementClick(e -> apriDettaglio(e, mappa));
		mappa.mapBuilder(piano, elemento);
		mappa.setWidthFull();
		mappa.setMinHeight("600px");
		add(mappa);
	}
	//crea dialog (box che appare quando si clicca una icona)
	private void apriDettaglio(ElementoMappa elemento, MappaInterattiva mappa) {
		Dialog dialog = new Dialog();
		//dialog.setHeaderTitle(elemento.get);
		
		VerticalLayout layoutDettagli = new VerticalLayout();
	    layoutDettagli.setAlignItems(Alignment.CENTER);
	    layoutDettagli.setSpacing(true);
	    //aggiunge foto nel dialog
	    if (elemento.getPathFoto() != null && !elemento.getPathFoto().isEmpty()) {
	        Image img = new Image(elemento.getPathFoto(), "cambaire con metodo per il nome");
	        img.setWidth("250px");
	        layoutDettagli.add(img);
	    }
	    //bottone per chiudere dialog
	    AppButton chiudi = new AppButton("Chiudi", event ->{
	    	//mappa.Mapreset();
	    	dialog.close();
	    });
	    dialog.getFooter().add(chiudi);
	    dialog.add(layoutDettagli);
	    dialog.open();
	}
	
		
	}
