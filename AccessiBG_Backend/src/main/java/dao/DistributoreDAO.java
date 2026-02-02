package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.Distributore;
import struttura.TipoDistributore;

@Repository
public class DistributoreDAO extends DAO<Distributore> {

	public DistributoreDAO(DSLContext dsl) {
		super(dsl);
	}
	@Override
	public void insert(Distributore d) {
		dsl.insertInto(table("distributore"), field("id"),field("tipo"),field("accessibile"),field("x"),
				field("y"),field("pathFoto"),field("pathPercorso"),field("piano"))
		.values(d.getId(), d.getTipo().name(), d.getAccessibile() ? 1 : 0, d.getX(), d.getY(), d.getPathFoto(),d.getPathPercorso(), d.getPiano())
		.onConflict(field("id"), field("piano"))
		.doNothing()
		.execute();
	}

//	restituisce d in base a id e piano, forse non utile, implementato già con sede
	public Distributore findDistributoreByPiano(int id, int piano) {
		var record = dsl
				.select(field("id"),field("tipo"),field("accessibile"),field("x"),
						field("y"),field("pathFoto"),field("pathPercorso"),field("piano"))
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
					record.get("piano", Integer.class));
		}
		return null;}
	
	public Distributore findById(int id) {
			var record = dsl
					.select(field("id"),field("tipo"),field("accessibile"),field("x"),
							field("y"),field("pathFoto"),field("pathPercorso"),field("piano"))
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
						record.get("piano", Integer.class));
			}
			return null;
	}
}