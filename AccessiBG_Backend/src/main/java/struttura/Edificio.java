
package struttura;

import java.util.ArrayList;
import java.util.List;

public class Edificio {
	private String indirizzo;
	private String nome;
	private String orario;
	private String facolta;
	private String pathFoto;
	private List<PuntoDiIngresso> pIngresso = new ArrayList<>();
	
	public Edificio(String nome, String indirizzo, String orario, String pathFoto, String facolta) {
		this.indirizzo = (indirizzo == null || indirizzo.isBlank()) ? "Indirizzo non disponibile" : indirizzo;
		this.nome = (nome == null || nome.isBlank()) ? "Nome non specificato" : nome;
		this.orario = (orario == null || orario.isBlank()) ? "Orario non specificato" : orario;
		this.facolta = (facolta == null || facolta.isBlank()) ? "Facoltà non specificata" : facolta;
		this.pathFoto = (pathFoto == null || pathFoto.isBlank()) ? "Foto non disponibile" : pathFoto;
	}
				
	public String getIndirizzo() {return indirizzo;}
    // public void setIndirizzo(String indirizzo) {this.indirizzo = indirizzo;}
				
	public String getNome() {return nome;}
    // public void setNome(String nome) {this.nome = nome;}
				
	public String getOrario() {return orario;}
    // public void setOrario(String orario) {this.orario = orario;}
	
	public String getFacolta() {return facolta;}
	
	public String getPathFoto() {return pathFoto;}
				
	public List<PuntoDiIngresso> getPuntiDiAccesso(){return pIngresso;}
	
	/*
	public void setPuntiDiAccesso(List<PuntoDiIngresso> puntiDiAccesso) {
		this.pIngresso = puntiDiAccesso;
	}
	*/
	
	/*
	public void addPuntoDiIngresso(PuntoDiIngresso p) {
		if (p == null) {
	        return;
	    }
	    this.pIngresso.add(p);
	    p.setEdificio(this);
	}	
	*/
}

