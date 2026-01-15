
package struttura;

import java.util.ArrayList;
import java.util.List;

public class Sede {
	private String indirizzo;
	private String facolta;
	private String nome;
	private List<Edificio> edifici = new ArrayList<>();
	private List<Parcheggio> parcheggi = new ArrayList<>();
	public Sede() {}
	
	public Sede(String nome) {
		this.nome = nome;
	}
	
	public void addEdificio(Edificio edificio) {
		this.edifici.add(edificio);
		edificio.setSede(this);
	}
	public void addParcheggio(Parcheggio p) {
        this.parcheggi.add(p);
        p.setSede(this);
    }
	
	public String getIndirizzo(){return indirizzo;}
	public void setIndirizzo(String indirizzo) {this.indirizzo = indirizzo;}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String getFacolta() {return facolta;}
	public void setFacolta(String facolta) {this.facolta = facolta;}
	
	public List<Edificio> getEdifici(){ return edifici;}
	public void setEdifici(List<Edificio> edifici) {this.edifici = edifici;}
	
	public List<Parcheggio> getParcheggi() { return parcheggi; }
    public void setParcheggi(List<Parcheggio> parcheggi) { this.parcheggi = parcheggi; }
	
}
