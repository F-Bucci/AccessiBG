package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.Edificio;
import struttura.Parcheggio;
import struttura.TipoParcheggio;

@Repository
public class ParcheggioDAO extends DAO<Parcheggio> {
	
	public ParcheggioDAO(DSLContext dsl) {
		super(dsl);
	}
	
    @Override
	public void insert(Parcheggio p) {
		dsl
			.insertInto(
					table("parcheggio"),
					field("nome"),
					field("tipo"),
					field("postiDisabili"),
					field("indirizzo"),
					field("pathFoto"),
					field("facolta")
			)
			.values(
					p.getNome(),
					p.getTipo().name(),
					p.getPostiDisabili() ? 1:0,
					p.getIndirizzo(),
					p.getPathFoto(),
					p.getFacolta()
			)
			.onConflict(
					field("nome"),
					field("facolta")
			)
			.doNothing()
			.execute();
	}
	
	// restituisce p in base a nome e facolta, forse non utile, implementato già con sede
	public Parcheggio findParcheggioByFacolta(String nome, String facolta) {
		var record = dsl
				.select(
						field("nome"),
						field("tipo"),
						field("postiDisabili"),
						field("indirizzo"),
						field("pathFoto"),
						field("facolta")
				)
				.from(table("parcheggio"))
				.where(field("nome").eq(nome))
				.and(field("facolta").eq(facolta))
				.fetchOne();
		
		if (record != null) {
			TipoParcheggio tipo = TipoParcheggio.valueOf(record.get("tipo", String.class));
			boolean postiDisabili = record.get("postiDisabili", Boolean.class);
			return new Parcheggio(
					record.get("nome", String.class),
					tipo,
					postiDisabili,
					record.get("indirizzo", String.class),
					record.get("pathFoto", String.class),
					record.get("facolta", String.class));
		}
		
		return null;
	}
}