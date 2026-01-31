package dao;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import struttura.*;

@Repository
public class PuntiDiIngressoDAO {
	private final DSLContext dsl;

	public PuntiDiIngressoDAO(DSLContext dsl) {
		this.dsl = dsl;
	}
	
	public void insert(PuntoDiIngresso p) {
		dsl.insertInto(table("puntiAccesso"), field("id"),field("scale"),field("rampe"), field("portaTagliafuoco"),field("percorsoStrisceIpov"),field("edificio"))
		.values(p.getId(),p.getScale(), p.getRampe(), p.getPortaTagliafuoco(), p.getPercorsoStrisceIpov(), p.getEdificio())
		.onConflict(field("id"), field("edificio"))
		.doNothing()
		.execute();
	}
}
