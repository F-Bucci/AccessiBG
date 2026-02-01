package struttura;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class EdificioTest {

	// Viene controllato che tutti i valori passati vengano assegnati correttamente
	@Test
	public void testCostruttoreValoriValidi() {
		Edificio e = new Edificio(
				"Edificio A",
				"Via Einstein 2",
				"DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30",
				"/dalmineA.webp",
				"Sede di Dalmine"
		);
		
		assertEquals("Edificio A", e.getNome());
		assertEquals("Via Einstein 2", e.getIndirizzo());
		assertEquals("DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30", e.getOrario());
		assertEquals("/dalmineA.webp", e.getPathFoto());
		assertEquals("Sede di Dalmine", e.getFacolta());
	}
	
	// Viene controllato che un valore null passato all'attributo nome diventi "Nome non specificato"
	@Test
	public void testNomeNull() {
		Edificio e = new Edificio(
				null,
				"Via Einstein 2",
				"DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30",
				"/dalmineA.webp",
				"Sede di Dalmine"
		);
		
		assertEquals("Nome non specificato", e.getNome());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo nome diventi "Nome non specificato"
	@Test
	public void testNomeVuoto() {
		Edificio e = new Edificio(
				"  ",
				"Via Einstein 2",
				"DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30",
				"/dalmineA.webp",
				"Sede di Dalmine"
		);
		
		assertEquals("Nome non specificato", e.getNome());
	}
	
	// Viene controllato che un valore null passato all'attributo indirizzo diventi "Indirizzo non disponibile"
	@Test
	public void testIndirizzoNull() {
		Edificio e = new Edificio(
				"Edificio A",
				null,
				"DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30",
				"/dalmineA.webp",
				"Sede di Dalmine"
		);
		
		assertEquals("Indirizzo non disponibile", e.getIndirizzo());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo indirizzo diventi "Indirizzo non disponibile"
	@Test
	public void testIndirizzoVuoto() {
		Edificio e = new Edificio(
				"Edificio A",
				"   ",
				"DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30",
				"/dalmineA.webp",
				"Sede di Dalmine"
		);
		
		assertEquals("Indirizzo non disponibile", e.getIndirizzo());
	}
	
	// Viene controllato che un valore null passato all'attributo orario diventi "Orario non specificato"
	@Test
	public void testOrarioNull() {
		Edificio e = new Edificio(
				"Edificio A",
				"Via Einstein 2",
				null,
				"/dalmineA.webp",
				"Sede di Dalmine"
		);
		
		assertEquals("Orario non specificato", e.getOrario());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo orario diventi "Orario non specificato"
	@Test
	public void testOrarioVuoto() {
		Edificio e = new Edificio(
				"Edificio A",
				"Via Einstein 2",
				"  ",
				"/dalmineA.webp",
				"Sede di Dalmine"
		);
		
		assertEquals("Orario non specificato", e.getOrario());
	}
	
	// Viene controllato che un valore null passato all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoNull() {
		Edificio e = new Edificio(
				"Edificio A",
				"Via Einstein 2",
				"DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30",
				null,
				"Sede di Dalmine"
		);
		
		assertEquals("Foto non disponibile", e.getPathFoto());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoVuoto() {
		Edificio e = new Edificio(
				"Edificio A",
				"Via Einstein 2",
				"DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30",
				"  ",
				"Sede di Dalmine"
		);
		
		assertEquals("Foto non disponibile", e.getPathFoto());
	}
	
	// Viene controllato che un valore null passato all'attributo facolta diventi "Facoltà non specificata"
	@Test
	public void testFacoltaNull() {
		Edificio e = new Edificio(
				"Edificio A",
				"Via Einstein 2",
				"DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30",
				"/dalmineA.webp",
				null
		);
		
		assertEquals("Facoltà non specificata", e.getFacolta());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo facolta diventi "Facoltà non specificata"
	@Test
	public void testFacoltaVuoto() {
		Edificio e = new Edificio(
				"Edificio A",
				"Via Einstein 2",
				"DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30",
				"/dalmineA.webp",
				"  "
		);
		
		assertEquals("Facoltà non specificata", e.getFacolta());
	}
	
	// Viene verificato che tutti i controllo presenti nel costruttore agiscano insieme
	@Test
	public void testValoriNonValidi() {
		Edificio e = new Edificio(
				"   ",
				null,
				"           ",
				null,
				null
		);
		
		assertEquals("Nome non specificato", e.getNome());
		assertEquals("Indirizzo non disponibile", e.getIndirizzo());
		assertEquals("Orario non specificato", e.getOrario());
		assertEquals("Foto non disponibile", e.getPathFoto());
		assertEquals("Facoltà non specificata", e.getFacolta());
	}
	
	// Verificare che lista dei punti di ingresso inizia vuota, ma non può essere null
	@Test
    public void testGetPuntiDiAccessoInizialmenteVuota() {
		Edificio e = new Edificio(
				"Edificio A",
				"Via Einstein 2",
				null,
				"/dalmineA.webp",
				"Sede di Dalmine"
		);

        List<PuntoDiIngresso> lista = e.getPuntiDiAccesso();

        assertNotNull(lista); // La lista dei punti di ingresso non dovrebbe essere null
        assertTrue(lista.isEmpty()); // La lista dei punti di ingresso dovrebbe essere inizialmente vuota
    }
	
}
