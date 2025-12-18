package Accessibilita.AccessiBG_jooq;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import Accessibilita.AccessiBG_sqlite.CreateDB;
import contatti.jooq.generated.tables.Indirizzi;
import contatti.jooq.generated.tables.records.IndirizziRecord;

public class InsertInDB {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(Accessibilita.AccessiBG_sqlite.CreateDB.DB_URL);
		DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

		IndirizziRecord giovanni = new IndirizziRecord("giobbvanni", "0355667700");

		int result = create.insertInto(Indirizzi.INDIRIZZI).set(giovanni).execute();

		System.out.println(result);
	}
}
