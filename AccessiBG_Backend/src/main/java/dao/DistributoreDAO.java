package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.Distributore;
import struttura.TipoDistributore;

@Repository
public class DistributoreDAO {
	private final DSLContext dsl;

	public DistributoreDAO(DSLContext dsl) {
		this.dsl = dsl;
	}

	public void insert(Distributore d) {
		dsl.insertInto(table("distributore"), field("id"),field("tipo"),field("accessibile"),field("x"),
				field("y"),field("pathFoto"),field("pathPercorso"),field("numPiano"))
		.values(d.getId(), d.getTipo(), d.getAccessibile(), d.getX(), d.getY(), d.getPathFoto(),d.getPathPercorso(), d.getPiano())
		.onConflict(field("id"), field("numPiano"))
		.doNothing()
		.execute();
	}

//	restituisce d in base a id e piano, forse non utile, implementato già con sede
	public Distributore findDistributoreByPiano(int id, int piano) {
		var record = dsl
				.select(field("id"),field("tipo"),field("accessibile"),field("x"),
						field("y"),field("pathFoto"),field("pathPercorso"),field("numPiano"))
				.from(table("distributore"))
				.where(field("id").eq(id))
				.and(field("piano").eq(piano))
				.fetchOne();
		if (record != null) {
			TipoDistributore tipo = TipoDistributore.valueOf(record.get("tipo", String.class));
			boolean accessibile = record.get("accessibile", Boolean.class);
			return new Distributore(
					record.get("id", Integer.class),
					tipo,
					accessibile,
					record.get("x", Double.class),
					record.get("y", Double.class),					
					record.get("pathFoto", String.class),
					record.get("pathPercorso", String.class),
					record.get("numPiano", Integer.class));
		}
		return null;}
	
	public Distributore findById(int id) {
			var record = dsl
					.select(field("id"),field("tipo"),field("accessibile"),field("x"),
							field("y"),field("pathFoto"),field("pathPercorso"),field("numPiano"))
					.from(table("distributore"))
					.where(field("id").eq(id))
					.fetchOne();
			if (record != null) {
				TipoDistributore tipo = TipoDistributore.valueOf(record.get("tipo", String.class));
				boolean accessibile = record.get("accessibile", Boolean.class);
				return new Distributore(
						record.get("id", Integer.class),
						tipo,
						accessibile,
						record.get("x", Double.class),
						record.get("y", Double.class),					
						record.get("pathFoto", String.class),
						record.get("pathPercorso", String.class),
						record.get("numPiano", Integer.class));
			}
			return null;
	}
}