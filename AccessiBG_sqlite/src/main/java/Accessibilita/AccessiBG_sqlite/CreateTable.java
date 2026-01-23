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
		"facolta TEXT PRIMARY KEY, " + "indirizzo TEXT NOT NULL, " + "pathFoto TEXT NOT NULL, " + "orarioApertura TEXT NOT NULL, " + "pathMaps TEXT NOT NULL)");
		
		dsl.execute("CREATE TABLE IF NOT EXISTS edificio("+
				"nome TEXT NOT NULL,"+ "indirizzo TEXT NOT NULL,"+ "orario TEXT NOT NULL,"+ "pathFoto TEXT NOT NULL," +
				"facolta TEXT NOT NULL, " + "PRIMARY KEY (nome, facolta), " + "FOREIGN KEY (facolta)"+"REFERENCES sede(facolta)"+"ON DELETE CASCADE)");
		
		dsl.execute("CREATE TABLE IF NOT EXISTS piano("+
			    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+"numero INTEGER NOT NULL,"+
				"edificio_nome TEXT NOT NULL,"+"FOREIGN KEY (edificio_nome)"+"REFERENCES edificio(nome)"+"ON DELETE CASCADE)");
		}	
		
}
