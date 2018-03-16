package classes;

import java.util.ArrayList;

import interfaces.ISecretaria;

public class Secretaria extends Pessoa implements ISecretaria {

	public Secretaria() {super();}
	public Secretaria(String nomePessoa, String cpfPessoa, String telefonePessoa, String enderecoPessoa) {super(nomePessoa, cpfPessoa, telefonePessoa, enderecoPessoa);}

	//private String nomeGradeCurricular;
	//private int cargaHorariaCurso;
	//private int dataCriacaoGrade;
	//private ArrayList<Materia> listaMateriaGrade;

	
	@Override
	public boolean cadastrarGradeCurricular(GradeCurricular objGradeCurricular){
		
		return true;
	}

	@Override
	public ArrayList<Curso> listarCurso() {
		return null;
	}

	@Override
	public boolean editarCurso() {
		return false;
	}

	@Override
	public void cadastrarMateria() {

	}

	@Override
	public ArrayList<Materia> listarMateria() {
		return null;
	}

	@Override
	public boolean editarMateria() {
		return false;
	}

	@Override
	public boolean cadastrarAluno() {
		return false;
	}

	@Override
	public ArrayList<Aluno> listarAluno() {
		return null;
	}

	@Override
	public boolean editarAluno() {
		return false;
	}

	@Override
	public boolean abrirTurma() {
		return false;
	}

	@Override
	public boolean matricularAlunoCurso() {
		return false;
	}

	@Override
	public boolean matricularAlunoTurma() {
		return false;
	}

	@Override
	public ArrayList<Diario> emitirDiario() {
		return null;
	}

}
