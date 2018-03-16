package classes;

public class MateriaCursada extends Materia{
	private float frequenciaMateriaCursada;
	private float nota1MateriaCursada;
	private float nota2MateriaCursada;
	private float nota3MateriaCursada;
	private float mediaMateriaCursada;
	
	public MateriaCursada() {}
	
	public MateriaCursada(float frequenciaMateriaCursada, float nota1MateriaCursada, float nota2MateriaCursada,
			float nota3MateriaCursada, float mediaMateriaCursada) {
		this.frequenciaMateriaCursada = frequenciaMateriaCursada;
		this.nota1MateriaCursada = nota1MateriaCursada;
		this.nota2MateriaCursada = nota2MateriaCursada;
		this.nota3MateriaCursada = nota3MateriaCursada;
		this.mediaMateriaCursada = mediaMateriaCursada;
	}
	
	public float getFrequenciaMateriaCursada() {
		return frequenciaMateriaCursada;
	}
	public void setFrequenciaMateriaCursada(float frequenciaMateriaCursada) {
		this.frequenciaMateriaCursada = frequenciaMateriaCursada;
	}
	public float getNota1MateriaCursada() {
		return nota1MateriaCursada;
	}
	public void setNota1MateriaCursada(float nota1MateriaCursada) {
		this.nota1MateriaCursada = nota1MateriaCursada;
	}
	public float getNota2MateriaCursada() {
		return nota2MateriaCursada;
	}
	public void setNota2MateriaCursada(float nota2MateriaCursada) {
		this.nota2MateriaCursada = nota2MateriaCursada;
	}
	public float getNota3MateriaCursada() {
		return nota3MateriaCursada;
	}
	public void setNota3MateriaCursada(float nota3MateriaCursada) {
		this.nota3MateriaCursada = nota3MateriaCursada;
	}
	public float getMediaMateriaCursada() {
		return mediaMateriaCursada;
	}
	public void setMediaMateriaCursada(float mediaMateriaCursada) {
		this.mediaMateriaCursada = mediaMateriaCursada;
	}
}
