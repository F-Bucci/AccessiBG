
package Accessibilita.AccessiBG_Backend;

//import java.util.ArrayList;
//import java.util.List;

public class Sede {
	private String indirizzo;
	private String facolta;
	private String pathFoto;
	//private List<Edificio> edifici = new ArrayList<>();
	//private List<Parcheggio> parcheggi = new ArrayList<>();
	public Sede() {}
	
	public Sede(String facolta, String indirizzo, String pathFoto) {
		this.facolta = facolta;
		this.indirizzo = indirizzo;
    	this.pathFoto=pathFoto;
		
	}
	/*
	public void addEdificio(Edificio edificio) {
		this.edifici.add(edificio);
		edificio.setSede(this);
	}
	public void addParcheggio(Parcheggio p) {
        this.parcheggi.add(p);
        p.setSede(this);
    }*/
	
	public String getIndirizzo(){return indirizzo;}
	public void setIndirizzo(String indirizzo) {this.indirizzo = indirizzo;}
	
	public String getFacolta() {return facolta;}
	public void setFacolta(String facolta) {this.facolta = facolta;}
	
	public String getPathFoto() {return pathFoto;}
	public void setPathFoto(String pathFoto) {this.pathFoto = pathFoto;}
	
	/*public List<Edificio> getEdifici(){ return edifici;}
	public void setEdifici(List<Edificio> edifici) {this.edifici = edifici;}
	
	public List<Parcheggio> getParcheggi() { return parcheggi; }
    public void setParcheggi(List<Parcheggio> parcheggi) { this.parcheggi = parcheggi; }
    */
	
}
