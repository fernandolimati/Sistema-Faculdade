package classes;

import java.util.ArrayList;

public class Turma {
	private int semestreTurma;
	private int anoTurma;
	private Materia materiaTurma;
	private Professor professorTurma;
	private ArrayList<Aluno> listaAluno;
	private ArrayList<String> horarioDiaTurma;
	
	public Turma() {
		listaAluno = null;
		horarioDiaTurma = null;
	}
	public Turma(int semestreTurma, int anoTurma, Materia materiaTurma, Professor professorTurma,
			ArrayList<Aluno> listaAluno, ArrayList<String> horarioDiaTurma) {
		this.semestreTurma = semestreTurma;
		this.anoTurma = anoTurma;
		this.materiaTurma = materiaTurma;
		this.professorTurma = professorTurma;
		this.listaAluno = listaAluno;
		this.horarioDiaTurma = horarioDiaTurma;
	}
	
	public int getSemestreTurma() {
		return semestreTurma;
	}
	public void setSemestreTurma(int semestreTurma) {
		this.semestreTurma = semestreTurma;
	}
	public int getAnoTurma() {
		return anoTurma;
	}
	public void setAnoTurma(int anoTurma) {
		this.anoTurma = anoTurma;
	}
	public Materia getMateriaTurma() {
		return materiaTurma;
	}
	public void setMateriaTurma(Materia materiaTurma) {
		this.materiaTurma = materiaTurma;
	}
	public Professor getProfessorTurma() {
		return professorTurma;
	}
	public void setProfessorTurma(Professor professorTurma) {
		this.professorTurma = professorTurma;
	}
	public ArrayList<Aluno> getListaAluno() {
		return listaAluno;
	}
	public void setListaAluno(ArrayList<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}
	public ArrayList<String> getHorarioDiaTurma() {
		return horarioDiaTurma;
	}
	public void setHorarioDiaTurma(ArrayList<String> horarioDiaTurma) {
		this.horarioDiaTurma = horarioDiaTurma;
	}
}
