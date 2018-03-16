package classes;

import java.util.ArrayList;

public class Curso {
	
	private int idCurso;
	private String nomeCurso;
	private String matriculaCurso;
	private String dataMatriculaCurso;
	private String statusCurso;
	private GradeCurricular gradeCurricular;
	private ArrayList<MateriaCursada> listaMateriaCursada;
	private ArrayList<MateriaCursada> listaMateriaCursando;
	
	public Curso() {
		this.idCurso = -1;
		listaMateriaCursada = null;
		listaMateriaCursando = null;
	}
	public Curso(int idCurso,String nomeCurso, String matriculaCurso, String dataMatriculaCurso, String statusCurso,
			GradeCurricular gradeCurricular, ArrayList<MateriaCursada> listaMateriaCursada,
			ArrayList<MateriaCursada> listaMateriaCursando) {
		this.nomeCurso = nomeCurso;
		this.matriculaCurso = matriculaCurso;
		this.dataMatriculaCurso = dataMatriculaCurso;
		this.statusCurso = statusCurso;
		this.gradeCurricular = gradeCurricular;
		this.listaMateriaCursada = listaMateriaCursada;
		this.listaMateriaCursando = listaMateriaCursando;
		this.idCurso = idCurso;
	}
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getMatriculaCurso() {
		return matriculaCurso;
	}
	public void setMatriculaCurso(String matriculaCurso) {
		this.matriculaCurso = matriculaCurso;
	}
	public String getDataMatriculaCurso() {
		return dataMatriculaCurso;
	}
	public void setDataMatriculaCurso(String dataMatriculaCurso) {
		this.dataMatriculaCurso = dataMatriculaCurso;
	}
	public String getStatusCurso() {
		return statusCurso;
	}
	public void setStatusCurso(String statusCurso) {
		this.statusCurso = statusCurso;
	}
	public GradeCurricular getGradeCurricular() {
		return gradeCurricular;
	}
	public void setGradeCurricular(GradeCurricular gradeCurricular) {
		this.gradeCurricular = gradeCurricular;
	}
	public ArrayList<MateriaCursada> getListaMateriaCursada() {
		return listaMateriaCursada;
	}
	public void setListaMateriaCursada(ArrayList<MateriaCursada> listaMateriaCursada) {
		this.listaMateriaCursada = listaMateriaCursada;
	}
	public ArrayList<MateriaCursada> getListaMateriaCursando() {
		return listaMateriaCursando;
	}
	public void setListaMateriaCursando(ArrayList<MateriaCursada> listaMateriaCursando) {
		this.listaMateriaCursando = listaMateriaCursando;
	}
}
