package Accessibilita.AccessiBG_sqlite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
	
	public static Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection("jdbc:sqlite:src/main/resources/AccessiBG.db3");
		}catch (SQLException e) {
	       e.printStackTrace();
        return null;
		} 
	}
	
	public static void crea() throws SQLException {
		CreateTable.creaTabelle(CreateDB.getConnection());
		InsertInDB.insRecordSedi(CreateDB.getConnection());
	}
}