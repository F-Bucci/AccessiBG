package gestione_db;

import dao.*;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class CreateDBTest {

    private static Connection conn;
    private static DSLContext dsl;
    private CreateDB createDB;

    @BeforeAll
    static void init() throws SQLException {
        conn = DriverManager.getConnection(
            "jdbc:h2:mem:testdb;MODE=SQLite;DATABASE_TO_LOWER=TRUE", "sa", "");
        dsl = DSL.using(conn, SQLDialect.H2);
    }

    @AfterAll
    static void close() throws SQLException {
        conn.close();
    }

    @BeforeEach
    void setUp() {
        SedeDAO sedeDAO = new SedeDAO(dsl);
        EdificioDAO edificioDAO = new EdificioDAO(dsl);
        ParcheggioDAO parcheggioDAO = new ParcheggioDAO(dsl);
        PianoDAO pianoDAO = new PianoDAO(dsl);
        DistributoreDAO distributoreDAO = new DistributoreDAO(dsl);
        PuntoDiIngressoDAO puntoDiIngressoDAO = new PuntoDiIngressoDAO(dsl);
        StanzaDAO stanzaDAO = new StanzaDAO(dsl);
        OstacoloDAO ostacoloDAO = new OstacoloDAO(dsl);

        createDB = new CreateDB(
            new CreateTable(dsl),
            new InsertInDB(sedeDAO, edificioDAO, parcheggioDAO, pianoDAO,
                distributoreDAO, puntoDiIngressoDAO, stanzaDAO, ostacoloDAO)
        );
    }

    @AfterEach
    void tearDown() {
        dsl.execute("DROP TABLE IF EXISTS ostacolo, stanza, puntiAccesso, distributore, piano, parcheggio, edificio, sede");
    }

    @Test
    void testCreaDatabaseCompleto() {
        assertDoesNotThrow(() -> createDB.crea());
        
        // Verifica conteggi
        assertEquals(6, dsl.fetchCount(dsl.selectFrom("sede")));
        assertEquals(4, dsl.fetchCount(dsl.selectFrom("edificio")));
        assertEquals(4, dsl.fetchCount(dsl.selectFrom("parcheggio")));
        assertEquals(1, dsl.fetchCount(dsl.selectFrom("piano")));
        assertEquals(5, dsl.fetchCount(dsl.selectFrom("puntiAccesso")));
        assertEquals(5, dsl.fetchCount(dsl.selectFrom("stanza")));
        assertEquals(3, dsl.fetchCount(dsl.selectFrom("ostacolo")));
        assertEquals(3, dsl.fetchCount(dsl.selectFrom("distributore")));
    }

    @Test
    void testCreaIdempotente() {
        createDB.crea();
        createDB.crea();
        
        assertEquals(6, dsl.fetchCount(dsl.selectFrom("sede")));
        assertEquals(4, dsl.fetchCount(dsl.selectFrom("edificio")));
    }

    @Test
    void testDatiCorretti() {
        createDB.crea();
        
        // Verifica sede specifica
        var sede = dsl.selectFrom("sede").where("facolta = 'Sede di Dalmine'").fetchOne();
        assertNotNull(sede);
        assertEquals("Via A. Einstein 2", sede.get("indirizzo"));
        
        // Verifica relazione
        var edificio = dsl.selectFrom("edificio")
            .where("nome = 'Edificio D' and facolta = 'Sede di Dalmine'")
            .fetchOne();
        assertNotNull(edificio);
    }
}