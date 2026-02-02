
package struttura;

public class Sede {
	
	private String indirizzo;
	private String facolta;
	private String pathFoto;
	private String orarioApertura;
	private String pathMaps;
	
	public Sede(String facolta, String indirizzo, String pathFoto, String orarioApertura, String pathMaps) {
		this.facolta = (facolta == null || (facolta.isBlank())) ? "Facoltà non specificata" : facolta;
		this.indirizzo = (indirizzo == null || indirizzo.isBlank()) ? "Indirizzo non disponibile" : indirizzo;
    	this.pathFoto = (pathFoto == null || pathFoto.isBlank()) ? "Foto non disponibile" : pathFoto;
    	this.orarioApertura = (orarioApertura == null || orarioApertura.isBlank()) ? "Orario non specificato" : orarioApertura;
    	this.pathMaps = (pathMaps == null || pathMaps.isBlank()) ? "Mappa non disponibile" : pathMaps;
	}
	
	public String getIndirizzo(){return indirizzo;}
	
	public String getFacolta() {return facolta;}
	
	public String getPathFoto() {return pathFoto;}

	public String getOrarioApertura() {return orarioApertura;}

	public String getPathMaps() {return pathMaps;}
}
