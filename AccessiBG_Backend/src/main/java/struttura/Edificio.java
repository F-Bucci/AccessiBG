
package struttura;

import java.util.ArrayList;
import java.util.List;

public class Edificio {
	private String indirizzo;
	private String nome;
	private String orario;
	private List<PuntoDiIngresso> pIngresso = new ArrayList<>();
	private List<Piano> piani = new ArrayList<>();
				
	private Sede sede;
				
	public Edificio() {}
	public Edificio(String nome) {
	this.nome= nome;
	
	}
	
	public void addPiano(Piano pi) {
		this.piani.add(pi);
		pi.setEdificio(this);
	}
				
	public void addPuntoDiIngresso(PuntoDiIngresso p) {
		this.pIngresso.add(p);
		p.setEdificio(this);
	}
	
	public List<Piano> getPiano() {return piani;}
	public void getPiano(List<Piano> piani) {this.piani = piani;}
	
	public String getIndirizzo() {return indirizzo;}
	public void setIndirizzo(String indirizzo) {this.indirizzo = indirizzo;}
				
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
				
	public String getOrario() {return orario;}
	public void setOrario(String orario) {this.orario = orario;}
				
	public Sede getSede() {return sede;}
	public void setSede(Sede sede) {this.sede = sede;}
				
	public List<PuntoDiIngresso> getPuntiDiAccesso(){return pIngresso;}
	public void setPuntiDiAccesso(List<PuntoDiIngresso> puntiDiAccesso) {
		this.pIngresso = puntiDiAccesso;
		}
}

