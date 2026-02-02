package struttura;

public class Piano {

	private int numero;
	private String descrizione;
	private String pathFoto;
	private String edificio;
	
	public Piano(int numero, String descrizione, String pathFoto, String edificio) {
		this.numero = (numero < -1) ? -1 : numero;
		this.descrizione = (descrizione == null || descrizione.isBlank()) ? "Descrizione non presente" : descrizione;
		this.pathFoto=pathFoto;
		this.edificio = (edificio == null || edificio.isBlank()) ? "Edificio non specificato" : edificio;
	}
	
	public int getNumero() { return numero; }

    public String getDescrizione() { return descrizione; }

	public String getEdificio() {
		return edificio;
	}

	public String getPathFoto() {
		return pathFoto;
	}
}
