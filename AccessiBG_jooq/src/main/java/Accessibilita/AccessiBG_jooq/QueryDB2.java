package Accessibilita.AccessiBG_jooq;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DSL;

import contatti.db_sqlite.CreateDB;
import contatti.jooq.generated.tables.Indirizzi;
import contatti.jooq.generated.tables.records.IndirizziRecord;
public class QueryDB2 {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
		DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
		
		
		// prendi il recordo con nome giovanniu
		SelectConditionStep<EdificioRecord> rs = create.selectFrom(Indirizzi.INDIRIZZI).where(Indirizzi.INDIRIZZI.NOME.eq("giovanni"));
		// eseguoi
		Result<IndirizziRecord> result = rs.fetch();
		System.out.println(result);
		
		
	}
}
