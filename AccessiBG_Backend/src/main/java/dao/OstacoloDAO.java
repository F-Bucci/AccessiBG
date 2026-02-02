package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.*;

@Repository
public class OstacoloDAO extends DAO<Ostacolo> {

	public OstacoloDAO(DSLContext dsl) {
		super(dsl);
	}
	@Override
	public void insert(Ostacolo o) {
		dsl.insertInto(table("ostacolo"), field("id"),field("nome"),field("tipo"),field("descrizione"),field("x"),field("y"),field("pathFoto"),field("pathPercorso"), field("piano"))
		.values(o.getId(), o.getNome(),o.getTipo(), o.getDescrizione(),o.getX(), o.getY(), o.getPathFoto(), o.getPathPercorso(), o.getPiano())
		.onConflict(field("id"), field("piano"))
		.doNothing()
		.execute();
	}

	public Ostacolo findById(int id) {
		var record = dsl.select(field("id"), field("nome"),field("tipo"),field("descrizione"),field("x"),field("y"),field("pathFoto"),field("pathPercorso"), field("piano"))
				.from(table("ostacolo"))	
				.where(field("id").eq(id))
				.fetchOne();
		if (record != null) {
			TipoOstacolo tipo = TipoOstacolo.valueOf(record.get("tipoStanza", String.class));
			return new Ostacolo(
					record.get("id", Integer.class),
					record.get("nome", String.class),
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
