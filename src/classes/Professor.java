package classes;

import java.util.ArrayList;

import interfaces.IProfessor;

public class Professor extends Pessoa implements IProfessor{
	protected String formacaoProfissional;
	protected ArrayList<Turma> listaTurmaAndamento;
	
	public Professor() {
		super();
		listaTurmaAndamento = null;
	}
	
	public Professor(String nomePessoa, String cpfPessoa, String telefonePessoa, String enderecoPessoa,String formacaoProfissional, ArrayList<Turma> listaTurmaAndamento) {
		super(nomePessoa, cpfPessoa, telefonePessoa, enderecoPessoa);
		this.formacaoProfissional = formacaoProfissional;
		this.listaTurmaAndamento = listaTurmaAndamento;
	}
	public String getFormacaoProfissional() {
		return formacaoProfissional;
	}
	public void setFormacaoProfissional(String formacaoProfissional) {
		this.formacaoProfissional = formacaoProfissional;
	}
	public ArrayList<Turma> getListaTurmaAndamento() {
		return listaTurmaAndamento;
	}
	public void setListaTurmaAndamento(ArrayList<Turma> listaTurmaAndamento) {
		this.listaTurmaAndamento = listaTurmaAndamento;
	}
	
	@Override
	public boolean lancarAvaliacao() {
		// TODO Auto-generated method stub
		return false;
	}
}
