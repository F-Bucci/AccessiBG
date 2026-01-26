package Accessibilita.AccessiBG_sqlite;

import org.jooq.DSLContext;

import static org.jooq.impl.DSL.*;

import org.springframework.stereotype.Repository;

import Accessibilita.AccessiBG_Backend.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EdificioDAO {
		
	private final DSLContext dsl;
		
	public EdificioDAO(DSLContext dsl) {
		this.dsl = dsl;
	}

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
}