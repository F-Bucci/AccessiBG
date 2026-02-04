package struttura;

/**
 * Rappresenta un edificio di una sede universitaria.
 * <p>
 * La classe contiene informazioni descrittive di un edificio,
 * come nome, indirizzo, orari di apertura, facoltà associata
 * e un'immagine rappresentativa.
 * </p>
 * <p>
 * Eventuali valori {@code null} o vuoti passati al costruttore
 * vengono automaticamente sostituiti con valori di default.
 * </p>
 */
public class Edificio {
	private String indirizzo;
	private String nome;
	private String orario;
	private String facolta;
	private String pathFoto;
	
	/**
     * Costruisce un oggetto {@code Edificio} inizializzando
     * tutti i suoi attributi.
     * <p>
     * I parametri testuali vengono normalizzati nel caso in cui
     * siano {@code null} o contengano solo spazi.
     * </p>
     *
     * @param nome nome dell'edificio
     * @param indirizzo indirizzo dell'edificio
     * @param orario orari di apertura dell'edificio
     * @param pathFoto immagine dell'edificio
     * @param facolta facoltà a cui appartiene l'edificio
     */
	public Edificio(String nome, String indirizzo, String orario, String pathFoto, String facolta) {
		this.indirizzo = (indirizzo == null || indirizzo.isBlank()) ? "Indirizzo non disponibile" : indirizzo;
		this.nome = (nome == null || nome.isBlank()) ? "Nome non specificato" : nome;
		this.orario = (orario == null || orario.isBlank()) ? "Orario non specificato" : orario;
		this.facolta = (facolta == null || facolta.isBlank()) ? "Facoltà non specificata" : facolta;
		this.pathFoto = (pathFoto == null || pathFoto.isBlank()) ? "Foto non disponibile" : pathFoto;
	}
				
	/**
     * Restituisce l'indirizzo dell'edificio.
     *
     * @return indirizzo dell'edificio
     */
	public String getIndirizzo() {return indirizzo;}
	
	/**
     * Restituisce il nome dell'edificio.
     *
     * @return nome dell'edificio
     */
	public String getNome() {return nome;}
	
	/**
     * Restituisce gli orari di apertura dell'edificio.
     *
     * @return orari dell'edificio
     */
	public String getOrario() {return orario;}
	
	/**
     * Restituisce la facoltà associata all'edificio.
     *
     * @return facoltà dell'edificio
     */
	public String getFacolta() {return facolta;}
	
	/**
     * Restituisce l'immagine dell'edificio.
     *
     * @return immagine dell'edificio
     */
	public String getPathFoto() {return pathFoto;}
}
