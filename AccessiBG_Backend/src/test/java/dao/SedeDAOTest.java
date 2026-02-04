package dao;

import gestione_db.CreateTable;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.*;

import dao.EdificioDAO;
import dao.ParcheggioDAO;
import dao.SedeDAO;
import struttura.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SedeDAOTest {

    private Connection connection;
    private DSLContext dsl;
    private SedeDAO sedeDAO;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        dsl = DSL.using(connection, SQLDialect.SQLITE);
        dsl.execute("PRAGMA foreign_keys = ON");

        // Crea schema
        new CreateTable(dsl).createTable();

        // Inizializza DAO
        sedeDAO = new SedeDAO(dsl);
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Nested
    @DisplayName("Test Inserimento")
    class InserimentoTests {

        @Test
        @DisplayName("Inserisce una sede correttamente")
        void testInsert() {
            Sede sede = new Sede(
                "Sede Test",
                "Via Test 123",
                "/foto.jpg",
                "9-18",
                "maps"
            );

            assertDoesNotThrow(() -> sedeDAO.insert(sede));

            // Verifica inserimento
            Sede result = sedeDAO.findByFacolta("Sede Test");
            assertNotNull(result);
            assertEquals("Via Test 123", result.getIndirizzo());
        }

        @Test
        @DisplayName("Gestisce duplicati con onConflict doNothing")
        void testInsertDuplicate() {
            Sede sede1 = new Sede("Sede Unica", "Via 1", "/foto1.jpg", "9-18", "maps1");
            Sede sede2 = new Sede("Sede Unica", "Via 2", "/foto2.jpg", "10-19", "maps2");

            sedeDAO.insert(sede1);
            sedeDAO.insert(sede2); // Duplicato, dovrebbe essere ignorato

            Sede result = sedeDAO.findByFacolta("Sede Unica");
            assertNotNull(result);
            assertEquals("Via 1", result.getIndirizzo()); // Primo inserimento
        }
    }

    @Nested
    @DisplayName("Test Ricerca")
    class RicercaTests {

        @BeforeEach
        void initData() {
            sedeDAO.insert(new Sede("Sede A", "Via A", "/a.jpg", "9-18", "mapA"));
            sedeDAO.insert(new Sede("Sede B", "Via B", "/b.jpg", "8-20", "mapB"));
            sedeDAO.insert(new Sede("Sede C", "Via C", "/c.jpg", "10-16", "mapC"));
        }

        @Test
        @DisplayName("Trova sede per facolta")
        void testFindByFacolta() {
            Sede result = sedeDAO.findByFacolta("Sede B");

            assertNotNull(result);
            assertEquals("Sede B", result.getFacolta());
            assertEquals("Via B", result.getIndirizzo());
            assertEquals("/b.jpg", result.getPathFoto());
            assertEquals("8-20", result.getOrarioApertura());
            assertEquals("mapB", result.getPathMaps());
        }

        @Test
        @DisplayName("Restituisce null per facolta inesistente")
        void testFindByFacoltaNotFound() {
            Sede result = sedeDAO.findByFacolta("Sede Inesistente");
            assertNull(result);
        }

        @Test
        @DisplayName("Trova tutte le sedi")
        void testFindAll() {
            List<Sede> sedi = sedeDAO.findAll();

            assertEquals(3, sedi.size());
            assertTrue(sedi.stream().anyMatch(s -> s.getFacolta().equals("Sede A")));
            assertTrue(sedi.stream().anyMatch(s -> s.getFacolta().equals("Sede B")));
            assertTrue(sedi.stream().anyMatch(s -> s.getFacolta().equals("Sede C")));
        }
    }

    @Nested
    @DisplayName("Test Relazioni")
    class RelazioniTests {

        @BeforeEach
        void initData() {
            // Inserisci sede
            sedeDAO.insert(new Sede("Sede Dalmine", "Via Einstein 2", "/dalmine.jpg", "9-18", "maps"));

            // Inserisci edifici collegati (richiede EdificioDAO)
            EdificioDAO edificioDAO = new EdificioDAO(dsl);
            edificioDAO.insert(new Edificio("Ed A", "Via A", "9-18", "/edA.jpg", "Sede Dalmine"));
            edificioDAO.insert(new Edificio("Ed B", "Via B", "8-20", "/edB.jpg", "Sede Dalmine"));

            // Inserisci parcheggi collegati (richiede ParcheggioDAO)
            ParcheggioDAO parcheggioDAO = new ParcheggioDAO(dsl);
            parcheggioDAO.insert(new Parcheggio("Park 1", TipoParcheggio.LIBERO, true, "Via P1", "/p1.jpg", "Sede Dalmine"));
        }

        @Test
        @DisplayName("Trova edifici per sede")
        void testFindEdificiBySede() {
            List<Edificio> edifici = sedeDAO.findEdificiBySede("Sede Dalmine");

            assertEquals(2, edifici.size());
            assertTrue(edifici.stream().anyMatch(e -> e.getNome().equals("Ed A")));
            assertTrue(edifici.stream().anyMatch(e -> e.getNome().equals("Ed B")));
        }

        @Test
        @DisplayName("Trova parcheggi per sede")
        void testFindParcheggioBySede() {
            List<Parcheggio> parcheggi = sedeDAO.findParcheggioBySede("Sede Dalmine");

            assertEquals(1, parcheggi.size());
            assertEquals("Park 1", parcheggi.get(0).getNome());
        }

        @Test
        @DisplayName("Restituisce lista vuota per sede senza edifici")
        void testFindEdificiEmpty() {
            sedeDAO.insert(new Sede("Sede Vuota", "Via Vuota", "/vuota.jpg", "9-18", "maps"));

            List<Edificio> edifici = sedeDAO.findEdificiBySede("Sede Vuota");
            assertTrue(edifici.isEmpty());
        }
    }
}
