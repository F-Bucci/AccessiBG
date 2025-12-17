package Accessibilita.AccessiBG_sqlite;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class InsertInDB {
	public static void main(String args[]) throws IOException {

		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO Edificio VALUES (" + " \"Edificio B\"," + " \"Via Einstein 5\", " + "\"Scuola di Ingegneria\" )";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Edificio inserito con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
