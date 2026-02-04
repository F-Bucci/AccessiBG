package gestione_db;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CreateTableTest {

    private Connection connection;
    private DSLContext dsl;
    private CreateTable createTable;

    @BeforeEach
    void setUp() throws SQLException {
    	// SQLite in-memory - nuova connessione per ogni test
    	connection = DriverManager.getConnection("jdbc:sqlite::memory:");
    	dsl = DSL.using(connection, SQLDialect.SQLITE);
    	createTable = new CreateTable(dsl);
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    @DisplayName("Crea tutte le 8 tabelle")
    void testCreateAllTables() throws SQLException {
        createTable.createTable();
        
        Set<String> tables = getTableNames();
        
        assertTrue(tables.contains("sede"));
        assertTrue(tables.contains("edificio"));
        assertTrue(tables.contains("parcheggio"));
        assertTrue(tables.contains("piano"));
        assertTrue(tables.contains("distributore"));
        assertTrue(tables.contains("puntiAccesso"));
        assertTrue(tables.contains("stanza"));
        assertTrue(tables.contains("ostacolo"));
        
        assertEquals(8, tables.size());
    }
    
    @Test
    @DisplayName("Verifica idempotenza con IF NOT EXISTS")
    void testIdempotency() {
        assertDoesNotThrow(() -> {
            createTable.createTable();
            createTable.createTable(); // Seconda chiamata
        });
        
        // Verifica che le tabelle esistano ancora
        assertDoesNotThrow(() -> getTableNames());
    }

    @Test
    @DisplayName("Verifica chiave primaria tabella sede")
    void testSedePrimaryKey() throws SQLException {
        createTable.createTable();
        
        // Inserisci e verifica unique constraint
        dsl.execute("INSERT INTO sede (facolta, indirizzo, pathFoto, orarioApertura, pathMaps) " +
                   "VALUES ('Test', 'Via 1', 'foto.jpg', '9-18', 'maps')");
        
        // Tentativo di duplicato dovrebbe fallire
        assertThrows(Exception.class, () -> {
            dsl.execute("INSERT INTO sede (facolta, indirizzo, pathFoto, orarioApertura, pathMaps) " +
                       "VALUES ('Test', 'Via 2', 'foto2.webp', '10-19', 'maps2')");
        });
    }

    private Set<String> getTableNames() {Set<String> tables = new HashSet<>();
        dsl.selectFrom("sqlite_master")
           .where("type = 'table'")
           .fetch()
           .forEach(r -> tables.add(r.get("name", String.class)));
        return tables;
    }
}