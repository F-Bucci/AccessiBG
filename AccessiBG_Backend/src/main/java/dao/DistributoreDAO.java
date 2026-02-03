package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.Distributore;
import struttura.TipoDistributore;

@Repository
public class DistributoreDAO extends DAO<Distributore> {
	
	static final String DISTRIBUTORE = "distributore";
	static final String ID = "id";
	static final String NOME = "nome";
	static final String TIPO = "tipo";
	static final String ACCESSIBILE = "accessibile";
	static final String X = "x";
	static final String Y = "y";
	static final String PATHFOTO = "pathFoto";
	static final String PATHPERCORSO = "pathPercorso";
	static final String PIANO = "piano";
	

	public DistributoreDAO(DSLContext dsl) {
		super(dsl);
	}

	@Override
	public void insert(Distributore d) {
		dsl.insertInto(table(DISTRIBUTORE), field(ID), field(NOME), field(TIPO), field(ACCESSIBILE), field(X),
				field(Y), field(PATHFOTO), field(PATHPERCORSO), field(PIANO))
		.values(d.getId(), d.getNome(), d.getTipo().name(), d.getAccessibile() ? 1 : 0, d.getX(), d.getY(), d.getPathFoto(), d.getPathPercorso(), d.getPiano())
		.onConflict(field(ID), field(PIANO))
		.doNothing()
		.execute();
	}
	
	public Distributore findDistributoreByPiano(int id, int piano) {
		var istanza = dsl
				.select(field(ID), field(NOME), field(TIPO), field(ACCESSIBILE), field(X),
						field(Y), field(PATHFOTO), field(PATHPERCORSO), field(PIANO))
				.from(table(DISTRIBUTORE))
				.where(field(ID).eq(id))
				.and(field(PIANO).eq(piano))
				.fetchOne();
		
		if (istanza != null) {
			TipoDistributore tipo = TipoDistributore.valueOf(istanza.get(TIPO, String.class));
			boolean accessibile = istanza.get(ACCESSIBILE, Integer.class) == 1; // SQLite usa 0/1 per i boolean
			return new Distributore(
					istanza.get(ID, Integer.class),
					istanza.get(NOME, String.class),
					tipo,
					accessibile,
					istanza.get(X, Double.class),
					istanza.get(Y, Double.class),					
					istanza.get(PATHFOTO, String.class),
					istanza.get(PATHPERCORSO, String.class),
					istanza.get(PIANO, Integer.class));
		}
		return null;
	}
	
	public Distributore findById(int id) {
			var istanza = dsl
					.select(field(ID), field(NOME), field(TIPO), field(ACCESSIBILE), field(X),
							field(Y), field(PATHFOTO), field(PATHPERCORSO), field(PIANO))
					.from(table(DISTRIBUTORE))
					.where(field(ID).eq(id))
					.fetchOne();
			if (istanza != null) {
				TipoDistributore tipo = TipoDistributore.valueOf(istanza.get(TIPO, String.class));
				boolean accessibile = istanza.get(ACCESSIBILE, Integer.class) == 1;
				return new Distributore(
						istanza.get(ID, Integer.class),
						istanza.get(NOME, String.class),
						tipo,
						accessibile,
						istanza.get(X, Double.class),
						istanza.get(Y, Double.class),					
						istanza.get(PATHFOTO, String.class),
						istanza.get(PATHPERCORSO, String.class),
						istanza.get(PIANO, Integer.class));
			}
			return null;
	}
}