package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.*;

@Repository
public class PianoDAO {
	private final DSLContext dsl;

	public PianoDAO(DSLContext dsl) {this.dsl = dsl;}

	public void insert(Piano p) {
		dsl.insertInto(table("piano"), field("num"),field("descrizione"),field("pathFoto"),field("edificio"))
		.values(p.getNumero(), p.getDescrizione(),p.getPathFoto(), p.getEdificio())
		.onConflict(field("num"), field("edificio"))
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
					record.get("descrizione", String.class),
					record.get("pathFoto", String.class),
					record.get("edificio", String.class)
					);}       
		return null;}
	
//	restituisce i distributori all'interno di un piano (di un certo edificio)
	public List<Distributore> findDistributoreByPiano(String piano, String edificio) {
	    return dsl
	        .selectFrom(table("distributore"))
	        .where(field("piano").eq(piano))
	        .and(field("edificio").eq(edificio))
	        .fetchInto(Distributore.class);}
	
//	restituisce tutte le stanze di un piano (di un certo edificio)
	public List<Stanza> findStanzaByPiano(String piano, String edificio) {
	    return dsl
	        .selectFrom(table("stanza"))
	        .where(field("piano").eq(piano))
	        .and(field("edificio").eq(edificio))
	        .fetchInto(Stanza.class);}
	
//	restituisce tutte le stanze di un piano (di un certo edificio)
	public List<Ostacolo> findOstacoloByPiano(String piano) {
	    return dsl
	        .selectFrom(table("ostacolo"))
	        .where(field("piano").eq(piano))
	        .fetchInto(Ostacolo.class);}
}