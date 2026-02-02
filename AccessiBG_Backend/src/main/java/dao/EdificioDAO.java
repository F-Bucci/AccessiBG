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
		
	public EdificioDAO(DSLContext dsl) {
		super(dsl);
	}
	
	@Override
	public void insert(Edificio e) {
		dsl.insertInto(table("edificio"), field("nome"),field("indirizzo"),field("orario"), field("pathFoto"), field("facolta"))
		.values(e.getNome(), e.getIndirizzo(), e.getOrario(), e.getPathFoto(), e.getFacolta())
		.onConflict(field("nome"), field("facolta"))
		.doNothing()
		.execute();
	}

//	restituisce edificio in base a nome e facolta, forse non utile, implementato già con sede
	public Edificio findByEdificioFacolta(String nome, String facolta) {
		var record = dsl.select(field("nome"),field("indirizzo"),field("orario"), field("pathFoto"), field("facolta"))
				.from(table("edificio"))
				.where(field("nome").eq(nome)) 
				.and(field("facolta").eq(facolta))
				.fetchOne();
		if (record != null) {
			return new Edificio(
					record.get("nome", String.class),
					record.get("indirizzo", String.class),
					record.get("orario", String.class),
					record.get("pathFoto", String.class),
					record.get("facolta", String.class)
					);}
		return null;}
	
// cerca l'edificio in base al nome mi serve per navigazione tra le views
	public Edificio findByName(String nome) {
		var record = dsl.select(
				field("nome"),
				field("indirizzo"),
				field("orario"), 
				field("pathFoto"), 
				field("facolta")
				)
				.from(table("edificio"))	
				.where(field("nome").eq(nome))
				.fetchOne();
		if (record != null) {
			return new Edificio(
					record.get("nome", String.class),
					record.get("indirizzo", String.class),
					record.get("orario", String.class),
					record.get("pathFoto", String.class),
					record.get("facolta", String.class)
					);
		}
		return null;
	}
//	gia implementato in sede, potrebbe non servire, da valutare
	public List<Edificio> findAll(){
		try {return dsl.selectFrom(table("sede"))
				.fetch(record ->
				new Edificio(
						record.get("nome", String.class),
						record.get("indirizzo", String.class),
						record.get("orario", String.class),
						record.get("pathFoto", String.class),
						record.get("facolta", String.class)));
		}catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public List<Piano> findPianoByEdificio(String edificio) {
	    return dsl
	        .selectFrom(table("piano"))
	        .where(field("edificio").eq(edificio))
	        .fetchInto(Piano.class);}
	
	public List<PuntoDiIngresso> findIngressoByEdificio(String edificio) {
	    return dsl
	        .selectFrom(table("puntiAccesso"))
	        .where(field("edificio").eq(edificio))
	        .fetchInto(PuntoDiIngresso.class);}
}