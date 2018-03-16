
package classes;

import java.util.ArrayList;

public class GradeCurricular {
	private String nomeGradeCurricular;
	private String cargaHorariaCurso;
	private String dataCriacaoGrade;
	private ArrayList<Materia> listaMateriaGrade;
	
	
	public GradeCurricular() {
		listaMateriaGrade = null;
		this.nomeGradeCurricular = "";
		this.cargaHorariaCurso = "";
		this.dataCriacaoGrade = "";
	}

	public GradeCurricular(String nomeGradeCurricular, String cargaHorariaCurso, String dataCriacaoGrade,
			ArrayList<Materia> listaMateriaGrade) {
		this.nomeGradeCurricular = nomeGradeCurricular;
		this.cargaHorariaCurso = cargaHorariaCurso;
		this.dataCriacaoGrade = dataCriacaoGrade;
		this.listaMateriaGrade = listaMateriaGrade;
	}
	
	public String getNomeGradeCurricular() {
		return nomeGradeCurricular;
	}
	public void setNomeGradeCurricular(String nomeGradeCurricular) {
		this.nomeGradeCurricular = nomeGradeCurricular;
	}
	public String getCargaHorariaCurso() {
		return cargaHorariaCurso;
	}
	public void setCargaHorariaCurso(String cargaHorariaCurso) {
		this.cargaHorariaCurso = cargaHorariaCurso;
	}
	public String getDataCriacaoGrade() {
		return dataCriacaoGrade;
	}
	public void setDataCriacaoGrade(String dataCriacaoGrade) {
		this.dataCriacaoGrade = dataCriacaoGrade;
	}
	public ArrayList<Materia> getListaMateriaGrade() {
		return listaMateriaGrade;
	}
	public void setListaMateriaGrade(ArrayList<Materia> listaMateriaGrade) {
		this.listaMateriaGrade = listaMateriaGrade;
	}
}
