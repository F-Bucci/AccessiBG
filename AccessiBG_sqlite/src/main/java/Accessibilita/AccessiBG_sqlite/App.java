package Accessibilita.AccessiBG_sqlite;

import java.sql.Connection;
import java.sql.SQLException;
public class App {
	
	public static void main(String[] args) throws SQLException{
		Connection conn=CreateDB.getConnection();
		CreateDB.crea(conn);
		for (Sede s: SedeDAO.findAll(conn)) {
			System.out.println(s.getFacolta());
		}
		conn.close();
    }
}
