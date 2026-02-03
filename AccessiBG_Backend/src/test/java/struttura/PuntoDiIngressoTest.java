package struttura;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PuntoDiIngressoTest {

	// Viene controllato che tutti i valori passati vengano assegnati correttamente
	@Test
	public void testCostruttoreValoriValidi() {
		PuntoDiIngresso p = new PuntoDiIngresso(
				1,
				"Ingresso principale",
				"descrizione",
				false,
				true,
				false,
				false,
				33.10,
				85.38,
				"/ingressoD.webp",
				null,
				"Edificio D"
		);
		
		assertEquals(1, p.getId());
		assertEquals("Ingresso principale", p.getNome());
		assertEquals("descrizione", p.getDescrizione());
		assertEquals(false, p.getScale());
		assertEquals(true, p.getRampe());
		assertEquals(false, p.getPortaTagliafuoco());
		assertEquals(false, p.getPercorsoStrisceIpov());
		assertEquals(33.10, p.getX(), 0.0);
		assertEquals(85.38, p.getY(), 0.0);
		assertEquals("/ingressoD.webp", p.getPathFoto());
		assertEquals("Edificio D", p.getEdificio());
	}
	
	// Viene controllato che un valore null passato all'attributo nome diventi "Nome non specificato"
	@Test
	public void testNomeNull() {
		PuntoDiIngresso p = new PuntoDiIngresso(
				1,
				null,
				"descrizione",
				false,
				true,
				false,
				false,
				33.10,
				85.38,
				"/ingressoD.webp",
				null,
				"Edificio D"
		);
		
		assertEquals("Nome non specificato", p.getNome());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo nome diventi "Nome non specificato"
	@Test
	public void testNomeVuoto() {
		PuntoDiIngresso p = new PuntoDiIngresso(
				1,
				"",
				"descrizione",
				false,
				true,
				false,
				false,
				33.10,
				85.38,
				"/ingressoD.webp",
				null,
				"Edificio D"
		);
		
		assertEquals("Nome non specificato", p.getNome());
	}
	
	// Viene controllato che un valore null passato all'attributo descrizione diventi "Descrizione non presente"
	@Test
	public void testDescrizioneNull() {
		PuntoDiIngresso p = new PuntoDiIngresso(
				1,
				"Ingresso principale",
				null,
				false,
				true,
				false,
				false,
				33.10,
				85.38,
				"/ingressoD.webp",
				null,
				"Edificio D"
		);
		
	    assertEquals("Descrizione non presente", p.getDescrizione());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo descrizione diventi "Descrizione non presente"
	@Test
	public void testDescrizioneVuoto() {
		PuntoDiIngresso p = new PuntoDiIngresso(
				1,
				"Ingresso principale",
				" ",
				false,
				true,
				false,
				false,
				33.10,
				85.38,
				"/ingressoD.webp",
				null,
				"Edificio D"
		);
		
	    assertEquals("Descrizione non presente", p.getDescrizione());
	}
	
	// Viene controllato che un valore null passato all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoNull() {
		PuntoDiIngresso p = new PuntoDiIngresso(
				1,
				"Ingresso principale",
				"descrizione",
				false,
				true,
				false,
				false,
				33.10,
				85.38,
				null,
				null,
				"Edificio D"
		);
		
		assertEquals("Foto non disponibile", p.getPathFoto());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoVuoto() {
		PuntoDiIngresso p = new PuntoDiIngresso(
				1,
				"Ingresso principale",
				"descrizione",
				false,
				true,
				false,
				false,
				33.10,
				85.38,
				"   ",
				null,
				"Edificio D"
		);
		
		assertEquals("Foto non disponibile", p.getPathFoto());
	}
	
	// Viene controllato che un valore null passato all'attributo edificio diventi "Descrizione non presente"
	@Test
	public void testEdificioNull() {
		PuntoDiIngresso p = new PuntoDiIngresso(
				1,
				"Ingresso principale",
				"descrizione",
				false,
				true,
				false,
				false,
				33.10,
				85.38,
				"/ingressoD.webp",
				null,
				null
		);
		
	    assertEquals("Edificio non specificato", p.getEdificio());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo edificio diventi "Descrizione non presente"
	@Test
	public void testEdificioVuoto() {
		PuntoDiIngresso p = new PuntoDiIngresso(
				1,
				"Ingresso principale",
				"descrizione",
				false,
				true,
				false,
				false,
				33.10,
				85.38,
				"/ingressoD.webp",
				null,
				"    "
		);
		
	    assertEquals("Edificio non specificato", p.getEdificio());
	}
	
	// Viene verificato che tutti i controlli nel costruttore agiscano insieme (tranne il numero)
	@Test
	public void testValoriNonValidi() {
		PuntoDiIngresso p = new PuntoDiIngresso(
				1,
				null,
				" ",
				false,
				true,
				false,
				false,
				33.10,
				85.38,
				null,
				null,
				"    "
		);
		
		assertEquals("Nome non specificato", p.getNome());
		assertEquals("Descrizione non presente", p.getDescrizione());
		assertEquals("Foto non disponibile", p.getPathFoto());
		assertEquals("Edificio non specificato", p.getEdificio());
	}
	
}
