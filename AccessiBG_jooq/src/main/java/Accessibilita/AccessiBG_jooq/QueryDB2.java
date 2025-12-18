package Accessibilita.AccessiBG_jooq;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DSL;

import Accessibilita.AccessiBG_sqlite.CreateDB;
import accessibilita.genjooq.tables.Edificio;
import accessibilita.genjooq.tables.records.EdificioRecord;
public class QueryDB2 {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
		DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
		
		
		// prendi il recordo con nome giovanniu
		SelectConditionStep<EdificioRecord> rs = create.selectFrom(Indirizzi.INDIRIZZI).where(Edificio.EDIFICIO.NOME.eq("giovanni"));
		// eseguoi
		Result<EdificioRecord> result = rs.fetch();
		System.out.println(result);
		
		
	}
}
*/