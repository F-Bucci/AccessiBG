package struttura;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParcheggioTest {

	// Viene controllato che tutti i valori passati vengano assegnati correttamente
	@Test
	public void testCostruttoreValoriValidi() {
		Parcheggio p = new Parcheggio(
				"Parcheggio sterrato C",
				TipoParcheggio.LIBERO,
				true,
				"Via Galvani 7",
				"/parcheggioSterrato.webp",
				"Sede di Dalmine"
		);

	    assertEquals("Parcheggio sterrato C", p.getNome());
	    assertEquals(TipoParcheggio.LIBERO, p.getTipo());
	    assertEquals(true, p.getPostiDisabili());
	    assertEquals("Via Galvani 7", p.getIndirizzo());
	    assertEquals("/parcheggioSterrato.webp", p.getPathFoto());
	    assertEquals("Sede di Dalmine", p.getFacolta());
	}
	
	// Viene controllato che un valore null passato all'attributo nome diventi "Nome non specificato"
	@Test
	public void testNomeNull() {
		Parcheggio p = new Parcheggio(
				null,
				TipoParcheggio.LIBERO,
				true,
				"Via Galvani 7",
				"/parcheggioSterrato.webp",
				"Sede di Dalmine"
		);
		
		assertEquals("Nome non specificato", p.getNome());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo nome diventi "Nome non specificato"
	@Test
	public void testNomeVuoto() {
		Parcheggio p = new Parcheggio(
				"   ",
				TipoParcheggio.LIBERO,
				true,
				"Via Galvani 7",
				"/parcheggioSterrato.webp",
				"Sede di Dalmine"
		);
		
		assertEquals("Nome non specificato", p.getNome());
	}
	
	// Viene controllato che un valore null passato all'attributo tipo diventi LIBERO
	@Test
	public void testTipoParcheggioNull() {
		Parcheggio p = new Parcheggio(
				"Parcheggio sterrato C",
				null,
				true,
				"Via Galvani 7",
				"/parcheggioSterrato.webp",
				"Sede di Dalmine"
		);
		
		assertEquals(TipoParcheggio.LIBERO, p.getTipo());
	}
	
	// Viene controllato che un valore null passato all'attributo indirizzo diventi "Indirizzo non disponibile"
	@Test
	public void testIndirizzoNull() {
		Parcheggio p = new Parcheggio(
				"Parcheggio sterrato C",
				TipoParcheggio.LIBERO,
				true,
				null,
				"/parcheggioSterrato.webp",
				"Sede di Dalmine"
		);
		
		assertEquals("Indirizzo non disponibile", p.getIndirizzo());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo indirizzo diventi "Indirizzo non disponibile"
	@Test
	public void testIndirizzoVuoto() {
		Parcheggio p = new Parcheggio(
				"Parcheggio sterrato C",
				TipoParcheggio.LIBERO,
				true,
				"  ",
				"/parcheggioSterrato.webp",
				"Sede di Dalmine"
		);
		
		assertEquals("Indirizzo non disponibile", p.getIndirizzo());
	}
	
	// Viene controllato che un valore null passato all'attributo facolta diventi "Facoltà non specificata"
	@Test
	public void testFacoltaNull() {
		Parcheggio p = new Parcheggio(
				"Parcheggio sterrato C",
				TipoParcheggio.LIBERO,
				true,
				"Via Galvani 7",
				"/parcheggioSterrato.webp",
				null
		);
		
		assertEquals("Facoltà non specificata", p.getFacolta());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo facolta diventi "Facoltà non specificata"
	@Test
	public void testFacoltaVuoto() {
		Parcheggio p = new Parcheggio(
				"Parcheggio sterrato C",
				TipoParcheggio.LIBERO,
				true,
				"Via Galvani 7",
				"/parcheggioSterrato.webp",
				"   "
		);
		
		assertEquals("Facoltà non specificata", p.getFacolta());
	}
	
	// Viene controllato che un valore null passato all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoNull() {
		Parcheggio p = new Parcheggio(
				"Parcheggio sterrato C",
				TipoParcheggio.LIBERO,
				true,
				"Via Galvani 7",
				null,
				"Sede di Dalmine"
		);
		
		assertEquals("Foto non disponibile", p.getPathFoto());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoVuoto() {
		Parcheggio p = new Parcheggio(
				"Parcheggio sterrato C",
				TipoParcheggio.LIBERO,
				true,
				"Via Galvani 7",
				"",
				"Sede di Dalmine"
		);
		
		assertEquals("Foto non disponibile", p.getPathFoto());
	}
	
	// Viene verificato che tutti i controllo presenti nel costruttore agiscano insieme
	@Test
	public void testValoriNonValidi() {
		Parcheggio p = new Parcheggio(
				"",
				null,
				true,
				"  ",
				null,
				"     "
		);

	    assertEquals("Nome non specificato", p.getNome());
	    assertEquals(TipoParcheggio.LIBERO, p.getTipo());
	    assertEquals(true, p.getPostiDisabili());
	    assertEquals("Indirizzo non disponibile", p.getIndirizzo());
	    assertEquals("Foto non disponibile", p.getPathFoto());
	    assertEquals("Facoltà non specificata", p.getFacolta());
	}
	
}
