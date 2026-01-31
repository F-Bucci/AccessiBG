package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.Distributore;
import struttura.Piano;

@Repository
public class PianoDAO extends DAO<Piano> {
	
	public PianoDAO(DSLContext dsl) {
		super(dsl);
	}
	
	@Override
	public void insert(Piano p) {
		dsl
			.insertInto(
					table("piano"),
					field("num"),
					field("descrizione"),
					field("edificio")
			)
			.values(
					p.getNumero(),
					p.getDescrizione(),
					p.getEdificio()
			)
			.onConflict(
					field("num"),
					field("edificio")
			)
			.doNothing()
			.execute();
	}
		
    // restituisce piano in base a num e edificio, forse non utile, implementato già con edificio
	public Piano findPianoByEdificio(int num, String edificio) {
		var record = dsl
				.select(
						field("num"),
						field("descrizione")
				)
				.from(table("piano"))
				.where(field("num").eq(num))
				.and(field("edificio").eq(edificio))
				.fetchOne();
		
		if (record != null) {
			return new Piano(
					record.get("num", Integer.class),
					record.get("descrizione", String.class),
					record.get("edificio", String.class)
			);
		}
		
		return null;
	}
	
	public List<Distributore> findDistributoreByPiano(String piano) {
	    return dsl
	    		.selectFrom(table("distributore"))
	    		.where(field("piano").eq(piano))
	    		.fetchInto(Distributore.class);
	}
}