package Accessibilita.AccessiBG_sqlite;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

/*
public class CreateDB {
	private static final String DB_URL= "jdbc:sqlite:" + Paths.get(System.getProperty("user.dir"), "data", "AccessiBG.db3");
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(DB_URL);
		}catch (SQLException e) {
	       e.printStackTrace();
        return null;
		} 
	}
	
	public static void crea(Connection conn) throws SQLException {
       CreateTable.creaTabelle(conn);
       InsertInDB.insRecordSedi(conn);
	}
}
*/
@Service
public class CreateDB {
	
	private final SedeDAO sedeDAO;
	private final InsertInDB insertInDB;
	
	public CreateDB(SedeDAO sedeDAO, InsertInDB insertInDB) {
		this.sedeDAO = sedeDAO;
		this.insertInDB = insertInDB;
	}
	
public void crea() {
		
	sedeDAO.createTableIfNotExists();
	
	if(sedeDAO.findAll().isEmpty()) {insertInDB.insRecordSedi();}
	}
}