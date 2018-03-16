package persistencia;

import java.util.ArrayList;

import classes.Aluno;
import classes.Materia;
import classes.Professor;
import classes.Turma;

public class DAO_Turma {

	String nomeArquivo;
	String delimitadorColuna;
	String delimitadorColuna2;
	
	public DAO_Turma() {
		this.delimitadorColuna = ";";
		this.delimitadorColuna = "@";
		this.nomeArquivo = "bancoTurmaDB.csv";
	}
	
	public ArrayList<Turma> lerTurmas(){
		//      0                1                 2                      3                           4                       5
		//int semestreTurma, int anoTurma, Materia materiaTurma, Professor professorTurma,ArrayList<Aluno> listaAluno, ArrayList<String> horarioDiaTurma
		ArrayList<Turma> listaTurmas = new ArrayList<>();
		try {
			LerEscreverArquivo leitura = new LerEscreverArquivo();
			ArrayList<String> linhasArquivo;
			linhasArquivo = leitura.lerArquivoEncriptado(nomeArquivo);
			if(linhasArquivo.size()>=1) {
				for(String linha:linhasArquivo) {
					String[] vetorColunas = linha.split(this.delimitadorColuna);
					Turma objTurma = new Turma(Integer.parseInt(vetorColunas[0]), Integer.parseInt(vetorColunas[1]), new Materia(), new Professor(), new ArrayList<Aluno>(), new ArrayList<String>());
					DAO_Materia daoMat = new DAO_Materia();
					objTurma.setMateriaTurma(daoMat.buscarMateriaCOD(Integer.parseInt(vetorColunas[2])));
					DAO_Professor daoProfessor = new DAO_Professor();
					objTurma.setProfessorTurma(daoProfessor.buscarProfessorCPF(vetorColunas[3]));
					String[] vetorColunas2 = vetorColunas[4].split(this.delimitadorColuna2);
					for(String alunos:vetorColunas2) {
						DAO_Aluno daoAluno = new DAO_Aluno();
						daoAluno.buscarAlunoCPF(alunos);
					}
					//objTurma.setListaAluno(listaAluno);
					listaTurmas.add(objTurma);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTurmas;
	}
}
