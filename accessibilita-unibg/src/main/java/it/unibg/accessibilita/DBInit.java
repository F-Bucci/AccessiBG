package it.unibg.accessibilita;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Accessibilita.AccessiBG_sqlite.CreateDB;

@Component
public class DBInit implements CommandLineRunner{
	private final CreateDB createDB;
	
	public DBInit(CreateDB createDB) {
		this.createDB = createDB;
	}
	@Override
	public void run(String...args) throws Exception{
		try {
			createDB.crea();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
