package gestione_db;

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
            "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=SQLite;DATABASE_TO_LOWER=TRUE",
            "sa", "");
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
}