package Accessibilita.AccessiBG_sqlite;

import java.sql.*;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class CreateTable {
	private final DSLContext dsl;
	
	public CreateTable(DSLContext dsl) {
		this.dsl = dsl;
	}
	
	public void createTable() {
		dsl.execute("CREATE TABLE IF NOT EXISTS sede (" +
		"facolta TEXT PRIMARY KEY, " + "indirizzo TEXT, " + "pathFoto TEXT" + ")");
		
		dsl.execute("CREATE TABLE IF NOT EXISTS edificio("+
				"nome TEXT PRIMARY KEY,"+ 
				"facolta TEXT NOT NULL,"+"FOREIGN KEY (facolta)"+"REFERENCES sede(facolta)"+"ON DELETE CASCADE)");
		
		dsl.execute("CREATE TABLE IF NOT EXISTS piano("+
			    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+"numero INTEGER NOT NULL,"+
				"edificio_nome TEXT NOT NULL,"+"FOREIGN KEY (edificio_nome)"+"REFERENCES edificio(nome)"+"ON DELETE CASCADE)");
		}	
		
		/*try {
			Statement stmt = connect.createStatement();
			stmt.execute("PRAGMA foreign_keys = ON");
			stmt.execute("""
		            CREATE TABLE IF NOT EXISTS sede (
					facolta TEXT PRIMARY KEY,
					indirizzo TEXT NOT NULL,
					pathFoto TEXT NOT NULL
					)
		        """);
			stmt.execute("""
				    CREATE TABLE IF NOT EXISTS edificio (
					nome TEXT PRIMARY KEY,
				    facolta TEXT NOT NULL,
				    FOREIGN KEY (facolta)
				    REFERENCES sede(facolta)
				    ON DELETE CASCADE
				    )
				""");
			stmt.execute("""
				    CREATE TABLE IF NOT EXISTS piano (
				    id INTEGER PRIMARY KEY AUTOINCREMENT,
				    numero INTEGER NOT NULL,
				    edificio_nome TEXT NOT NULL,
					   FOREIGN KEY (edificio_nome)
				       REFERENCES edificio(nome)
					   ON DELETE CASCADE
					 )
				""");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
}
