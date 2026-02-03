package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.*;

@Repository
public class PuntoDiIngressoDAO extends DAO<PuntoDiIngresso>{

	public PuntoDiIngressoDAO(DSLContext dsl) {
		super(dsl);
	}
	@Override
	public void insert(PuntoDiIngresso p) {
		dsl.insertInto(table("puntiAccesso"),field("id"),field("nome"),field("descrizione"),field("scale"),field("rampe"), field("portaTagliafuoco"),field("percorsoStrisceIpov"),
				field("x"),field("y"),field("pathFoto"),field("pathPercorso"),field("edificio"))
		.values(p.getId(),p.getNome(),p.getDescrizione(), p.getScale(), p.getRampe(), p.getPortaTagliafuoco(), p.getPercorsoStrisceIpov(),p.getX(), p.getY(), p.getPathFoto(), p.getPathPercorso(), p.getEdificio())
		.onConflict(field("id"), field("edificio"))
		.doNothing()
		.execute();
	}
}