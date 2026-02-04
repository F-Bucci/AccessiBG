package gestione_db;
import dao.SedeDAO;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.*;
import struttura.*;
import dao.*;
import struttura.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InsertInDBTest {

    private static Connection connection;
    private static DSLContext dsl;
    
    private SedeDAO sedeDAO;
    private EdificioDAO edificioDAO;
    private ParcheggioDAO parcheggioDAO;
    private PianoDAO pianoDAO;
    private DistributoreDAO distributoreDAO;
    private PuntoDiIngressoDAO puntoDiIngressoDAO;
    private StanzaDAO stanzaDAO;
    private OstacoloDAO ostacoloDAO;
    
    private InsertInDB insertInDB;

    @BeforeAll
    static void initDatabase() throws SQLException {
        // Connessione H2 in-memory con modalità SQLite
        connection = DriverManager.getConnection(
            "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=SQLite;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE",
            "sa",
            ""
        );
        dsl = DSL.using(connection, SQLDialect.H2);
    }

    @AfterAll
    static void closeDatabase() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @BeforeEach
    void setUp() {
        // Crea schema
        new CreateTable(dsl).createTable();
        
        // Inizializza DAO manualmente (assumendo implementazioni che usano DSLContext)
        this.sedeDAO = new SedeDAO(dsl);
        this.edificioDAO = new EdificioDAO(dsl);
        this.parcheggioDAO = new ParcheggioDAO(dsl);
        this.pianoDAO = new PianoDAO(dsl);
        this.distributoreDAO = new DistributoreDAO(dsl);
        this.puntoDiIngressoDAO = new PuntoDiIngressoDAO(dsl);
        this.stanzaDAO = new StanzaDAO(dsl);
        this.ostacoloDAO = new OstacoloDAO(dsl);
        
        insertInDB = new InsertInDB(
            sedeDAO, edificioDAO, parcheggioDAO, pianoDAO,
            distributoreDAO, puntoDiIngressoDAO, stanzaDAO, ostacoloDAO
        );
    }

    @AfterEach
    void tearDown() {
        // Pulizia tabelle in ordine inverso
        dsl.execute("DROP TABLE IF EXISTS ostacolo");
        dsl.execute("DROP TABLE IF EXISTS stanza");
        dsl.execute("DROP TABLE IF EXISTS puntiAccesso");
        dsl.execute("DROP TABLE IF EXISTS distributore");
        dsl.execute("DROP TABLE IF EXISTS piano");
        dsl.execute("DROP TABLE IF EXISTS parcheggio");
        dsl.execute("DROP TABLE IF EXISTS edificio");
        dsl.execute("DROP TABLE IF EXISTS sede");
    }

    @Nested
    @DisplayName("Test Inserimento Sedi")
    class SediTests {

        @Test
        @DisplayName("Dovrebbe inserire tutte le 6 sedi")
        void testInsRecordSedi() {
            insertInDB.insRecordSedi();
            
            List<Sede> sedi = sedeDAO.findAll();
            assertEquals(6, sedi.size());
            
            // Verifica sede Dalmine
            Sede dalmine = sedeDAO.findByFacolta("Sede di Dalmine");
            assertNotNull(dalmine);
            assertEquals("Via A. Einstein 2", dalmine.getIndirizzo());
            assertEquals("/sedeDalmine.webp", dalmine.getPathFoto());
            assertTrue(dalmine.getOrarioApertura().contains("7.30-20.30"));
        }

        @Test
        @DisplayName("Dovrebbe gestire inserimento duplicato")
        void testInsRecordSedi_Idempotenza() {
            insertInDB.insRecordSedi();
            insertInDB.insRecordSedi(); // Secondo tentativo
            
            List<Sede> sedi = sedeDAO.findAll();
            assertEquals(6, sedi.size(), "Non dovrebbero esserci duplicati grazie a INSERT OR IGNORE");
        }
    }

    @Nested
    @DisplayName("Test Inserimento Edifici")
    class EdificiTests {

        @Test
        @DisplayName("Dovrebbe inserire edifici con FK valida")
        void testInsRecordEdifici_Success() {
            insertInDB.insRecordSedi(); // Necessario per FK
            insertInDB.insRecordEdifici();
            
            List<Edificio> edifici = edificioDAO.findAll();
            assertEquals(4, edifici.size());
            
            Edificio edD = edificioDAO.findByEdificioFacolta("Edificio D", "Sede di Dalmine");
            assertNotNull(edD);
            assertEquals("Via Galvani 2", edD.getIndirizzo());
            assertEquals("7.30-20.30", edD.getOrario());
            assertEquals("Sede di Dalmine", edD.getFacolta());
        }

        @Test
        @DisplayName("Dovrebbe fallire se sede non esiste (FK violation)")
        void testInsRecordEdifici_FKViolation() {
            // Non inseriamo sedi -> attesa eccezione
            Exception exception = assertThrows(RuntimeException.class, () -> {
                insertInDB.insRecordEdifici();
            });
            
            assertTrue(exception.getMessage().contains("integrity constraint violation") || 
                      exception.getCause().getMessage().contains("REFERENTIAL_INTEGRITY"));
        }
    }

    @Nested
    @DisplayName("Test Inserimento Completo")
    class FlussoCompletoTests {

        @Test
        @DisplayName("Dovrebbe inserire tutti i dati nell'ordine corretto")
        void testInserimentoCompleto() {
            assertDoesNotThrow(() -> {
                insertInDB.insRecordSedi();
                insertInDB.insRecordEdifici();
                insertInDB.insRecordParcheggio();
                insertInDB.insRecordPuntoIngresso();
                insertInDB.insRecordPiano();
                insertInDB.insRecordDistributore();
                insertInDB.insRecordStanza();
                insertInDB.insRecordOstacolo();
            });

            // Verifiche quantitative
            assertEquals(6, sedeDAO.findAll().size());
            assertEquals(4, edificioDAO.findAll().size());
        }
    }

    @Nested
    @DisplayName("Test Verifica Dati Specifici")
    class VerificaDatiTests {

        @BeforeEach
        void initBase() {
            insertInDB.insRecordSedi();
            insertInDB.insRecordEdifici();
            insertInDB.insRecordPiano();
        }

        @Test
        @DisplayName("Verifica distributori - coordinate e accessibilità")
        void testDistributoriDettagli() {
            insertInDB.insRecordDistributore();
            
            Distributore d1 = distributoreDAO.findById(1);
            assertNotNull(d1);
            assertEquals("Macchinetta caffe", d1.getNome());
            assertEquals(56.64, d1.getX(), 0.001);
            assertEquals(45.0, d1.getY(), 0.001);
            assertEquals(TipoDistributore.BEVANDE_CALDE, d1.getTipo());
            assertTrue(d1.getAccessibile());
            assertEquals("/DBagni_E_DistributoriDX.webp", d1.getPathFoto());
            
            Distributore d2 = distributoreDAO.findById(2);
            assertFalse(d2.getAccessibile());
            assertNotNull(d2.getDescrizione());
        }

        @Test
        @DisplayName("Verifica stanze - tipologie e posti")
        void testStanzeDettagli() {
            insertInDB.insRecordStanza();
            
            Stanza d001 = stanzaDAO.findByName("Aula D001");
            assertEquals("Aula D001", d001.getNome());
            assertEquals(275, d001.getPosti());
            assertEquals(TipoStanza.AULA, d001.getTipoStan());
            assertTrue(d001.getAccessibile());
            assertEquals(33.24, d001.getX(), 0.001);
            
            Stanza aulaStudio = stanzaDAO.findByName("Aula studio");
            assertEquals(TipoStanza.AULA_STUDIO, aulaStudio.getTipoStan());
            
            Stanza bagnoUomini = stanzaDAO.findByName("Bagno degli uomini");
            assertEquals(TipoStanza.BAGNO_UOMO, bagnoUomini.getTipoStan());
        }

        @Test
        @DisplayName("Verifica ostacoli - tipi e descrizioni")
        void testOstacoliDettagli() {
            insertInDB.insRecordOstacolo();
            
            Ostacolo sedie = ostacoloDAO.findById(1);
            assertEquals("Sedie", sedie.getNome());
            assertEquals(TipoOstacolo.OGGETTO_INGROMBRANTE, sedie.getTipo());
            assertTrue(sedie.getDescrizione().contains("sedie laterali fisse"));
            
            Ostacolo gradino = ostacoloDAO.findById(2);
            assertEquals(TipoOstacolo.DISLIVELLI, gradino.getTipo());
            assertEquals(64.75, gradino.getX(), 0.001);
        }

        @Test
        @DisplayName("Verifica uso costanti statiche")
        void testCostantiUtilizzo() {
            insertInDB.insRecordStanza();
            
            // Verifica che D002 sia stata usata
            Stanza d002 = stanzaDAO.findByName("D002");
            assertEquals("/D002.webp", d002.getPathFoto());
            
            // Verifica percorso
            assertEquals("/percorso_D002.webp", d002.getPathPercorso());
        }
    }

    @Nested
    @DisplayName("Test Relazioni e Coerenza")
    class RelazioniTests {

        @Test
        @DisplayName("Verifica relazione Edificio-Sede")
        void testRelazioneEdificioSede() {
            insertInDB.insRecordSedi();
            insertInDB.insRecordEdifici();
            
            List<Edificio> edificiDalmine = sedeDAO.findEdificiBySede("Sede di Dalmine");
            assertEquals(4, edificiDalmine.size());
            
            // Tutti gli edifici di Dalmine
            assertTrue(edificiDalmine.stream().anyMatch(e -> e.getNome().equals("Edificio A")));
            assertTrue(edificiDalmine.stream().anyMatch(e -> e.getNome().equals("Edificio D")));
        }

        @Test
        @DisplayName("Verifica relazione Piano-Edificio")
        void testRelazionePianoEdificio() {
            insertInDB.insRecordSedi();
            insertInDB.insRecordEdifici();
            insertInDB.insRecordPiano();
            
            Piano pianoTerra = pianoDAO.findPianoByEdificio(0, "Edificio D");
            assertNotNull(pianoTerra);
            assertEquals("piano terra", pianoTerra.getDescrizione());
            assertEquals("/Mappa_PianoTerra_D.webp", pianoTerra.getPathFoto());
        }

        @Test
        @DisplayName("Verifica relazione Distributore-Piano")
        void testRelazioneDistributorePiano() {
            insertInDB.insRecordSedi();
            insertInDB.insRecordEdifici();
            insertInDB.insRecordPiano();
            insertInDB.insRecordDistributore();
            
            List<Distributore> distributoriPiano0 = pianoDAO.findDistributoreByPiano(0);
            assertEquals(3, distributoriPiano0.size());
        }
    }
}