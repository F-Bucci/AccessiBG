package Accessibilita.AccessiBG_sqlite;
import java.sql.Connection;

public class InsertInDB {
	
	public static void insRecordSedi(Connection conn) {
	Sede ing=new Sede("Ingegneria", "via A. Einstein 2", "src/img/sedeDalmine.webp");
	SedeDAO.insert(ing);
	Sede uma=new Sede ("Umanistico", "piazzale Sant'Agostino, 2","src/img/sedeCittaAlta.webp");
	SedeDAO.insert(uma);
	Sede eco=new Sede ("Economico-giuridico", "via dei Caniana, 2","src/img/sedeCaniana.webp");
	SedeDAO.insert(eco);
	}
}
