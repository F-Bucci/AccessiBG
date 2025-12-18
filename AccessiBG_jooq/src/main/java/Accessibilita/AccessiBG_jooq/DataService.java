package Accessibilita.AccessiBG_jooq;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import accessibilita.genjooq.tables.records.EdificioRecord;
import contatti.db_sqlite.CreateDB;
import contatti.jooq.generated.tables.Indirizzi;
import contatti.jooq.generated.tables.records.IndirizziRecord;

//classe utile per avere tutti gli indirizzi salvati
public class DataService {

	// questo punta al file che contiene il database
	// nota che usiamo il riferimento relativo in questo modo funziona in ogni computer
	private static String DB_REL_FILE = "C:\\Data\\AccessiBG\\AccessiBG_sqlite\\src\\main\\resources\\sqlite_db\\AccessiBG.db3";
	
	private static String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;

	public static List<IndirizziRecord> getIndirizziRecord() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(DB_URL);			
			DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
			return create.selectFrom(Edificio.SEDE).fetchInto(EdificioRecord.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	public static void main(String[] args) {
		System.out.println(getIndirizziRecord());
	}
}
