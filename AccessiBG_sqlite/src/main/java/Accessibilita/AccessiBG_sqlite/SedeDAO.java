package Accessibilita.AccessiBG_sqlite;
import org.jooq.DSLContext;

import static org.jooq.impl.DSL.*;

import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SedeDAO {
	
	private final DSLContext dsl;
	
	public SedeDAO(DSLContext dsl) {
		this.dsl = dsl;
	}
	
	/*
    public static void  insert(Sede s, Connection conn) throws SQLException {
    	 DSLContext create = JooqUtils.getDSL(conn);
	     create.insertInto(table("sede"), field("facolta"), field("indirizzo"), field("pathFoto"))
	     .values(s.getFacolta(), s.getIndirizzo(), s.getPathFoto())
	     .onConflict(field("facolta"))
    	 .doNothing()
	     .execute();
    }
    */
	public void createTableIfNotExists() {
		dsl.execute("CREATE TABLE IF NOT EXISTS sede (" + 
                "facolta TEXT PRIMARY KEY, " +
                "indirizzo TEXT, " +
                "pathFoto TEXT" +
                ")");
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
	/* public Sede findByFacolta(String facolta, Connection conn) {
         DSLContext create = JooqUtils.getDSL(conn);
         var record = create
             .select(
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
    
   public List<Sede> findAll(Connection conn) {
    try{ 
      DSLContext create = JooqUtils.getDSL(conn);
      return create
          .selectFrom(table("sede"))
          .fetch(record ->
               new Sede(
                 record.get("facolta", String.class),
                 record.get("indirizzo", String.class),
                 record.get("pathFoto", String.class)
               )
          );
     } catch (Exception e) { e.printStackTrace(); }
     return List.of();
   } */
}
