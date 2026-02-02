
package struttura;

public class Edificio {
	private String indirizzo;
	private String nome;
	private String orario;
	private String facolta;
	private String pathFoto;
	
	public Edificio(String nome, String indirizzo, String orario, String pathFoto, String facolta) {
		this.indirizzo = indirizzo;
		this.nome = nome;
		this.orario = orario;
		this.facolta = facolta;
		this.pathFoto = pathFoto;
	}
				
	public String getIndirizzo() {return indirizzo;}
				
	public String getNome() {return nome;}
				
	public String getOrario() {return orario;}
	
	public String getFacolta() {return facolta;}
	
	public String getPathFoto() {return pathFoto;}
}
