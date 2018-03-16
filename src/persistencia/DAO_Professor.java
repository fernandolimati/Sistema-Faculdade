package persistencia;

import java.util.ArrayList;

import classes.Professor;
import classes.Turma;

public class DAO_Professor {
	String nomeArquivo;
	String delimitadorColuna;
	
	public DAO_Professor() {
		this.delimitadorColuna = ";";
		this.nomeArquivo = "bancoProfessorDB.csv";
	}
	
	public ArrayList<Professor> lerProfessor(){
		//String nomePessoa, String cpfPessoa, String telefonePessoa, String enderecoPessoa,String formacaoProfissional, ArrayList<Turma> listaTurmaAndamento
		ArrayList<Professor> listaProfessor = new ArrayList<>();
		try {
			LerEscreverArquivo leitura = new LerEscreverArquivo();
			ArrayList<String> linhasArquivo;
			linhasArquivo = leitura.lerArquivoEncriptado(nomeArquivo);
			if(linhasArquivo.size()>=1) {
				for(String linha:linhasArquivo) {
					String[] vetorColunas = linha.split(this.delimitadorColuna);
					listaProfessor.add(new Professor(vetorColunas[0], vetorColunas[1], vetorColunas[2], vetorColunas[3], vetorColunas[4], new ArrayList<Turma>()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProfessor;
	}

	public Professor buscarProfessorCPF(String cpf) {
		ArrayList<Professor> listaMateria = lerProfessor();
		for(Professor prof:listaMateria) {
			if(prof.getCpfPessoa() == cpf)
				return prof;
		}
		return null;
	}
}
