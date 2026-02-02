package struttura;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PianoTest {

	// Viene verificato che nessuna normalizzazione venga applicata quando i dati sono corretti
	@Test
	public void testCostruttoreValoriValidi() {
	    Piano p = new Piano(0, "Piano terra", "/Mappa_PianoTerra_D.webp", "Edificio D");

	    assertEquals(0, p.getNumero());
	    assertEquals("Piano terra", p.getDescrizione());
	    assertEquals("Edificio D", p.getEdificio());
	}
	
	// Viene controllato che un valore null passato all'attributo descrizione diventi "Descrizione non presente"
	@Test
	public void testDescrizioneNull() {
		Piano p = new Piano(0, null, "/Mappa_PianoTerra_D.webp", "Edificio D");
		
	    assertEquals("Descrizione non presente", p.getDescrizione());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo descrizione diventi "Descrizione non presente"
	@Test
	public void testDescrizioneVuoto() {
		Piano p = new Piano(0, "  ", "/Mappa_PianoTerra_D.webp", "Edificio D");
		
		assertEquals("Descrizione non presente", p.getDescrizione());
	}
	
	// Viene controllato che un valore null passato all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoNull() {
		Piano p = new Piano(0, "Piano terra", null, "Edificio D");
		
		assertEquals("Foto non disponibile", p.getPathFoto());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoVuoto() {
		Piano p = new Piano(0, "Piano terra", "", "Edificio D");
		
		assertEquals("Foto non disponibile", p.getPathFoto());
	}
	
	// Viene controllato che un valore null passato all'attributo edificio diventi "Descrizione non presente"
	@Test
	public void testEdificioNull() {
		Piano p = new Piano(0, "Piano terra", "/Mappa_PianoTerra_D.webp", null);
		
	    assertEquals("Edificio non specificato", p.getEdificio());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo edificio diventi "Descrizione non presente"
	@Test
	public void testEdificioVuoto() {
		Piano p = new Piano(0, "Piano terra", "/Mappa_PianoTerra_D.webp", "  ");
		
		assertEquals("Edificio non specificato", p.getEdificio());
	}
	
	// Viene verificato che tutti i controlli nel costruttore agiscano insieme (tranne il numero)
	@Test
	public void testValoriNonValidi() {
		Piano p = new Piano(-1, " ", "   ", null);
		
		assertEquals(-1, p.getNumero());
		assertEquals("Descrizione non presente", p.getDescrizione());
		assertEquals("Foto non disponibile", p.getPathFoto());
		assertEquals("Edificio non specificato", p.getEdificio());
	}
	
}
