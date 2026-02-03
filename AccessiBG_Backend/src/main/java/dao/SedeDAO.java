package dao;

import org.springframework.stereotype.Repository;
import org.jooq.DSLContext;
import static org.jooq.impl.DSL.*;

import struttura.Edificio;
import struttura.Parcheggio;
import struttura.Sede;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SedeDAO extends DAO<Sede> {
	
	static final String SEDE = "sede";
	static final String FACOLTA = "facolta";
	static final String INDIRIZZO = "indirizzo";
	static final String PATHFOTO = "pathFoto";
	static final String ORARIOAPERTURA = "orarioApertura";
	static final String PATHMAPS = "pathMaps";
	

	public SedeDAO(DSLContext dsl) {
		super(dsl);
	}

	@Override
	public void insert(Sede s) {
		dsl.insertInto(
				table(SEDE),
				field(FACOLTA),
				field(INDIRIZZO),
				field(PATHFOTO),
				field(ORARIOAPERTURA),
				field(PATHMAPS)
		)
		.values(
				s.getFacolta(),
				s.getIndirizzo(),
				s.getPathFoto(),
				s.getOrarioApertura(),
				s.getPathMaps()
		)
		.onConflict(field(FACOLTA))
		.doNothing()
		.execute();
	}

	public Sede findByFacolta(String facolta) {
		var istanza = dsl
				.select(
						field(FACOLTA),
						field(INDIRIZZO),
						field(PATHFOTO),
						field(ORARIOAPERTURA),
						field(PATHMAPS)
				)
				.from(table(SEDE))
				.where(field(FACOLTA).eq(facolta))
				.fetchOne();

		if (istanza != null) {
			return new Sede(
					istanza.get(FACOLTA, String.class),
					istanza.get(INDIRIZZO, String.class),
					istanza.get(PATHFOTO, String.class),
					istanza.get(ORARIOAPERTURA, String.class),
					istanza.get(PATHMAPS, String.class)
			);
		}

		return null;
	}

	public List<Sede> findAll() {
		try {
			return dsl
					.selectFrom(table(SEDE))
					.fetch(istanza -> new Sede(
							istanza.get(FACOLTA, String.class),
							istanza.get(INDIRIZZO, String.class),
							istanza.get(PATHFOTO, String.class),
							istanza.get(ORARIOAPERTURA, String.class),
							istanza.get(PATHMAPS, String.class)
					));
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public List<Edificio> findEdificiBySede(String facolta) {
		return dsl
				.selectFrom(table("edificio"))
				.where(field(FACOLTA).eq(facolta))
				.fetchInto(Edificio.class);
		}
	public List<Parcheggio> findParcheggioBySede(String facolta) {
	    return dsl.selectFrom(table("parcheggio"))
	              .where(field(FACOLTA).eq(facolta))
	              .fetchInto(Parcheggio.class);
		}
	}