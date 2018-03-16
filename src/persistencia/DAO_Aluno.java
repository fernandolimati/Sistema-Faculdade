package persistencia;

import java.util.ArrayList;

import classes.Aluno;
import classes.Curso;

public class DAO_Aluno {
	
	String nomeArquivo;
	String delimitadorColuna;
	
	public DAO_Aluno() {
		this.delimitadorColuna = ";";
		this.nomeArquivo = "bancoAlunoDB.csv";
	}
	
	public ArrayList<Aluno> lerAlunos(){
		//nomePessoa ; cpfPessoa ; telefonePessoa ; enderecoPessoa ; dataCadastro ; statusAluno ; Formado ; listaCurso
		ArrayList<Aluno> listaAlunos = new ArrayList<>();
		try {
			LerEscreverArquivo leitura = new LerEscreverArquivo();
			ArrayList<String> linhasArquivo;
			linhasArquivo = leitura.lerArquivoEncriptado(nomeArquivo);
			if(linhasArquivo.size()>=1) {
				for(String linha:linhasArquivo) {
					String[] vetorColunas = linha.split(this.delimitadorColuna);
					listaAlunos.add(new Aluno(vetorColunas[0], vetorColunas[1], vetorColunas[2], vetorColunas[3], vetorColunas[4], vetorColunas[5], vetorColunas[6], new ArrayList<Curso>()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAlunos;
	}
	public void gravarAlunos(ArrayList<Aluno> listaAlunos) throws Exception {
		//nomePessoa ; cpfPessoa ; telefonePessoa ; enderecoPessoa ; dataCadastro ; statusAluno ; Formado ; listaCurso
		ArrayList<String> listaSaidaArquivo = new ArrayList<String>();
		for(Aluno aluno:listaAlunos) {
			String linha = aluno.getNomePessoa()+this.delimitadorColuna+aluno.getCpfPessoa()+this.delimitadorColuna;
			linha += aluno.getTelefonePessoa()+delimitadorColuna+aluno.getEnderecoPessoa()+delimitadorColuna+aluno.getDataCadastro()+delimitadorColuna;
			linha += aluno.getStatusAluno()+delimitadorColuna+aluno.getFormado();
			//for(Curso curso:aluno.getListaCurso()) linha+=curso.getIdCurso()+delimitadorColuna;
			listaSaidaArquivo.add(linha);
		}
		LerEscreverArquivo escrever = new LerEscreverArquivo();
		escrever.escreverArquivoEncriptado(listaSaidaArquivo, this.nomeArquivo);
	}
	public void removerAluno(String cpfAluno) throws Exception {
		ArrayList<Aluno> listaAlunos = lerAlunos();
		ArrayList<Aluno> listaSaida = new ArrayList<Aluno>();
		for(Aluno aluno:listaAlunos) {
			if(!aluno.getCpfPessoa().equals(cpfAluno)) listaSaida.add(aluno);
		}
		gravarAlunos(listaSaida);
	}
	public boolean consultarCPF(String cpf) {
		ArrayList<Aluno> listaAlunos = lerAlunos();
		for(Aluno aluno:listaAlunos) {
			if(aluno.getCpfPessoa().equals(cpf))
				return true;
		}
		return false;
	}
	
	public Aluno buscarAlunoCPF(String cpf) {
		ArrayList<Aluno> listaMateria = lerAlunos();
		for(Aluno aluno:listaMateria) {
			if(aluno.getCpfPessoa() == cpf)
				return aluno;
		}
		return null;
	}
	
	public void adicionarAluno(Aluno aluno) throws Exception {
		//nomePessoa ; cpfPessoa ; telefonePessoa ; enderecoPessoa ; dataCadastro ; statusAluno ; Formado ; listaCurso
		LerEscreverArquivo escrever = new LerEscreverArquivo();
		String linha = aluno.getNomePessoa()+this.delimitadorColuna+aluno.getCpfPessoa()+this.delimitadorColuna;
		linha += aluno.getTelefonePessoa()+delimitadorColuna+aluno.getEnderecoPessoa()+delimitadorColuna+aluno.getDataCadastro()+delimitadorColuna;
		linha += aluno.getStatusAluno()+delimitadorColuna+aluno.getFormado();
		escrever.escreverArquivoEncriptadoFinal(this.nomeArquivo, linha);
	}
	public void atualizarAluno(String cpfAlunoAntigo, Aluno aluno) throws Exception {
		removerAluno(cpfAlunoAntigo);
		adicionarAluno(aluno);
	}
}
