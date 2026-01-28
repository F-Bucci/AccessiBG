
package struttura;

public class Sede {
	private String indirizzo;
	private String facolta;
	private String pathFoto;
	private String orarioApertura;
	private String pathMaps;

	public Sede() {}
	
	public Sede(String facolta, String indirizzo, String pathFoto, String orarioApertura, String pathmaps) {
		this.facolta = facolta;
		this.indirizzo = indirizzo;
    	this.pathFoto=pathFoto;
    	this.orarioApertura=orarioApertura;
    	this.pathMaps=pathmaps;
	}
	
	public String getIndirizzo(){return indirizzo;}
	//public void setIndirizzo(String indirizzo) {this.indirizzo = indirizzo;}
	
	public String getFacolta() {return facolta;}
	//public void setFacolta(String facolta) {this.facolta = facolta;}
	
	public String getPathFoto() {return pathFoto;}
	//public void setPathFoto(String pathFoto) {this.pathFoto = pathFoto;}

	public String getOrarioApertura() {return orarioApertura;}

	public String getPathMaps() {return pathMaps;}
}
