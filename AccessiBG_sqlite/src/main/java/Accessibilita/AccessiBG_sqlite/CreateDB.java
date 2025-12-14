package Accessibilita.AccessiBG_sqlite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
public class CreateDB {
	// questo � il percordo relativo del file che contiene il DB
		public static String DB_REL_FILE = "db/indirizzi.db3";
		public static String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;

		public static void main(String[] args) throws IOException, SQLException {
			Connection conn = DriverManager.getConnection(DB_URL);
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("The driver name is " + meta.getDriverName());
			System.out.println("A new database has been created.");
			// controllo che il file esista a questo punto
			System.out.println("il file esiste? " + new File(DB_REL_FILE).exists());
}

}
