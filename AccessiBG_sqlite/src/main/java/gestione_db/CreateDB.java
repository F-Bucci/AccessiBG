package gestione_db;

import org.springframework.stereotype.Service;

@Service
public class CreateDB {
	
	private final CreateTable createTable;
	private final InsertInDB insertInDB;
	
	public CreateDB(CreateTable createTable, InsertInDB insertInDB) {
		this.createTable = createTable;
		this.insertInDB = insertInDB;
	}
	
	public void crea() {
		createTable.createTable();
		
		insertInDB.insRecordSedi();
		insertInDB.insRecordEdifici();
		insertInDB.insRecordParcheggio();
	}

}