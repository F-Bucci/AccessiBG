package Accessibilita.AccessiBG_sqlite;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import java.sql.Connection;
import java.sql.SQLException;

public class JooqUtils {

	    public static DSLContext getDSL(Connection conn) {
	        return DSL.using(conn, SQLDialect.SQLITE);
	    }
}
