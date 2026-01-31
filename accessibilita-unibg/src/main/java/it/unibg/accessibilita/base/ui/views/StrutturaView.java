package it.unibg.accessibilita.base.ui.views;

import java.util.List;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import dao.EdificioDAO;
import dao.PianoDAO;
import struttura.Edificio;
import struttura.Piano;

@Route(value = "struttura", layout = MainLayout.class)
public class StrutturaView extends VerticalLayout implements HasUrlParameter<String>{
	
	private final EdificioDAO edificioDAO;
	private final PianoDAO pianoDAO;
	public StrutturaView(EdificioDAO edificioDAO, PianoDAO pianoDAO) {
		this.edificioDAO = edificioDAO;
		this.pianoDAO = pianoDAO;
				
		setSpacing(false);
		setPadding(true);
		setSizeFull();;
		
	}
	@Override
	public void setParameter(BeforeEvent event, String parameter) {
			removeAll();
			String nomeEdificio = parameter;
			int nPianoRicercato = 0;
			
			if(parameter.contains("/")) {
				String[] part = parameter.split("/");
				nomeEdificio = part[0];
				try {
					nPianoRicercato = Integer.parseInt(part[1]);
				} catch (NumberFormatException e) {
					nPianoRicercato = 0;
				}
			}
			try {
				List<Piano> piano = edificioDAO.findPianoByEdificio(nomeEdificio);
				if(piano != null && !piano.isEmpty()){
					Piano pianoTrovato = null;
					for(Piano p : piano){
						if(p.getNumero() == nPianoRicercato) {
							pianoTrovato = p;
							break;
						}
					}
					
					if(pianoTrovato == null) {
						pianoTrovato = piano.get(0);
					}
					
					interfacciaPiano(pianoTrovato);
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	private void interfacciaPiano(Piano piano) {
		// TODO Auto-generated method stub
		
	}
		
	}
