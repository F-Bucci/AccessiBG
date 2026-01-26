package Accessibilita.AccessiBG_sqlite;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import Accessibilita.AccessiBG_Backend.Piano;

@Repository
public class PianoDAO {
	private final DSLContext dsl;

	public PianoDAO(DSLContext dsl) {
		this.dsl = dsl;
	}

	public void insert(Piano p) {
		dsl.insertInto(table("piano"), field("num"),field("descrizione"))
		.values(p.getNumero(), p.getDescrizione())
		.onConflict(field("num"), field("descrizione"))
		.doNothing()
		.execute();
	}
		
//	restituisce piano in base a num e edificio, forse non utile, implementato già con edificio
	public Piano findPianoByEdificio(int num, String edificio) {
		var record = dsl
				.select(field("num"), field("descrizione"))
				.from(table("piano"))
				.where(field("num").eq(num))
				.and(field("edificio").eq(edificio))
				.fetchOne();
		if (record != null) {
			return new Piano(
					record.get("num", Integer.class),
					record.get("descrizione", String.class)
					);}
		return null;}
}