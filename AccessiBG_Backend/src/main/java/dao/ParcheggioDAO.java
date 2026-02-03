package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.Parcheggio;
import struttura.TipoParcheggio;

@Repository
public class ParcheggioDAO extends DAO<Parcheggio> {
	
	static final String PARCHEGGIO = "parcheggio";
	static final String NOME = "nome";
	static final String TIPO = "tipo";
	static final String POSTIDISABILI = "postiDisabili";
	static final String INDIRIZZO = "indirizzo";
	static final String PATHFOTO = "pathFoto";
	static final String FACOLTA = "facolta";
	
	
	public ParcheggioDAO(DSLContext dsl) {
		super(dsl);
	}
	
	@Override
	public void insert(Parcheggio p) {
		dsl
			.insertInto(
					table(PARCHEGGIO),
					field(NOME),
					field(TIPO),
					field(POSTIDISABILI),
					field(INDIRIZZO),
					field(PATHFOTO),
					field(FACOLTA)
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
					field(NOME),
					field(FACOLTA)
			)
			.doNothing()
			.execute();
	}
	
	// restituisce p in base a nome e facolta, forse non utile, implementato già con sede
	public Parcheggio findParcheggioByFacolta(String nome, String facolta) {
		var istanza = dsl
				.select(
						field(NOME),
						field(TIPO),
						field(POSTIDISABILI),
						field(INDIRIZZO),
						field(PATHFOTO),
						field(FACOLTA)
				)
				.from(table(PARCHEGGIO))
				.where(field(NOME).eq(nome))
				.and(field(FACOLTA).eq(facolta))
				.fetchOne();
		
		if (istanza != null) {
			TipoParcheggio tipo = TipoParcheggio.valueOf(istanza.get(TIPO, String.class));
			// Nota: SQLite salva i boolean come 0/1. 
			// Se riscontri errori di cast, usa: record.get(POSTIDISABILI, Integer.class) == 1
			boolean postiDisabili = istanza.get(POSTIDISABILI, Boolean.class);
			return new Parcheggio(
					istanza.get(NOME, String.class),
					tipo,
					postiDisabili,
					istanza.get(INDIRIZZO, String.class),
					istanza.get(PATHFOTO, String.class),
					istanza.get(FACOLTA, String.class));
		}
		
		return null;
	}
}