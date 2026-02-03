package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.*;

@Repository
public class PianoDAO extends DAO<Piano> {
	
	static final String PIANO = "piano";
	static final String NUM = "num";
	static final String DESCRIZIONE = "descrizione";
	static final String PATHFOTO = "pathFoto";
	static final String EDIFICIO = "edificio";
	

	public PianoDAO(DSLContext dsl) {
		super(dsl);
	}

	@Override
	public void insert(Piano p) {
		dsl
			.insertInto(
					table(PIANO), 
					field(NUM),
					field(DESCRIZIONE),
					field(PATHFOTO),
					field(EDIFICIO)
			)
			.values(
					p.getNumero(), 
					p.getDescrizione(),
					p.getPathFoto(), 
					p.getEdificio()
			)
			.onConflict(
					field(NUM), 
					field(EDIFICIO)
			)
			.doNothing()
			.execute();
	}
		
	public Piano findPianoByEdificio(int num, String edificio) {
		var istanza = dsl
				.select(
						field(NUM),
						field(DESCRIZIONE),
						field(PATHFOTO),
						field(EDIFICIO)
				)
				.from(table(PIANO))
				.where(field(NUM).eq(num))
				.and(field(EDIFICIO).eq(edificio))
				.fetchOne();
		
		if (istanza != null) {
			return new Piano(
					istanza.get(NUM, Integer.class),
					istanza.get(DESCRIZIONE, String.class),
					istanza.get(PATHFOTO, String.class),
					istanza.get(EDIFICIO, String.class)
			);
		}
		return null;
	}
	
	public List<Distributore> findDistributoreByPiano(int piano) {
		return dsl	
				.selectFrom(table("distributore"))
				.where(field(PIANO).eq(piano))
				.fetchInto(Distributore.class);
	}
	
	public List<Stanza> findStanzaByPiano(int piano) {
		return dsl
				.selectFrom(table("stanza"))
				.where(field(PIANO).eq(piano))
				.fetchInto(Stanza.class);
	}
	
	public List<Ostacolo> findOstacoloByPiano(int piano) {
		return dsl
				.selectFrom(table("ostacolo"))
				.where(field(PIANO).eq(piano))
				.fetchInto(Ostacolo.class);
	}
}