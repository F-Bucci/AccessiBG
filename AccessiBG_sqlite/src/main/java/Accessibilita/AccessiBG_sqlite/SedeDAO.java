package Accessibilita.AccessiBG_sqlite;
import org.jooq.DSLContext;
import static org.jooq.impl.DSL.*;
import java.sql.SQLException;
import java.util.List;

public class SedeDAO {
	
    public static void  insert(Sede s) {
       try {
    	   DSLContext create = JooqUtils.getDSL();
	       create.insertInto(table("sede"), field("facolta"), field("indirizzo"), field("pathFoto"))
	       .values(s.getFacolta(), s.getIndirizzo(), s.getPathFoto())
	       .onConflict(field("facolta"))
    	   .doNothing()
	       .execute();
	   } catch (SQLException e) {
	        	e.printStackTrace();
	   }
    }
       
       /*public static void insert(Sede s) {
    	   try {
    	        DSLContext create = JooqUtils.getDSL();
    	        create.insertInto(table("sede"),
    	                field("facolta"),
    	                field("indirizzo"),
    	                field("pathFoto")
    	                )
    	         	  .values(s.getFacolta(), s.getIndirizzo(), s.getPathFoto())
    	              .onConflict(field("facolta"))
    	              .doNothing()
    	              .execute();
    	   }catch (Exception  e) {
	        	e.printStackTrace();
    	   }    
    	}*/
      
    public Sede findByFacolta(String facolta) {
        try {
            DSLContext create = JooqUtils.getDSL();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
   public static List<Sede> findAll() {
       try {
            DSLContext create = JooqUtils.getDSL();
            return create
                .selectFrom(table("Sede"))
                .fetch(record ->
                    new Sede(
                        record.get("facolta", String.class),
                        record.get("indirizzo", String.class),
                        record.get("pathFoto", String.class)
                    )
                );
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return List.of();
   } 
}
