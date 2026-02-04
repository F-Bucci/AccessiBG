package struttura;

/**
 * Rappresenta un punto di ingresso di un edificio.
 * <p>
 * Un punto di ingresso può essere dotato di scale, rampe,
 * porte tagliafuoco e percorsi con strisce per ipovedenti.
 * Include inoltre informazioni e immagini.
 * </p>
 * <p>
 * I campi testuali vengono normalizzati nel costruttore
 * se {@code null} o vuoti.
 * </p>
 */
public class PuntoDiIngresso {
	private int id;
	private String nome;
	private String descrizione;
	private boolean scale;
	private boolean rampe;
	private boolean portaTagliafuoco;
	private boolean percorsoStrisceIpov;
	private double x;
	private double y;
	private String pathFoto;
	private String pathPercorso; 
	private String edificio;
	
	/**
     * Costruisce un oggetto {@code PuntoDiIngresso} inizializzando
     * tutte le sue proprietà.
     * <p>
     * I campi testuali vengono valorizzati con valori di default
     * se {@code null} o vuoti.
     * </p>
     *
     * @param id identificativo del punto di ingresso
     * @param nome nome del punto di ingresso
     * @param descrizione descrizione del punto di ingresso
     * @param scale indica la presenza di scale
     * @param rampe indica la presenza di rampe
     * @param portaTagliafuoco indica la presenza di una porta tagliafuoco
     * @param percorsoStrisceIpov indica la presenza di percorsi con strisce per ipovedenti
     * @param x coordinata X del punto di ingresso
     * @param y coordinata Y del punto di ingresso
     * @param pathFoto immagine del punto di ingresso
     * @param pathPercorso percorso associato al punto di ingresso
     * @param edificio nome dell'edificio di appartenenza
     */
	public PuntoDiIngresso(int id, String nome, String descrizione,  boolean scale, boolean rampe, boolean portaTagliafuoco,
			boolean percorsoStrisceIpov, double x, double y, String pathFoto, String pathPercorso, String edificio) {
		this.id = id; // id può essere qualsiasi valore, validato altrove
		this.nome = (nome == null || nome.isBlank()) ? "Nome non specificato" : nome;
		this.descrizione = (descrizione == null || descrizione.isBlank()) ? "Descrizione non presente" : descrizione;
		this.scale = scale;
		this.rampe = rampe;
		this.portaTagliafuoco = portaTagliafuoco;
		this.percorsoStrisceIpov = percorsoStrisceIpov;
		this.x = x; // coordinata x può essere qualsiasi valore, validato altrove
		this.y = y; // coordinata y può essere qualsiasi valore, validato altrove
		this.pathFoto = (pathFoto == null || pathFoto.isBlank()) ? "Foto non disponibile" : pathFoto;
		// TODO: rimuovere quando la gestione dei percorsi sarà stabile
		// Forziamo null per evitare crash lato UI / DAO
		this.pathPercorso = null;
		this.edificio = (edificio == null || edificio.isBlank()) ? "Edificio non specificato" : edificio;
	}

	/**
     * Indica se è presente un percorso con strisce per ipovedenti.
     *
     * @return {@code true} se presente, {@code false} altrimenti
     */
	public boolean getPercorsoStrisceIpov() {return percorsoStrisceIpov;}
	
	/**
     * Restituisce l'identificativo del punto di ingresso.
     *
     * @return id del punto di ingresso
     */
	public int getId() {return id;}

	/**
     * Indica la presenza di scale.
     *
     * @return {@code true} se presenti, {@code false} altrimenti
     */
	public boolean getScale() {return scale;}

	/**
     * Indica la presenza di rampe.
     *
     * @return {@code true} se presenti, {@code false} altrimenti
     */
	public boolean getRampe() {return rampe;}

	/**
     * Indica la presenza di una porta tagliafuoco.
     *
     * @return {@code true} se presente, {@code false} altrimenti
     */
	public boolean getPortaTagliafuoco() {return portaTagliafuoco;}

	/**
     * Restituisce il nome dell'edificio di appartenenza.
     *
     * @return nome dell'edificio
     */
	public String getEdificio() {return edificio;}
	
	/**
     * Restituisce il nome del punto di ingresso.
     *
     * @return nome del punto di ingresso
     */
	public String getNome() {return nome;}
	
	/**
     * Restituisce la descrizione del punto di ingresso.
     *
     * @return descrizione del punto di ingresso
     */
	public String getDescrizione() {return descrizione;}

	/**
     * Restituisce la coordinata X del punto di ingresso.
     *
     * @return coordinata X
     */
	public double getX() {return x;}

	/**
     * Restituisce la coordinata Y del punto di ingresso.
     *
     * @return coordinata Y
     */
	public double getY() {return y;}

	/**
     * Restituisce l'immagine del punto di ingresso
     *
     * @return immagine del punto di ingresso
     */
	public String getPathFoto() {return pathFoto;}

	/**
     * Restituisce il percorso associato al punto di ingresso.
     * <p>
     * Attualmente restituisce {@code null} per evitare
     * problemi di stabilità lato UI e DAO.
     * </p>
     *
     * @return {@code null}
     */
	public String getPathPercorso() {return pathPercorso;}

}
