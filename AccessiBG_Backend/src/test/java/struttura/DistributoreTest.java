package struttura;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class DistributoreTest {

	// Viene controllato che tutti i valori passati vengano assegnati correttamente
	@Test
	public void testCostruttoreValoriValidi() {
		Distributore d = new Distributore(
				1,
				"Macchinetta caffe",
				"In manutenzione",
				TipoDistributore.BEVANDE_CALDE,
				true,
				56.64,
				45,
				"/DBagni_E_DistributoriDX.webp",
				"/percorso_DistributoriDX_BAGNO.webp",
				0
		);

	    assertEquals(1, d.getId());
	    assertEquals("Macchinetta caffe", d.getNome());
	    assertEquals("In manutenzione", d.getDescrizione());
	    assertEquals(TipoDistributore.BEVANDE_CALDE, d.getTipo());
	    assertEquals(56.64, d.getX(), 0.0);
	    assertEquals(45, d.getY(), 0.0);
	    assertEquals("/DBagni_E_DistributoriDX.webp", d.getPathFoto());
	    assertEquals("/percorso_DistributoriDX_BAGNO.webp", d.getPathPercorso());
	    assertEquals(0, d.getPiano());
	}
	
	// Viene controllato che un valore null passato all'attributo nome diventi "Nome non specificato"
	@Test
	public void testNomeNull() {
		Distributore d = new Distributore(
				1,
				null,
				"In manutenzione",
				TipoDistributore.BEVANDE_CALDE,
				true,
				56.64,
				45,
				"/DBagni_E_DistributoriDX.webp",
				"/percorso_DistributoriDX_BAGNO.webp",
				0
		);
		
		assertEquals("Nome non specificato", d.getNome());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo nome diventi "Nome non specificato"
	@Test
	public void testNomeVuoto() {
		Distributore d = new Distributore(
				1,
				"    ",
				"In manutenzione",
				TipoDistributore.BEVANDE_CALDE,
				true,
				56.64,
				45,
				"/DBagni_E_DistributoriDX.webp",
				"/percorso_DistributoriDX_BAGNO.webp",
				0
		);
		
		assertEquals("Nome non specificato", d.getNome());
	}
	
	// Viene controllato che un valore null passato all'attributo descrizione diventi "Descrizione non presente"
	@Test
	public void testDescrizioneNull() {
		Distributore d = new Distributore(
				1,
				"Macchinetta caffe",
				null,
				TipoDistributore.BEVANDE_CALDE,
				true,
				56.64,
				45,
				"/DBagni_E_DistributoriDX.webp",
				"/percorso_DistributoriDX_BAGNO.webp",
				0
		);
		
	    assertEquals("Descrizione non presente", d.getDescrizione());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo descrizione diventi "Descrizione non presente"
	@Test
	public void testDescrizioneVuoto() {
		Distributore d = new Distributore(
				1,
				"Macchinetta caffe",
				" ",
				TipoDistributore.BEVANDE_CALDE,
				true,
				56.64,
				45,
				"/DBagni_E_DistributoriDX.webp",
				"/percorso_DistributoriDX_BAGNO.webp",
				0
		);
		
	    assertEquals("Descrizione non presente", d.getDescrizione());
	}
	
	// Viene controllato che un valore null passato all'attributo tipo diventi SNACK_E_BEVANDE
	@Test
	public void testTipoDistributoreNull() {
		Distributore d = new Distributore(
				1,
				"Macchinetta caffe",
				"In manutenzione",
				null,
				true,
				56.64,
				45,
				"/DBagni_E_DistributoriDX.webp",
				"/percorso_DistributoriDX_BAGNO.webp",
				0
		);
		
		assertEquals(TipoDistributore.SNACK_E_BEVANDE, d.getTipo());
	}
	
	// Viene controllato che un valore false passato all'attributo accessibile rimanga false
	@Test
	public void testGetAccessibileFalse() {
		Distributore d = new Distributore(
				1,
				"Macchinetta caffe",
				"In manutenzione",
				TipoDistributore.BEVANDE_CALDE,
				false,
				56.64,
				45,
				"/DBagni_E_DistributoriDX.webp",
				"/percorso_DistributoriDX_BAGNO.webp",
				0
		);

	    assertFalse(d.getAccessibile());
	}

	
	// Viene controllato che un valore null passato all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoNull() {
		Distributore d = new Distributore(
				1,
				"Macchinetta caffe",
				"In manutenzione",
				TipoDistributore.BEVANDE_CALDE,
				true,
				56.64,
				45,
				null,
				"/percorso_DistributoriDX_BAGNO.webp",
				0
		);
		
		assertEquals("Foto non disponibile", d.getPathFoto());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoVuoto() {
		Distributore d = new Distributore(
				1,
				"Macchinetta caffe",
				"In manutenzione",
				TipoDistributore.BEVANDE_CALDE,
				true,
				56.64,
				45,
				"  ",
				"/percorso_DistributoriDX_BAGNO.webp",
				0
		);
		
		assertEquals("Foto non disponibile", d.getPathFoto());
	}
	
	// Viene controllato che un valore null passato all'attributo pathPercorso diventi "Percorso non disponibile"
	@Test
	public void testPathPercorsoNull() {
		Distributore d = new Distributore(
				1,
				"Macchinetta caffe",
				"In manutenzione",
				TipoDistributore.BEVANDE_CALDE,
				true,
				56.64,
				45,
				"/DBagni_E_DistributoriDX.webp",
				null,
				0
		);
		
		assertEquals("Percorso non disponibile", d.getPathPercorso());
	}
	
	// Viene controllato che un valore null passato all'attributo pathPercorso diventi "Percorso non disponibile"
	@Test
	public void testPathPercorsoVuoto() {
		Distributore d = new Distributore(
				1,
				"Macchinetta caffe",
				"In manutenzione",
				TipoDistributore.BEVANDE_CALDE,
				true,
				56.64,
				45,
				"/DBagni_E_DistributoriDX.webp",
				"    ",
				0
		);
		
		assertEquals("Percorso non disponibile", d.getPathPercorso());
	}
	
	// Viene verificato che tutti i controllo presenti nel costruttore agiscano insieme
	@Test
	public void testValoriNonValidi() {
		Distributore d = new Distributore(
				1,
				"  ",
				"   ",
				null,
				true,
				56.64,
				45,
				null,
				"       ",
				0
		);

	    assertEquals("Nome non specificato", d.getNome());
	    assertEquals("Descrizione non presente", d.getDescrizione());
	    assertEquals(TipoDistributore.SNACK_E_BEVANDE, d.getTipo());
	    assertEquals("Foto non disponibile", d.getPathFoto());
	    assertEquals("Percorso non disponibile", d.getPathPercorso());
	}
	
}
