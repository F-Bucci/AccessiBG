package struttura;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SedeTest {
	
	// Viene controllato che tutti i valori passati vengano assegnati correttamente
	@Test
	public void testCostruttoreValoriValidi() {
		Sede s = new Sede(
		        "Sede di Sant'Agostino",
		        "Piazzale Sant'Agostino, 2",
		        "/sedeCittaAlta.webp",
		        "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30",
		        "urlMaps"
	    );

	    assertEquals("Sede di Sant'Agostino", s.getFacolta());
	    assertEquals("Piazzale Sant'Agostino, 2", s.getIndirizzo());
	    assertEquals("/sedeCittaAlta.webp", s.getPathFoto());
	    assertEquals("Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30", s.getOrarioApertura());
	    assertEquals("urlMaps", s.getPathMaps());
	}
	
	// Viene controllato che un valore null passato all'attributo facolta diventi "Facoltà non specificata"
	@Test
	public void testFacoltaNull() {
		Sede s = new Sede(
		        null,
		        "Piazzale Sant'Agostino, 2",
		        "/sedeCittaAlta.webp",
		        "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30",
		        "urlMaps"
	    );
		
		assertEquals("Facoltà non specificata", s.getFacolta());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo facolta diventi "Facoltà non specificata"
	@Test
	public void testFacoltaVuoto() {
		Sede s = new Sede(
		        "  ",
		        "Piazzale Sant'Agostino, 2",
		        "/sedeCittaAlta.webp",
		        "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30",
		        "urlMaps"
	    );
		
		assertEquals("Facoltà non specificata", s.getFacolta());
	}
	
	// Viene controllato che un valore null passato all'attributo indirizzo diventi "Indirizzo non disponibile"
	@Test
	public void testIndirizzoNull() {
		Sede s = new Sede(
		        "Sede di Sant'Agostino",
		        null,
		        "/sedeCittaAlta.webp",
		        "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30",
		        "urlMaps"
	    );
		
		assertEquals("Indirizzo non disponibile", s.getIndirizzo());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo indirizzo diventi "Indirizzo non disponibile"
	@Test
	public void testIndirizzoVuoto() {
		Sede s = new Sede(
		        "Sede di Sant'Agostino",
		        "  ",
		        "/sedeCittaAlta.webp",
		        "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30",
		        "urlMaps"
	    );
		
		assertEquals("Indirizzo non disponibile", s.getIndirizzo());
	}
	
	// Viene controllato che un valore null passato all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoNull() {
		Sede s = new Sede(
		        "Sede di Sant'Agostino",
		        "Piazzale Sant'Agostino, 2",
		        null,
		        "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30",
		        "urlMaps"
	    );
		
		assertEquals("Foto non disponibile", s.getPathFoto());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo pathFoto diventi "Foto non disponibile"
	@Test
	public void testPathFotoVuoto() {
		Sede s = new Sede(
		        "Sede di Sant'Agostino",
		        "Piazzale Sant'Agostino, 2",
		        "  ",
		        "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30",
		        "urlMaps"
	    );
		
		assertEquals("Foto non disponibile", s.getPathFoto());
	}
	
	// Viene controllato che un valore null passato all'attributo orarioApertura diventi "Orario non specificato"
	@Test
	public void testOrarioAperturaNull() {
		Sede s = new Sede(
		        "Sede di Sant'Agostino",
		        "Piazzale Sant'Agostino, 2",
		        "/sedeCittaAlta.webp",
		        null,
		        "urlMaps"
	    );
		
		assertEquals("Orario non specificato", s.getOrarioApertura());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo orarioApertura diventi "Orario non specificato"
	@Test
	public void testOrarioAperturaVuoto() {
		Sede s = new Sede(
		        "Sede di Sant'Agostino",
		        "Piazzale Sant'Agostino, 2",
		        "/sedeCittaAlta.webp",
		        "  ",
		        "urlMaps"
	    );
		
		assertEquals("Orario non specificato", s.getOrarioApertura());
	}
	
	// Viene controllato che un valore null passato all'attributo pathMaps diventi "Mappa non disponibile"
	@Test
	public void testPathMapsNull() {
		Sede s = new Sede(
		        "Sede di Sant'Agostino",
		        "Piazzale Sant'Agostino, 2",
		        "/sedeCittaAlta.webp",
		        "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30",
		        null
	    );
		
		assertEquals("Mappa non disponibile", s.getPathMaps());
	}
	
	// Viene controllato che una stringa vuota passata all'attributo pathMaps diventi "Mappa non disponibile"
	@Test
	public void testPathMapsVuoto() {
		Sede s = new Sede(
		        "Sede di Sant'Agostino",
		        "Piazzale Sant'Agostino, 2",
		        "/sedeCittaAlta.webp",
		        "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30",
		        "  "
	    );
		
		assertEquals("Mappa non disponibile", s.getPathMaps());
	}
	
	// Viene verificato che tutti i controllo agiscano insieme
	@Test
	public void testValoriNonValidi() {
		Sede s = new Sede(
		        "  ",
		        null,
		        "    ",
		        null,
		        ""
	    );

	    assertEquals("Facoltà non specificata", s.getFacolta());
	    assertEquals("Indirizzo non disponibile", s.getIndirizzo());
	    assertEquals("Foto non disponibile", s.getPathFoto());
	    assertEquals("Orario non specificato", s.getOrarioApertura());
	    assertEquals("Mappa non disponibile", s.getPathMaps());
	}
	
}
