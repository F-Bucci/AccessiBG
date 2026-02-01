
package struttura;

public class PuntoDiIngresso {

//	tipo ingresso scalini rampa 
	
	private String nome;
	private boolean accessibile;
	private String descrizione;
	private Edificio edificio;
	
	public void setEdificio(Edificio edificio) {
		this.edificio= edificio;
	}
	public PuntoDiIngresso() {}
	
	public PuntoDiIngresso(String nome, boolean accessibile) {
		this.nome = nome;
		this.accessibile = accessibile;
	}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public boolean IsAccessibile() {return accessibile;}
	public void setAccessibile(boolean accessibile) {this.accessibile = accessibile;}
	
	public String getDescrizione() {return descrizione;}
	public void setDescrizione(String descrizione) {this.descrizione = descrizione;}
}
