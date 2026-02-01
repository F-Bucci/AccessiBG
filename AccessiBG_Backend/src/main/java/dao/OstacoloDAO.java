package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.*;

@Repository
public class OstacoloDAO {
		
	private final DSLContext dsl;

	public OstacoloDAO(DSLContext dsl) {
		this.dsl = dsl;
	}

	public void insert(Ostacolo o) {
		dsl.insertInto(table("stanza"), field("id"),field("tipo"),field("descrizione"),field("x"),field("y"),field("pathFoto"),field("pathPercorso"), field("piano"))
		.values(o.getId(), o.getTipo(), o.getDescrizione(),o.getX(), o.getY(), o.getPathFoto(), o.getPathPercorso(), o.getPiano())
		.onConflict(field("id"), field("id"))
		.doNothing()
		.execute();
	}

	public Ostacolo findById(int id) {
		var record = dsl.select(field("id"),field("tipo"),field("descrizione"),field("x"),field("y"),field("pathFoto"),field("pathPercorso"), field("piano"))
				.from(table("ostacolo"))	
				.where(field("id").eq(id))
				.fetchOne();
		if (record != null) {
			TipoOstacolo tipo = TipoOstacolo.valueOf(record.get("tipoStanza", String.class));
			return new Ostacolo(
					record.get("id", Integer.class),
					tipo,
					record.get("descrizione", String.class),
					record.get("x", Double.class),
					record.get("y", Double.class),
					record.get("pathFoto", String.class),
					record.get("pathPercorso", String.class),
					record.get("piano", Integer.class)
					);
		}
		return null;}
}
