package interfaces;

import java.util.ArrayList;

import classes.Aluno;
import classes.Curso;
import classes.Diario;
import classes.GradeCurricular;
import classes.Materia;

public interface ISecretaria {
	public boolean cadastrarGradeCurricular(GradeCurricular objGradeCurricular);
	public ArrayList<Curso> listarCurso();
	public boolean editarCurso();
	public void cadastrarMateria();
	public ArrayList<Materia> listarMateria();
	public boolean editarMateria();
	public boolean cadastrarAluno();
	public ArrayList<Aluno> listarAluno();
	public boolean editarAluno();
	public boolean abrirTurma();
	public boolean matricularAlunoCurso();
	public boolean matricularAlunoTurma();
	public ArrayList<Diario> emitirDiario();	
}
