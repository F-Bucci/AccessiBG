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
		dsl
			.insertInto(
					table("distributore"),
					field("id"),
					field("tipo"),
					field("posizione"),
					field("accessibile"),
					field("numPiano")
			)
			.values(
					d.getId(),
					d.getTipo(),
					d.getPosizione(),
					d.getAccessibile(),
					d.getPiano()
			)
			.onConflict(
					field("id"),
					field("numPiano")
			)
			.doNothing()
			.execute();
	}
	
	// restituisce d in base a id e piano, forse non utile, implementato già con sede
	public Distributore findDistributoreByPiano(int id, int piano) {
		var record = dsl
				.select(
						field("id"),
						field("tipo"),
						field("posizione"),
						field("accessibile"),
						field("numPiano")
				)
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
					record.get("posizione", String.class),
					accessibile,
					record.get("numPiano", Integer.class));
		}
		
		return null;
	}

	
}