package citta;

public class CittaMediaVar {

	private String nome;
	private float mediaVento;
	private float varianzaVento;
	private float mediaVisibilita;
	private float varianzaVisiblita;
	
	public CittaMediaVar() {}
	
	public CittaMediaVar(String nome, float mediaVento, float varianzaVento, float mediaVisibilita, float varianzaVisibilita) {
		this.nome = nome;
		this.mediaVento = mediaVento;
		this.varianzaVento = varianzaVento;
		this.mediaVisibilita = mediaVisibilita;
		this.varianzaVisiblita = varianzaVisibilita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getMediaVento() {
		return mediaVento;
	}

	public void setMediaVento(float mediaVento) {
		this.mediaVento = mediaVento;
	}

	public float getVarianzaVento() {
		return varianzaVento;
	}

	public void setVarianzaVento(float varianzaVento) {
		this.varianzaVento = varianzaVento;
	}

	public float getMediaVisibilita() {
		return mediaVisibilita;
	}

	public void setMediaVisibilita(float mediaVisibilita) {
		this.mediaVisibilita = mediaVisibilita;
	}

	public float getVarianzaVisibilita() {
		return varianzaVisiblita;
	}

	public void setVarianzaVisibilita(float varianzaVisiblita) {
		this.varianzaVisiblita = varianzaVisiblita;
	}
	
	
	
}
