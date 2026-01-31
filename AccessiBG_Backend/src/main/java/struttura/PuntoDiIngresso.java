
package struttura;

public class PuntoDiIngresso {
	private int id;
	private boolean scale;
	private boolean rampe;
	private boolean portaTagliafuoco;
	private boolean percorsoStrisceIpov;
	private String edificio;

	public PuntoDiIngresso(int id, boolean scale, boolean rampe, boolean portaTagliafuoco, boolean percorsoStrisceIpov, String edificio) {
		this.id=id;
		this.scale=scale;
		this.rampe=rampe;
		this.portaTagliafuoco=portaTagliafuoco;
		this.percorsoStrisceIpov=percorsoStrisceIpov;
		this.edificio = edificio;
	}

	public boolean getPercorsoStrisceIpov() {return percorsoStrisceIpov;}
	
	public int getId() {return id;}

	public boolean getScale() {
		return scale;
	}

	public boolean getRampe() {
		return rampe;
	}

	public boolean getPortaTagliafuoco() {
		return portaTagliafuoco;
	}

	public String getEdificio() {
		return edificio;
	}
}
