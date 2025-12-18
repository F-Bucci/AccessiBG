package Accessibilita.AccessiBG_jooq;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import accessibilita.genjooq.tables.Edificio;
import accessibilita.genjooq.tables.records.EdificioRecord;
import contatti.db_sqlite.CreateDB;
import contatti.jooq.generated.tables.Indirizzi;
import contatti.jooq.generated.tables.records.IndirizziRecord;
public class QueryDB {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
		DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
		Result<EdificioRecord> indirizzi = create.selectFrom(Edificio.INDIRIZZO).fetch();
		System.out.println(indirizzi);
	    }
}
