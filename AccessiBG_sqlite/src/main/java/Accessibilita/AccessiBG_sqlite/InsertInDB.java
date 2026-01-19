package Accessibilita.AccessiBG_sqlite;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertInDB {
	
	public static void insRecordSedi(Connection conn) throws SQLException {
	Sede ing=new Sede("Ingegneria", "via A. Einstein 2", "src/img/sedeDalmine.webp");
	SedeDAO.insert(ing, conn);
	Sede uma=new Sede ("Umanistico", "piazzale Sant'Agostino, 2","src/img/sedeCittaAlta.webp");
	SedeDAO.insert(uma, conn);
	Sede eco=new Sede ("Economico-giuridico", "via dei Caniana, 2","src/img/sedeCaniana.webp");
	SedeDAO.insert(eco, conn);
	}
}
