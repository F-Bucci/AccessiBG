package gestione_db;

import org.springframework.stereotype.Service;

@Service
/*
 * Servizio per l'inizializzazione e il popolamento del Database.
 */
public class CreateDB {
    
    private final CreateTable createTable;
    private final InsertInDB insertInDB;
    /**
     * 
     * @param createTable Componente per la creazione delle tabelle
     * @param insertInDB  Componente per il popolamento dei record.
     */
    public CreateDB(CreateTable createTable, InsertInDB insertInDB) {
        this.createTable = createTable;
        this.insertInDB = insertInDB;
    }
    /**
     * Esegue la procedura completa di installazione del database.
     * Questo approccio "a cascata" previene errori di inserimento dovuti a chiavi esterne mancanti.
     */
    public void crea() {
        createTable.createTable();
        insertInDB.insRecordSedi();
        insertInDB.insRecordEdifici();
        insertInDB.insRecordParcheggio();
        insertInDB.insRecordPiano();
        insertInDB.insRecordPuntoIngresso();
        insertInDB.insRecordStanza();
        insertInDB.insRecordOstacolo();
        insertInDB.insRecordDistributore();
    }
}