package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.*;

@Repository
public class StanzaDAO extends DAO<Stanza>{
	
	static final String STANZA = "stanza";
	static final String ID = "id";
	static final String NOME = "nome";
	static final String POSTI = "posti";
	static final String DESCRIZIONE = "descrizione";
	static final String ACCESSIBILE = "accessibile";
	static final String X = "x";
	static final String Y = "y";
	static final String TIPOSTANZA = "tipoStanza";
	static final String PATHFOTO = "pathFoto";
	static final String PATHPERCORSO = "pathPercorso";
	static final String PIANO = "piano";
	

	public StanzaDAO(DSLContext dsl) {
		super(dsl);
	}
	@Override
	public void insert(Stanza s) {
		dsl.insertInto(table(STANZA), field(ID),field(NOME),field(POSTI), field(DESCRIZIONE), field(ACCESSIBILE),
				field(X), field(Y), field(TIPOSTANZA),field(PATHFOTO), field(PATHPERCORSO),field(PIANO))
		.values(s.getId(), s.getNome(), s.getPosti(), s.getDescrizione(), s.getAccessibile() ? 1 : 0, s.getX(), s.getY(), 
				s.getTipoStan().name(),s.getPathFoto(),s.getPathPercorso(),s.getPiano())
		.onConflict(field(ID), field(PIANO))
		.doNothing()
		.execute();
	}

	public Stanza findByName(String nome) {
		var istanza = dsl.select(field(ID),field(NOME),field(POSTI), field(DESCRIZIONE), field(ACCESSIBILE),
				field(X), field(Y), field(TIPOSTANZA), field(PATHFOTO), field(PATHPERCORSO),field(PIANO))
				.from(table(STANZA))	
				.where(field(NOME).eq(nome))
				.fetchOne();
		if (istanza != null) {
			TipoStanza tipo = TipoStanza.valueOf(istanza.get(TIPOSTANZA, String.class));
			boolean accessibile = istanza.get(ACCESSIBILE, Boolean.class);
			return new Stanza(
					istanza.get(ID, Integer.class),
					istanza.get(NOME, String.class),
					istanza.get(POSTI, Integer.class),
					istanza.get(DESCRIZIONE, String.class),
					accessibile,
					istanza.get(X, Double.class),
					istanza.get(Y, Double.class),
					tipo,
					istanza.get(PATHFOTO, String.class),
					istanza.get(PATHPERCORSO, String.class),
					istanza.get(PIANO, Integer.class)
					);
		}
		return null;}
}
