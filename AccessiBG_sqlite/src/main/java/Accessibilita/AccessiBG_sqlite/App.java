package Accessibilita.AccessiBG_sqlite;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws IOException {
		
        // Create the database
            try {
				CreateDB.main(new String[]{});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        System.out.println("DB Created!");
        try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql1 = "CREATE TABLE Edificio (" + " NOME        TEXT," + " INDIRIZZO TEXT," + " SEDE  TEXT )";
				String sql2 = "INSERT INTO Edificio VALUES (" + " \"Edificio B\"," + " \"Via Einstein 5\", " + "\"Scuola di Ingegneria\" )";
				stmt.executeUpdate(sql1);
				stmt.executeUpdate(sql2);
				stmt.close();
				conn.close();
				System.out.println("Table created successfully");
				System.out.println("Edificio inserito con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finito");
		}
        
    }
}
