package struttura;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StanzaTest {

	// Viene controllato che tutti i valori passati vengano assegnati correttamente
	@Test
	public void testCostruttoreValoriValidi() {
		Stanza s = new Stanza(
				5,
				"Bagno delle donne",
				4,
				"Il bagno delle donne è situato sulla destra",
				true,
				60.35,
				34.62,
				TipoStanza.BAGNO_DONNA,
				"/percorso_DistributoriDX_BAGNO.webp",
				"/DBagni_E_DistributoriDX.webp",
				0
		);

	    assertEquals(5, s.getId());
	    assertEquals("Bagno delle donne", s.getNome());
	    assertEquals(4, s.getPosti());
	    assertEquals("Il bagno delle donne è situato sulla destra", s.getDescrizione());
	    assertEquals(true, s.getAccessibile());
	    assertEquals(60.35, s.getX(), 0.0);
	    assertEquals(34.62, s.getY(), 0.0);
	    assertEquals(TipoStanza.BAGNO_DONNA, s.getTipoStan());
	    assertEquals("/percorso_DistributoriDX_BAGNO.webp", s.getPathPercorso());
	    assertEquals("/DBagni_E_DistributoriDX.webp", s.getPathFoto());
	    assertEquals(0, s.getPiano());
	}
	
	// Viene controllato che un valore null passato all'attributo nome diventi "Nome non specificato"
	@Test
	public void testNomeNull() {
		Stanza s = new Stanza(
				5,
				null,
				4,
				"Il bagno delle donne è situato sulla destra",
				true,
				60.35,
				34.62,
				TipoStanza.BAGNO_DONNA,
				"/percorso_DistributoriDX_BAGNO.webp",
				"/DBagni_E_DistributoriDX.webp",
				0
		);
		
		assertEquals("Nome non specificato", s.getNome());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo nome diventi "Nome non specificato"
	@Test
	public void testNomeVuoto() {
		Stanza s = new Stanza(
				5,
				"",
				4,
				"Il bagno delle donne è situato sulla destra",
				true,
				60.35,
				34.62,
				TipoStanza.BAGNO_DONNA,
				"/percorso_DistributoriDX_BAGNO.webp",
				"/DBagni_E_DistributoriDX.webp",
				0
		);
		
		assertEquals("Nome non specificato", s.getNome());
	}
	
	// Viene controllato che un valore negativo passato all'attributo posti diventi 0
	@Test
	public void testCapacitaNegativa() {
		Stanza s = new Stanza(
				5,
				"Bagno delle donne",
				-8,
				"Il bagno delle donne è situato sulla destra",
				true,
				60.35,
				34.62,
				TipoStanza.BAGNO_DONNA,
				"/percorso_DistributoriDX_BAGNO.webp",
				"/DBagni_E_DistributoriDX.webp",
				0
		);
		
		assertEquals(0, s.getPosti());
	}
	
	// Viene controllato che un valore null passato all'attributo descrizione diventi "Descrizione non presente"
	@Test
	public void testDescrizioneNull() {
		Stanza s = new Stanza(
				5,
				"Bagno delle donne",
				4,
				null,
				true,
				60.35,
				34.62,
				TipoStanza.BAGNO_DONNA,
				"/percorso_DistributoriDX_BAGNO.webp",
				"/DBagni_E_DistributoriDX.webp",
				0
		);
		
	    assertEquals("Descrizione non presente", s.getDescrizione());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo descrizione diventi "Descrizione non presente"
	@Test
	public void testDescrizioneVuoto() {
		Stanza s = new Stanza(
				5,
				"Bagno delle donne",
				4,
				"   ",
				true,
				60.35,
				34.62,
				TipoStanza.BAGNO_DONNA,
				"/percorso_DistributoriDX_BAGNO.webp",
				"/DBagni_E_DistributoriDX.webp",
				0
		);
		
	    assertEquals("Descrizione non presente", s.getDescrizione());
	}
	
	// Viene controllato che un valore null passato all'attributo tipoStan diventi AULA
	@Test
	public void testTipoStanzaNull() {
		Stanza s = new Stanza(
				5,
				"Bagno delle donne",
				4,
				"Il bagno delle donne è situato sulla destra",
				true,
				60.35,
				34.62,
				null,
				"/percorso_DistributoriDX_BAGNO.webp",
				"/DBagni_E_DistributoriDX.webp",
				0
		);
		
		assertEquals(TipoStanza.AULA, s.getTipoStan());
	}
	
	// Viene controllato che un valore null passato all'attributo pathPercorso diventi "Percorso non disponibile"
	@Test
	public void testPathPercorsoNull() {
		Stanza s = new Stanza(
				5,
				"Bagno delle donne",
				4,
				"Il bagno delle donne è situato sulla destra",
				true,
				60.35,
				34.62,
				TipoStanza.BAGNO_DONNA,
				null,
				"/DBagni_E_DistributoriDX.webp",
				0
		);
		
		assertEquals("Percorso non disponibile", s.getPathPercorso());
	}
	
	// Viene controllato che un valore null passato all'attributo pathPercorso diventi "Percorso non disponibile"
	@Test
	public void testPathPercorsoVuoto() {
		Stanza s = new Stanza(
				5,
				"Bagno delle donne",
				4,
				"Il bagno delle donne è situato sulla destra",
				true,
				60.35,
				34.62,
				TipoStanza.BAGNO_DONNA,
				"     ",
				"/DBagni_E_DistributoriDX.webp",
				0
		);
		
		assertEquals("Percorso non disponibile", s.getPathPercorso());
	}
	
	// Viene controllato che un valore null passato all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoNull() {
		Stanza s = new Stanza(
				5,
				"Bagno delle donne",
				4,
				"Il bagno delle donne è situato sulla destra",
				true,
				60.35,
				34.62,
				TipoStanza.BAGNO_DONNA,
				"/percorso_DistributoriDX_BAGNO.webp",
				null,
				0
		);
		
		assertEquals("Foto non disponibile", s.getPathFoto());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoVuoto() {
		Stanza s = new Stanza(
				5,
				"Bagno delle donne",
				4,
				"Il bagno delle donne è situato sulla destra",
				true,
				60.35,
				34.62,
				TipoStanza.BAGNO_DONNA,
				"/percorso_DistributoriDX_BAGNO.webp",
				" ",
				0
		);
		
		assertEquals("Foto non disponibile", s.getPathFoto());
	}
	
	// Viene verificato che tutti i controllo presenti nel costruttore agiscano insieme
	@Test
	public void testValoriNonValidi() {
		Stanza s = new Stanza(
				5,
				null,
				-5,
				"               ",
				true,
				60.35,
				34.62,
				null,
				"     ",
				null,
				0
		);

	    assertEquals("Nome non specificato", s.getNome());
	    assertEquals(0, s.getPosti());
	    assertEquals("Descrizione non presente", s.getDescrizione());
	    assertEquals(TipoStanza.AULA, s.getTipoStan());
	    assertEquals("Percorso non disponibile", s.getPathPercorso());
	    assertEquals("Foto non disponibile", s.getPathFoto());
	}
	
}
