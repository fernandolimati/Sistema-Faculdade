package classes;

import java.util.ArrayList;

import interfaces.IAluno;

public class Aluno extends Pessoa implements IAluno{
	
	private String formado;
	private String dataCadastro;
	private String statusAluno;
	private ArrayList<Curso> listaCurso;
	
	public Aluno() {
		super();
		this.formado = "";
		this.listaCurso = null;
		this.dataCadastro = "";
		this.statusAluno = "";
	}
	public Aluno(String formado, String dataCadastro, String statusAluno, ArrayList<Curso> listaCurso) {
		super();
		this.formado = formado;
		this.dataCadastro = dataCadastro;
		this.statusAluno = statusAluno;
		this.listaCurso = listaCurso;
	}
	public Aluno(String nomePessoa, String cpfPessoa, String telefonePessoa, String enderecoPessoa, String dataCadastro, String statusAluno , String formado, ArrayList<Curso> listaCurso) {
		super(nomePessoa, cpfPessoa, telefonePessoa, enderecoPessoa);
		this.dataCadastro = dataCadastro;
		this.formado = formado;
		this.statusAluno = statusAluno;
		this.listaCurso = listaCurso;
	}
	
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getStatusAluno() {
		return statusAluno;
	}
	public void setStatusAluno(String statusAluno) {
		this.statusAluno = statusAluno;
	}
	public ArrayList<Curso> getListaCurso() {
		return listaCurso;
	}
	public void setListaCurso(ArrayList<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}
	public String getFormado() {
		return formado;
	}
	public void setFormado(String formado) {
		this.formado = formado;
	}
	@Override
	public boolean consultarAvaliacao() {
		// TODO Auto-generated method stub
		return false;
	}
}
