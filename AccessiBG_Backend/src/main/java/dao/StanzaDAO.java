package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.*;

@Repository
public class StanzaDAO {
	
	private final DSLContext dsl;

	public StanzaDAO(DSLContext dsl) {
		this.dsl = dsl;
	}
	
	public void insert(Stanza s) {
		dsl.insertInto(table("stanza"), field("id"),field("nome"),field("posti"), field("descrizione"), field("accessibile"),
				field("x"), field("y"), field("tipoStanza"),field("pathFoto"), field("pathPercorso"),field("piano"),  field("edificio"))
		.values(s.getId(), s.getNome(), s.getPosti(), s.getDescrizione(), s.getAccessibile(), s.getX(), s.getY(), 
				s.getTipoStan(),s.getPathFoto(),s.getPathPercorso(),s.getPiano(), s.getEdificio())
		.onConflict(field("id"), field("id"))
		.doNothing()
		.execute();
	}

	public Stanza findByName(String nome) {
		var record = dsl.select(field("id"),field("nome"),field("posti"), field("descrizione"), field("accessibile"),
				field("x"), field("y"), field("tipoStanza"), field("pathFoto"), field("pathPercorso"),field("piano"),  field("edificio"))
				.from(table("stanza"))	
				.where(field("nome").eq(nome))
				.fetchOne();
		if (record != null) {
			TipoStanza tipo = TipoStanza.valueOf(record.get("tipoStanza", String.class));
			boolean accessibile = record.get("accessibile", Boolean.class);
			return new Stanza(
					record.get("id", Integer.class),
					record.get("nome", String.class),
					record.get("posti", Integer.class),
					record.get("descrizione", String.class),
					accessibile,
					record.get("x", Double.class),
					record.get("y", Double.class),
					tipo,
					record.get("pathFoto", String.class),
					record.get("pathPercorso", String.class),
					record.get("piano", Integer.class),
					record.get("edificio", String.class)
					);
		}
		return null;}
}
