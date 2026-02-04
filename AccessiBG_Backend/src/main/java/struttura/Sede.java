package struttura;

/**
 * Rappresenta una sede universitaria di Bergamo.
 * <p>
 * Contiene informazioni descrittive e logistiche quali
 * facoltà di appartenenza, indirizzo, orari di apertura
 * e immagini.
 * </p>
 * <p>
 * Tutti i campi testuali vengono normalizzati nel costruttore
 * in caso di valori {@code null} o stringhe vuote.
 * </p>
 */
public class Sede {
	
	private String indirizzo;
	private String facolta;
	private String pathFoto;
	private String orarioApertura;
	private String pathMaps;
	
	/**
     * Costruisce un oggetto {@code Sede} inizializzando
     * tutti i suoi attributi.
     * <p>
     * Se uno o più parametri testuali risultano {@code null}
     * o vuoti, vengono sostituiti con valori di default
     * per garantire la stabilità dell'applicazione.
     * </p>
     *
     * @param facolta facoltà associata alla sede
     * @param indirizzo indirizzo fisico della sede
     * @param pathFoto immagine della sede
     * @param orarioApertura orario di apertura della sede
     * @param pathMaps riferimento alla mappa
     */
	public Sede(String facolta, String indirizzo, String pathFoto, String orarioApertura, String pathMaps) {
		this.facolta = (facolta == null || (facolta.isBlank())) ? "Facoltà non specificata" : facolta;
		this.indirizzo = (indirizzo == null || indirizzo.isBlank()) ? "Indirizzo non disponibile" : indirizzo;
    	this.pathFoto = (pathFoto == null || pathFoto.isBlank()) ? "Foto non disponibile" : pathFoto;
    	this.orarioApertura = (orarioApertura == null || orarioApertura.isBlank()) ? "Orario non specificato" : orarioApertura;
    	this.pathMaps = (pathMaps == null || pathMaps.isBlank()) ? "Mappa non disponibile" : pathMaps;
	}
	
	/**
     * Restituisce l'indirizzo della sede.
     *
     * @return indirizzo della sede
     */
	public String getIndirizzo(){return indirizzo;}
	
	/**
     * Restituisce la facoltà associata alla sede.
     *
     * @return facoltà della sede
     */
	public String getFacolta() {return facolta;}
	
	/**
     * Restituisce un'immagine della sede.
     *
     * @return immagine della sede
     */
	public String getPathFoto() {return pathFoto;}

	/**
     * Restituisce l'orario di apertura della sede.
     *
     * @return orario di apertura
     */
	public String getOrarioApertura() {return orarioApertura;}

	/**
     * Restituisce il riferimento alla mappa della sede.
     *
     * @return riferimento alla mappa
     */
	public String getPathMaps() {return pathMaps;}
}
