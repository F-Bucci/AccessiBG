package struttura;

/**
 * Rappresenta un piano di un edificio.
 * <p>
 * Ogni piano è identificato da un numero e può avere una descrizione,
 * un'immagine associata e il riferimento all'edificio di appartenenza.
 * </p>
 * <p>
 * I campi testuali vengono normalizzati nel costruttore nel caso
 * in cui siano {@code null} o vuoti.
 * </p>
 */
public class Piano {

	private int numero;
	private String descrizione;
	private String pathFoto;
	private String edificio;
	
	/**
     * Costruisce un oggetto {@code Piano} inizializzando tutti i suoi attributi.
     * <p>
     * I campi testuali vengono valorizzati con valori di default
     * se {@code null} o vuoti.
     * </p>
     *
     * @param numero numero del piano
     * @param descrizione descrizione del piano
     * @param pathFoto immagine del piano
     * @param edificio nome dell'edificio a cui appartiene il piano
     */
	public Piano(int numero, String descrizione, String pathFoto, String edificio) {
		this.numero = numero; // numero del piano può essere qualsiasi valore, validato altrove
		this.descrizione = (descrizione == null || descrizione.isBlank()) ? "Descrizione non presente" : descrizione;
		this.pathFoto = (pathFoto == null || pathFoto.isBlank()) ? "Foto non disponibile" : pathFoto;
		this.edificio = (edificio == null || edificio.isBlank()) ? "Edificio non specificato" : edificio;
	}
	
	/**
     * Restituisce il numero del piano.
     *
     * @return numero del piano
     */
	public int getNumero() { return numero; }

	/**
     * Restituisce la descrizione del piano.
     *
     * @return descrizione del piano
     */
    public String getDescrizione() { return descrizione; }

    /**
     * Restituisce il nome dell'edificio a cui appartiene il piano.
     *
     * @return nome dell'edificio
     */
	public String getEdificio() {
		return edificio;
	}

	/**
     * Restituisce l'immagine del piano
     *
     * @return immagine del piano
     */
	public String getPathFoto() {
		return pathFoto;
	}
}
