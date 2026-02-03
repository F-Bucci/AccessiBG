package struttura;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OstacoloTest {

	// Viene controllato che tutti i valori passati vengano assegnati correttamente
	@Test
	public void testCostruttoreValoriValidi() {
		Ostacolo o = new Ostacolo(
				3,
				"Gradino",
				TipoOstacolo.DISLIVELLI,
				"Gradino all'entrantata dell'aula D002",
				64.75,
				70.25,
				"/D002.webp",
				null,
				0
		);

		assertEquals(3, o.getId());
		assertEquals("Gradino", o.getNome());
		assertEquals(TipoOstacolo.DISLIVELLI, o.getTipo());
		assertEquals("Gradino all'entrantata dell'aula D002", o.getDescrizione());
		assertEquals(64.75, o.getX(), 0.0);
		assertEquals(70.25, o.getY(), 0.0);
		assertEquals("/D002.webp", o.getPathFoto());
		assertEquals(null, o.getPathPercorso());
		assertEquals(0, o.getPiano());
	}
	
	// Viene controllato che un valore null passato all'attributo nome diventi "Nome non specificato"
	@Test
	public void testNomeNull() {
		Ostacolo o = new Ostacolo(
				3,
				null,
				TipoOstacolo.DISLIVELLI,
				"Gradino all'entrantata dell'aula D002",
				64.75,
				70.25,
				"/D002.webp",
				null,
				0
		);
		
		assertEquals("Nome non specificato", o.getNome());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo nome diventi "Nome non specificato"
	@Test
	public void testNomeVuoto() {
		Ostacolo o = new Ostacolo(
				3,
				"",
				TipoOstacolo.DISLIVELLI,
				"Gradino all'entrantata dell'aula D002",
				64.75,
				70.25,
				"/D002.webp",
				null,
				0
		);
		
		assertEquals("Nome non specificato", o.getNome());
	}
	
	// Viene controllato che un valore null passato all'attributo tipo diventi OGGETTO_INGOMBRANTE
	@Test
	public void testTipoOstacoloNull() {
		Ostacolo o = new Ostacolo(
				3,
				"Gradino",
				null,
				"Gradino all'entrantata dell'aula D002",
				64.75,
				70.25,
				"/D002.webp",
				null,
				0
		);
		
		assertEquals(TipoOstacolo.OGGETTO_INGROMBRANTE, o.getTipo());
	}
	
	// Viene controllato che un valore null passato all'attributo descrizione diventi "Descrizione non presente"
	@Test
	public void testDescrizioneNull() {
		Ostacolo o = new Ostacolo(
				3,
				"Gradino",
				TipoOstacolo.DISLIVELLI,
				null,
				64.75,
				70.25,
				"/D002.webp",
				null,
				0
		);
		
	    assertEquals("Descrizione non presente", o.getDescrizione());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo descrizione diventi "Descrizione non presente"
	@Test
	public void testDescrizioneVuoto() {
		Ostacolo o = new Ostacolo(
				3,
				"Gradino",
				TipoOstacolo.DISLIVELLI,
				"     ",
				64.75,
				70.25,
				"/D002.webp",
				null,
				0
		);
		
	    assertEquals("Descrizione non presente", o.getDescrizione());
	}
	
	// Viene controllato che un valore null passato all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoNull() {
		Ostacolo o = new Ostacolo(
				3,
				"Gradino",
				TipoOstacolo.DISLIVELLI,
				"Gradino all'entrantata dell'aula D002",
				64.75,
				70.25,
				null,
				null,
				0
		);
		
		assertEquals("Foto non disponibile", o.getPathFoto());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoVuoto() {
		Ostacolo o = new Ostacolo(
				3,
				"Gradino",
				TipoOstacolo.DISLIVELLI,
				"Gradino all'entrantata dell'aula D002",
				64.75,
				70.25,
				null,
				"",
				0
		);
		
		assertEquals("Foto non disponibile", o.getPathFoto());
	}
	
	// Viene verificato che tutti i controllo presenti nel costruttore agiscano insieme
	@Test
	public void testValoriNonValidi() {
		Ostacolo o = new Ostacolo(
				3,
				null,
				null,
				" ",
				64.75,
				70.25,
				"",
				null,
				0
		);

		assertEquals("Nome non specificato", o.getNome());
		assertEquals(TipoOstacolo.OGGETTO_INGROMBRANTE, o.getTipo());
		assertEquals("Descrizione non presente", o.getDescrizione());
		assertEquals("Foto non disponibile", o.getPathFoto());
	}
	
}
