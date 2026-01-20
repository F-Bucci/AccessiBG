package Accessibilita.AccessiBG_sqlite;

import org.springframework.stereotype.Service;

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