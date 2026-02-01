package struttura;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PianoTest {

	// Viene verificato che nessuna normalizzazione venga applicata quando i dati sono corretti
	@Test
	public void testCostruttoreValoriValidi() {
	    Piano p = new Piano(0, "Piano terra", "Edificio D");

	    assertEquals(0, p.getNumero());
	    assertEquals("Piano terra", p.getDescrizione());
	    assertEquals("Edificio D", p.getEdificio());
	}
	
	// Viene controllato che un valore negativo passato al numero del piano diventi 0
	@Test
	public void testNumeroPianoNegativo() {
	    Piano p = new Piano(-2, null, null);
	    
	    assertEquals(-1, p.getNumero());
	}
	
	// Viene controllato che un valore null passato all'attributo descrizione diventi "Descrizione non presente"
	@Test
	public void testDescrizioneNull() {
		Piano p = new Piano(0, null, "Edificio D");
		
	    assertEquals("Descrizione non presente", p.getDescrizione());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo descrizione diventi "Descrizione non presente"
	@Test
	public void testDescrizioneVuoto() {
		Piano p = new Piano(0, "  ", "Edificio D");
		
		assertEquals("Descrizione non presente", p.getDescrizione());
	}
	
	// Viene controllato che un valore null passato all'attributo edificio diventi "Descrizione non presente"
	@Test
	public void testEdificioNull() {
		Piano p = new Piano(0, "Piano terra", null);
		
	    assertEquals("Edificio non specificato", p.getEdificio());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo edificio diventi "Descrizione non presente"
	@Test
	public void testEdificioVuoto() {
		Piano p = new Piano(0, "Piano terra", "  ");
		
		assertEquals("Edificio non specificato", p.getEdificio());
	}
	
	// Viene verificato che tutti i controlli agiscano insieme
	@Test
	public void testValoriNonValidi() {
		Piano p = new Piano(-4, " ", null);
		
		assertEquals(-1, p.getNumero());
		assertEquals("Descrizione non presente", p.getDescrizione());
		assertEquals("Edificio non specificato", p.getEdificio());
	}
	
}
