package Accessibilita.AccessiBG_sqlite;

import java.sql.SQLException;
public class App {
	
	public static void main(String[] args) throws SQLException{
		CreateDB.getConnection();
		CreateDB.crea();
		for (Sede s: SedeDAO.findAll()) {
			System.out.println(s.getFacolta());
		}
		
    }
}
