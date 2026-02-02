package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.*;

@Repository
public class PianoDAO extends DAO<Piano> {

	public PianoDAO(DSLContext dsl) {
		super(dsl);
	}

	@Override
	public void insert(Piano p) {
		dsl
			.insertInto(
					table("piano"), 
					field("num"),
					field("descrizione"),
					field("pathFoto"),
					field("edificio")
			)
			.values(
					p.getNumero(), 
					p.getDescrizione(),
					p.getPathFoto(), 
					p.getEdificio()
			)
			.onConflict(
					field("num"), 
					field("edificio")
			)
			.doNothing()
			.execute();
	}
		
	public Piano findPianoByEdificio(int num, String edificio) {
		var record = dsl
				.select(
						field("num"),
						field("descrizione"),
						field("pathFoto"),
						field("edificio")
				)
				.from(table("piano"))
				.where(field("num").eq(num))
				.and(field("edificio").eq(edificio))
				.fetchOne();
		
		if (record != null) {
			return new Piano(
					record.get("num", Integer.class),
					record.get("descrizione", String.class),
					record.get("pathFoto", String.class),
					record.get("edificio", String.class)
			);
		}
		return null;
	}
	
	public List<Distributore> findDistributoreByPiano(int piano) {
		return dsl	
				.selectFrom(table("distributore"))
				.where(field("piano").eq(piano))
				.fetchInto(Distributore.class);
	}
	
	public List<Stanza> findStanzaByPiano(int piano) {
		return dsl
				.selectFrom(table("stanza"))
				.where(field("piano").eq(piano))
				.fetchInto(Stanza.class);
	}
	
	public List<Ostacolo> findOstacoloByPiano(int piano) {
		return dsl
				.selectFrom(table("ostacolo"))
				.where(field("piano").eq(piano))
				.fetchInto(Ostacolo.class);
	}
}