package Accessibilita.AccessiBG_sqlite;
import org.jooq.DSLContext;

import static org.jooq.impl.DSL.*;

import org.springframework.stereotype.Repository;

import Accessibilita.AccessiBG_Backend.Sede;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SedeDAO {
	
	private final DSLContext dsl;
	
	public SedeDAO(DSLContext dsl) {
		this.dsl = dsl;
	}

	public void insert(Sede s) {
		dsl.insertInto(table("sede"), field("facolta"), field("indirizzo"), field("pathFoto"))
        .values(s.getFacolta(), s.getIndirizzo(), s.getPathFoto())
        .onConflict(field("facolta"))
        .doNothing()
        .execute();
	}
	
	public Sede findByFacolta(String facolta) {
		var record = dsl.select(
                field("facolta"),
                field("indirizzo"),
                field("pathFoto")
            )
            .from(table("sede"))
            .where(field("facolta").eq(facolta))
            .fetchOne();

        if (record != null) {
           return new Sede(
               record.get("facolta", String.class),
               record.get("indirizzo", String.class),
               record.get("pathFoto", String.class)
               );
           }
       return null;
	}
	
	public List<Sede> findAll(){
		try {
			return dsl.selectFrom(table("sede"))
					.fetch(record ->
					new Sede(
			                 record.get("facolta", String.class),
			                 record.get("indirizzo", String.class),
			                 record.get("pathFoto", String.class)
			               )
			          );
		}catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}
