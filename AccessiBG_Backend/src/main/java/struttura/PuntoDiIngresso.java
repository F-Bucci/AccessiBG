package struttura;

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

	public boolean getPercorsoStrisceIpov() {return percorsoStrisceIpov;}
	
	public int getId() {return id;}

	public boolean getScale() {return scale;}

	public boolean getRampe() {return rampe;}

	public boolean getPortaTagliafuoco() {return portaTagliafuoco;}

	public String getEdificio() {return edificio;}
	
	public String getNome() {return nome;}
	
	public String getDescrizione() {return descrizione;}

	public double getX() {return x;}

	public double getY() {return y;}

	public String getPathFoto() {return pathFoto;}

	public String getPathPercorso() {return pathPercorso;}

}
