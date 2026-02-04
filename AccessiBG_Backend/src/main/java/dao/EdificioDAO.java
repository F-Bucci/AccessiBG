package dao;

import org.jooq.DSLContext;

import static org.jooq.impl.DSL.*;

import org.springframework.stereotype.Repository;

import struttura.Edificio;
import struttura.Piano;
import struttura.PuntoDiIngresso;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EdificioDAO extends DAO<Edificio> {
	
	static final String EDIFICIO = "edificio";
	static final String NOME = "nome";
	static final String INDIRIZZO = "indirizzo";
	static final String ORARIO = "orario";
	static final String PATHFOTO = "pathFoto";
	static final String FACOLTA = "facolta";
	
		
	public EdificioDAO(DSLContext dsl) {
		super(dsl);
	}
	
	@Override
	public void insert(Edificio e) {
		dsl.insertInto(
				table(EDIFICIO),
				field(NOME),
				field(INDIRIZZO),
				field(ORARIO),
				field(PATHFOTO),
				field(FACOLTA)
		)
		.values(
				e.getNome(),
				e.getIndirizzo(),
				e.getOrario(),
				e.getPathFoto(),
				e.getFacolta()
		)
		.onConflict(
				field(NOME),
				field(FACOLTA)
		)
		.doNothing()
		.execute();
	}

    // restituisce edificio in base a nome e facolta, forse non utile, implementato già con sede
	public Edificio findByEdificioFacolta(String nome, String facolta) {
		var istanza = dsl
				.select(
						field(NOME),
						field(INDIRIZZO),
						field(ORARIO),
						field(PATHFOTO),
						field(FACOLTA)
				)
				.from(table(EDIFICIO))
				.where(field(NOME).eq(nome)) 
				.and(field(FACOLTA).eq(facolta))
				.fetchOne();
		if (istanza != null) {
			return new Edificio(
					istanza.get(NOME, String.class),
					istanza.get(INDIRIZZO, String.class),
					istanza.get(ORARIO, String.class),
					istanza.get(PATHFOTO, String.class),
					istanza.get(FACOLTA, String.class)
			);
		}
		
		return null;
	}
	
    // cerca l'edificio in base al nome mi serve per navigazione tra le views
	public Edificio findByName(String nome) {
		var istanza = dsl.select(
				field(NOME),
				field(INDIRIZZO),
				field(ORARIO), 
				field(PATHFOTO), 
				field(FACOLTA)
				)
				.from(table(EDIFICIO))	
				.where(field(NOME).eq(nome))
				.fetchOne();
		if (istanza != null) {
			return new Edificio(
					istanza.get(NOME, String.class),
					istanza.get(INDIRIZZO, String.class),
					istanza.get(ORARIO, String.class),
					istanza.get(PATHFOTO, String.class),
					istanza.get(FACOLTA, String.class)
			);
		}
		
		return null;
	}
	
	// gia implementato in sede, potrebbe non servire, da valutare
	public List<Edificio> findAll(){
		try {return dsl
				.selectFrom(table("edificio"))
				.fetch(istanza -> new Edificio(
						istanza.get(NOME, String.class),
						istanza.get(INDIRIZZO, String.class),
						istanza.get(ORARIO, String.class),
						istanza.get(PATHFOTO, String.class),
						istanza.get(FACOLTA, String.class)
				));
		} catch(Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public List<Piano> findPianoByEdificio(String edificio) {
	    return dsl
	        .selectFrom(table("piano"))
	        .where(field(EDIFICIO).eq(edificio))
	        .fetchInto(Piano.class);}
	
	public List<PuntoDiIngresso> findIngressoByEdificio(String edificio) {
	    return dsl
	        .selectFrom(table("puntiAccesso"))
	        .where(field(EDIFICIO).eq(edificio))
	        .fetchInto(PuntoDiIngresso.class);
	}
}