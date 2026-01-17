package Accessibilita.AccessiBG_sqlite;

import java.sql.*;
public class CreateTable {
	
	public static void creaTabelle(Connection connect) {	
		try {
			Connection conn= connect;
			Statement stmt = conn.createStatement();
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
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
