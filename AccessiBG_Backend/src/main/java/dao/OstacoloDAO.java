package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.*;

@Repository
public class OstacoloDAO extends DAO<Ostacolo> {
	
	static final String DESCRIZIONE = "descrizione";
	static final String OSTACOLO = "ostacolo";
	static final String ID = "id";
	static final String NOME = "nome";
	static final String TIPO = "tipo";
	static final String PATHFOTO = "pathFoto";
	static final String PATHPERCORSO = "pathPercorso";
	static final String PIANO = "piano";
	static final String X = "x";
	static final String Y = "y";
	

	public OstacoloDAO(DSLContext dsl) {
		super(dsl);
	}
	@Override
	public void insert(Ostacolo o) {
		dsl.insertInto(table(OSTACOLO), field(ID),field(NOME),field(TIPO),field(DESCRIZIONE),field(X),field(Y),field(PATHFOTO),field(PATHPERCORSO), field(PIANO))
		.values(o.getId(), o.getNome(),o.getTipo().name(), o.getDescrizione(),o.getX(), o.getY(), o.getPathFoto(), o.getPathPercorso(), o.getPiano())
		.onConflict(field(ID), field(PIANO))
		.doNothing()
		.execute();
	}

	public Ostacolo findById(int id, int piano) {
		var istanza = dsl.select(field(ID), field(NOME),field(TIPO),field(DESCRIZIONE),field(X),field(Y),field(PATHFOTO),field(PATHPERCORSO), field(PIANO))
				.from(table(OSTACOLO))	
				.where(field(ID).eq(id))
				.and(field(PIANO).eq(piano))
				.fetchOne();
		if (istanza != null) {
			TipoOstacolo tipo = TipoOstacolo.valueOf(istanza.get(TIPO, String.class));
			return new Ostacolo(
					istanza.get(ID, Integer.class),
					istanza.get(NOME, String.class),
					tipo,
					istanza.get(DESCRIZIONE, String.class),
					istanza.get(X, Double.class),
					istanza.get(Y, Double.class),
					istanza.get(PATHFOTO, String.class),
					istanza.get(PATHPERCORSO, String.class),
					istanza.get(PIANO, Integer.class)
					);
		}
		return null;}
}
