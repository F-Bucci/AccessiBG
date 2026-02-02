package struttura;

public class PuntoDiIngresso {
	private int id;
	private String nome;
	private boolean scale;
	private boolean rampe;
	private boolean portaTagliafuoco;
	private boolean percorsoStrisceIpov;
	private double x;
	private double y;
	private String pathFoto;
	private String pathPercorso; 
	private String edificio;
	
	public PuntoDiIngresso(int id, String nome,  boolean scale, boolean rampe, boolean portaTagliafuoco,
			boolean percorsoStrisceIpov, double x, double y, String pathFoto, String pathPercorso, String edificio) {
		this.id = id;
		this.nome = nome;
		this.scale = scale;
		this.rampe = rampe;
		this.portaTagliafuoco = portaTagliafuoco;
		this.percorsoStrisceIpov = percorsoStrisceIpov;
		this.x = x;
		this.y = y;
		this.pathFoto = pathFoto;
		this.pathPercorso = pathPercorso;
		this.edificio = edificio;
	}

	public boolean getPercorsoStrisceIpov() {return percorsoStrisceIpov;}
	
	public int getId() {return id;}

	public boolean getScale() {return scale;}

	public boolean getRampe() {return rampe;}

	public boolean getPortaTagliafuoco() {return portaTagliafuoco;}

	public String getEdificio() {return edificio;}
	
	public String getNome() {
		return nome;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public String getPathPercorso() {
		return pathPercorso;
	}

}
