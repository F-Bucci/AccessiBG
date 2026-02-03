
package struttura;

public class Edificio {
	private String indirizzo;
	private String nome;
	private String orario;
	private String facolta;
	private String pathFoto;
	
	public Edificio(String nome, String indirizzo, String orario, String pathFoto, String facolta) {
		this.indirizzo = (indirizzo == null || indirizzo.isBlank()) ? "Indirizzo non disponibile" : indirizzo;
		this.nome = (nome == null || nome.isBlank()) ? "Nome non specificato" : nome;
		this.orario = (orario == null || orario.isBlank()) ? "Orario non specificato" : orario;
		this.facolta = (facolta == null || facolta.isBlank()) ? "Facoltà non specificata" : facolta;
		this.pathFoto = (pathFoto == null || pathFoto.isBlank()) ? "Foto non disponibile" : pathFoto;
	}
				
	public String getIndirizzo() {return indirizzo;}
				
	public String getNome() {return nome;}
				
	public String getOrario() {return orario;}
	
	public String getFacolta() {return facolta;}
	
	public String getPathFoto() {return pathFoto;}
}
