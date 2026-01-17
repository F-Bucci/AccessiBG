package Accessibilita.AccessiBG_sqlite;

public class Sede {
	private String facolta;
    private String indirizzo;
    private String pathFoto;
    
    public Sede(String facolta, String indirizzo, String pathFoto) {
    	this.facolta = facolta;
    	this.indirizzo = indirizzo;
    	this.pathFoto=pathFoto;
    	}
    
    public String getFacolta() {
    	return facolta;
    }
    public String getIndirizzo() {
    	return indirizzo;
    }
	public String getPathFoto() {
		return pathFoto;
	}
	
}
