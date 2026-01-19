package Accessibilita.AccessiBG_sqlite;
import org.jooq.DSLContext;

import static org.jooq.impl.DSL.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SedeDAO {
	
    public static void  insert(Sede s, Connection conn) throws SQLException {
    	 DSLContext create = JooqUtils.getDSL(conn);
	     create.insertInto(table("sede"), field("facolta"), field("indirizzo"), field("pathFoto"))
	     .values(s.getFacolta(), s.getIndirizzo(), s.getPathFoto())
	     .onConflict(field("facolta"))
    	 .doNothing()
	     .execute();
    }
       
    public Sede findByFacolta(String facolta, Connection conn) {
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
    
   public static List<Sede> findAll(Connection conn) {
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
   }  
}
