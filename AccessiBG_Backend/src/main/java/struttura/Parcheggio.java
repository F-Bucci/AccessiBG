package struttura;

/**
 * Rappresenta un parcheggio associato a una sede.
 * <p>
 * Un parcheggio può essere di diverso tipo (es. libero, a pagamento)
 * e può o meno disporre di posti riservati ai disabili.
 * </p>
 * <p>
 * I campi testuali vengono normalizzati nel costruttore
 * nel caso in cui siano {@code null} o vuoti.
 * </p>
 */
public class Parcheggio {

	private String nome;
	private TipoParcheggio tipo;
	private boolean postiDisabili;
	private String indirizzo;
	private String facolta;
	private String pathFoto;
	
	/**
     * Costruisce un oggetto {@code Parcheggio} inizializzando
     * tutti i suoi attributi.
     * <p>
     * I campi testuali vengono valorizzati con valori di default
     * se {@code null} o vuoti.
     * </p>
     *
     * @param nome nome del parcheggio
     * @param tipo tipologia del parcheggio
     * @param postiDisabili indica se sono presenti posti per disabili
     * @param indirizzo indirizzo del parcheggio
     * @param pathFoto immagine del parcheggio
     * @param facolta facoltà associata al parcheggio
     */
	public Parcheggio(String nome, TipoParcheggio tipo, boolean postiDisabili, String indirizzo, String pathFoto, String facolta) {
        this.nome = (nome == null || nome.isBlank()) ? "Nome non specificato" : nome;
        this.tipo = (tipo == null) ? TipoParcheggio.LIBERO : tipo;
        this.postiDisabili = postiDisabili;
        this.indirizzo = (indirizzo == null || indirizzo.isBlank()) ? "Indirizzo non disponibile" : indirizzo;
        this.facolta = (facolta == null || facolta.isBlank()) ? "Facoltà non specificata" : facolta;
        this.pathFoto = (pathFoto == null || pathFoto.isBlank()) ? "Foto non disponibile" : pathFoto;
    }
	
	/**
     * Indica se il parcheggio dispone di posti riservati ai disabili.
     *
     * @return {@code true} se sono presenti posti per disabili,
     *         {@code false} altrimenti
     */
	public boolean getPostiDisabili() { return postiDisabili; }
	
	/**
     * Restituisce la tipologia del parcheggio.
     *
     * @return tipo del parcheggio
     */
    public TipoParcheggio getTipo() {return tipo;}
    
    /**
     * Restituisce il nome del parcheggio.
     *
     * @return nome del parcheggio
     */
    public String getNome() { return nome; }
    
    /**
     * Restituisce l'indirizzo del parcheggio.
     *
     * @return indirizzo del parcheggio
     */
    public String getIndirizzo() { return indirizzo; }

    /**
     * Restituisce la facoltà associata al parcheggio.
     *
     * @return facoltà del parcheggio
     */
	public String getFacolta() {return facolta;}
	
	/**
     * Restituisce l'immagine del parcheggio
     *
     * @return immagine del parcheggio
     */
	public String getPathFoto() {return pathFoto;}
}
