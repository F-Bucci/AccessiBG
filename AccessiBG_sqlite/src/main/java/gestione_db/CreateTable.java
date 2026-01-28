package gestione_db;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class CreateTable {
	private final DSLContext dsl;
	
	public CreateTable(DSLContext dsl) {
		this.dsl = dsl;
	}
	
//	struttura del database
	public void createTable() {
		dsl.execute("CREATE TABLE IF NOT EXISTS sede (" +
			    "facolta TEXT PRIMARY KEY, " +
			    "indirizzo TEXT NOT NULL, " +
			    "pathFoto TEXT NOT NULL, " +
			    "orarioApertura TEXT NOT NULL, " +
			    "pathMaps TEXT NOT NULL" +
			    ")");

			dsl.execute("CREATE TABLE IF NOT EXISTS edificio("+
			    "nome TEXT NOT NULL,"+
			    "indirizzo TEXT NOT NULL,"+
			    "orario TEXT NOT NULL,"+
			    "pathFoto TEXT NOT NULL,"+
			    "facolta TEXT NOT NULL, " +
			    "PRIMARY KEY (nome, facolta), " +
			    "FOREIGN KEY (facolta) REFERENCES sede(facolta) ON DELETE CASCADE" +
			    ")");

			dsl.execute("CREATE TABLE IF NOT EXISTS parcheggio("+
			    "nome TEXT NOT NULL,"+
			    "tipo TEXT NOT NULL,"+
			    "postiDisabili INTEGER NOT NULL,"+
			    "indirizzo TEXT NOT NULL,"+
			    "pathFoto TEXT NOT NULL,"+
			    "facolta TEXT NOT NULL, " +
			    "PRIMARY KEY (nome, facolta), " +
			    "FOREIGN KEY (facolta) REFERENCES sede(facolta) ON DELETE CASCADE" +
			    ")");

			dsl.execute("CREATE TABLE IF NOT EXISTS piano("+
			    "num INTEGER NOT NULL,"+
			    "descrizione TEXT NOT NULL,"+
			    "nomeEdif TEXT NOT NULL,"+
			    "PRIMARY KEY (num, nomeEdif), " +
			    "FOREIGN KEY (nomeEdif) REFERENCES edificio(nome) ON DELETE CASCADE" +
			    ")");

			dsl.execute("CREATE TABLE IF NOT EXISTS distributore("+
			    "id INTEGER NOT NULL,"+
			    "tipo TEXT NOT NULL,"+
			    "posizione TEXT NOT NULL,"+
			    "accessibile INTEGER NOT NULL,"+
			    "numPiano INTEGER NOT NULL,"+
			    "nomeEdif TEXT NOT NULL,"+
			    "FOREIGN KEY (numPiano, nomeEdif) REFERENCES piano(num, nomeEdif) ON DELETE CASCADE" +
			    ")");

		/*
		dsl.execute("CREATE TABLE IF NOT EXISTS ostacolo("+
			    "id INTEGER PRIMARY KEY,"+"descrizione TEXT NOT NULL,"+ "pathFoto TEXT NOT NULL, " + 
				"piano INTEGER NOT NULL,"+"FOREIGN KEY (id, piano)"+"REFERENCES piano(num)"+"ON DELETE CASCADE)");
		
		dsl.execute("CREATE TABLE IF NOT EXISTS stanza("+
			    "nome TEXT PRIMARY KEY,"+"posti INTEGER NOT NULL,"+ "pathFoto TEXT NOT NULL, " + 
				"piano INTEGER NOT NULL,"+"FOREIGN KEY (NOME, piano)"+"REFERENCES piano(num)"+"ON DELETE CASCADE)");
		*/
		}
}
