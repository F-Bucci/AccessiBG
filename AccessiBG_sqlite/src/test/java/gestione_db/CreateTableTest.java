/*package gestione_db;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CreateTableTest {

    private static Connection connection;
    private static DSLContext dsl;
    private CreateTable createTable;

    @BeforeAll
    static void init() throws SQLException {
        connection = DriverManager.getConnection(
        		"jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE","sa","");        
        dsl = DSL.using(connection, SQLDialect.H2);
    }

    @AfterAll
    static void close() throws SQLException {
        connection.close();
    }

    @BeforeEach
    void setUp() {
        createTable = new CreateTable(dsl);
    }

    @AfterEach
    void tearDown() {
        dsl.execute("DROP TABLE IF EXISTS ostacolo, stanza, puntiAccesso, distributore, piano, parcheggio, edificio, sede");
    }

    @Test
    void testCreateAllTables() throws SQLException {
        createTable.createTable();
        
        Set<String> tables = new HashSet<>();
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet rs = meta.getTables(null, null, "%", new String[]{"TABLE"});
        while (rs.next()) {
            tables.add(rs.getString("TABLE_NAME").toUpperCase());
        }
        
        assertTrue(tables.containsAll(Set.of(
            "SEDE", "EDIFICIO", "PARCHEGGIO", "PIANO", 
            "DISTRIBUTORE", "PUNTIACCESSO", "STANZA", "OSTACOLO"
        )));
    }

    @Test
    void testSedePrimaryKey() throws SQLException {
        createTable.createTable();
        
        Set<String> pk = new HashSet<>();
        ResultSet rs = connection.getMetaData().getPrimaryKeys(null, null, "SEDE");
        while (rs.next()) {
            pk.add(rs.getString("COLUMN_NAME").toUpperCase());
        }
        
        assertEquals(Set.of("FACOLTA"), pk);
    }

    @Test
    void testEdificioForeignKey() throws SQLException {
        createTable.createTable();
        
        boolean foundFk = false;
        ResultSet rs = connection.getMetaData().getImportedKeys(null, null, "EDIFICIO");
        while (rs.next()) {
            if ("FACOLTA".equals(rs.getString("FKCOLUMN_NAME").toUpperCase()) &&
                "SEDE".equals(rs.getString("PKTABLE_NAME").toUpperCase())) {
                foundFk = true;
                assertEquals(DatabaseMetaData.importedKeyCascade, rs.getInt("DELETE_RULE"));
            }
        }
        
        assertTrue(foundFk);
    }

    @Test
    void testIdempotency() {
        assertDoesNotThrow(() -> {
            createTable.createTable();
            createTable.createTable(); // Seconda chiamata
        });
    }
}*/

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
        
        // Abilita foreign keys in SQLite (disabilitate di default)
        dsl.execute("PRAGMA foreign_keys = ON");
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

    @Test
    @DisplayName("Verifica foreign key edificio -> sede")
    void testEdificioForeignKey() throws SQLException {
        createTable.createTable();
        
        // Prima inserisci sede
        dsl.execute("INSERT INTO sede (facolta, indirizzo, pathFoto, orarioApertura, pathMaps) " +
                   "VALUES ('Sede Test', 'Via X', 'foto.webp', '9-18', 'maps')");
        
        // Poi edificio (FK valida)
        assertDoesNotThrow(() -> {
            dsl.execute("INSERT INTO edificio (nome, indirizzo, orario, pathFoto, facolta) " +
                       "VALUES ('Ed A', 'Via Y', '9-18', 'foto.webp', 'Sede Test')");
        });
        
        // Edificio con FK invalida dovrebbe fallire
        assertThrows(Exception.class, () -> {
            dsl.execute("INSERT INTO edificio (nome, indirizzo, orario, pathFoto, facolta) " +
                       "VALUES ('Ed B', 'Via Z', '9-18', 'foto.webp', 'Senza sede')");
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