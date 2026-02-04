package gestione_db;

import dao.*;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.*;
import struttura.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InsertInDBTest {

    private Connection connection;
    private DSLContext dsl;
    private InsertInDB insertInDB;
    
    // DAO
    private SedeDAO sedeDAO;
    private EdificioDAO edificioDAO;
    private ParcheggioDAO parcheggioDAO;
    private PianoDAO pianoDAO;
    private DistributoreDAO distributoreDAO;
    private PuntoDiIngressoDAO puntoDiIngressoDAO;
    private StanzaDAO stanzaDAO;
    private OstacoloDAO ostacoloDAO;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        dsl = DSL.using(connection, SQLDialect.SQLITE);
                
        // Crea schema
        new CreateTable(dsl).createTable();
        
        // Inizializza DAO
        sedeDAO = new SedeDAO(dsl);
        edificioDAO = new EdificioDAO(dsl);
        parcheggioDAO = new ParcheggioDAO(dsl);
        pianoDAO = new PianoDAO(dsl);
        distributoreDAO = new DistributoreDAO(dsl);
        puntoDiIngressoDAO = new PuntoDiIngressoDAO(dsl);
        stanzaDAO = new StanzaDAO(dsl);
        ostacoloDAO = new OstacoloDAO(dsl);
        
        insertInDB = new InsertInDB(
            sedeDAO, edificioDAO, parcheggioDAO, pianoDAO,
            distributoreDAO, puntoDiIngressoDAO, stanzaDAO, ostacoloDAO
        );
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    @DisplayName("Inserisce tutte le sedi")
    void testInsRecordSedi() {
        insertInDB.insRecordSedi();
        
        List<Sede> sedi = sedeDAO.findAll();
        assertEquals(6, sedi.size());
        
        Sede dalmine = sedeDAO.findByFacolta("Sede di Dalmine");
        assertNotNull(dalmine);
        assertEquals("Via A. Einstein 2", dalmine.getIndirizzo());
    }

    @Test
    @DisplayName("Inserisce tutti i dati in sequenza corretta")
    void testInserimentoCompleto() {
        assertDoesNotThrow(() -> {
            insertInDB.insRecordSedi();
            insertInDB.insRecordEdifici();
            insertInDB.insRecordParcheggio();
            insertInDB.insRecordPiano();
            insertInDB.insRecordPuntoIngresso();
            insertInDB.insRecordStanza();
            insertInDB.insRecordOstacolo();
            insertInDB.insRecordDistributore();
        });

        assertEquals(6, sedeDAO.findAll().size());
        assertEquals(5, sedeDAO.findEdificiBySede("Sede di Dalmine").size());
        assertEquals(5, sedeDAO.findParcheggioBySede("Sede di Dalmine").size());
        assertEquals(1, edificioDAO.findPianoByEdificio("Edificio D").size());
        assertEquals(5, edificioDAO.findIngressoByEdificio("Edificio D").size()+ 
        		edificioDAO.findIngressoByEdificio("Edificio B").size());
        assertEquals(5, pianoDAO.findStanzaByPiano(0).size());
        assertEquals(3, pianoDAO.findOstacoloByPiano(0).size());
        assertEquals(3, pianoDAO.findDistributoreByPiano(0).size());
    }

    @Test
    @DisplayName("Verifica idempotenza inserimento")
    void testIdempotenza() {
        insertInDB.insRecordSedi();
        insertInDB.insRecordSedi(); // Seconda chiamata
        
        assertEquals(6, sedeDAO.findAll().size());
    }
}