package classes;

public class Materia {
	protected int codMateria;
	protected String nomeMateria;
	protected String descricaoMateria;
	protected int cargaHorariaMateria;
	
	public Materia() {
		this.codMateria = 0;
		this.nomeMateria = "";
		this.descricaoMateria = "";
		this.cargaHorariaMateria = 0;
	}
	public Materia(String nomeMateria, String descricaoMateria, int cargaHorariaMateria, int codMateria) {
		this.nomeMateria = nomeMateria;
		this.codMateria = codMateria;
		this.descricaoMateria = descricaoMateria;
		this.cargaHorariaMateria = cargaHorariaMateria;
	}

	public int getCodMateria() {
		return codMateria;
	}
	public void setCodMateria(int codMateria) {
		this.codMateria = codMateria;
	}
	public String getNomeMateria() {
		return nomeMateria;
	}
	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}
	public String getDescricaoMateria() {
		return descricaoMateria;
	}
	public void setDescricaoMateria(String descricaoMateria) {
		this.descricaoMateria = descricaoMateria;
	}
	public int getCargaHorariaMateria() {
		return cargaHorariaMateria;
	}
	public void setCargaHorariaMateria(int cargaHorariaMateria) {
		this.cargaHorariaMateria = cargaHorariaMateria;
	}

}
