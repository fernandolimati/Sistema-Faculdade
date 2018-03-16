package persistencia;

import java.util.ArrayList;

import classes.Materia;

public class DAO_Materia {

	String nomeArquivo;
	String delimitadorColuna;
	
	public DAO_Materia() {
		this.delimitadorColuna = ";";
		this.nomeArquivo = "bancoMateriaDB.csv";
	}
	
	
	public ArrayList<Materia> lerCurso(){
		LerEscreverArquivo leitura = new LerEscreverArquivo();
		ArrayList<String> linhasArquivo;
		ArrayList<Materia> listaObj = new ArrayList<Materia>();
		try {
			linhasArquivo = leitura.lerArquivoEncriptado(nomeArquivo);
			for(String linha:linhasArquivo) {
				String[] vetorColunas = linha.split(this.delimitadorColuna);
				//new Materia(nomeMateria, descricaoMateria, cargaHorariaMateria, codMateria)
				listaObj.add(new Materia(vetorColunas[0] ,vetorColunas[1] ,Integer.parseInt(vetorColunas[2]) ,Integer.parseInt(vetorColunas[3])));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaObj;
	}
	
	public void removerMateria(String cod) throws Exception {
		ArrayList<Materia> listaGrade = lerCurso();
		ArrayList<Materia> listaSaida = new ArrayList<Materia>();
		for(Materia mat:listaGrade) {
			if((mat.getCodMateria() != Integer.parseInt(cod)))
				listaSaida.add(mat);
		}
		gravarMateria(listaSaida);
	}
	
	public void gravarMateria(ArrayList<Materia> listaMat) throws Exception {
		//new Materia(nomeMateria, descricaoMateria, cargaHorariaMateria, codMateria)
		ArrayList<String> listaSaidaArquivo = new ArrayList<String>();
		for(Materia mat:listaMat) {
			String linha = mat.getNomeMateria()+this.delimitadorColuna;
			linha += mat.getDescricaoMateria()+this.delimitadorColuna;
			linha += mat.getCargaHorariaMateria()+this.delimitadorColuna;
			linha += mat.getCodMateria();
			listaSaidaArquivo.add(linha);
		}
		LerEscreverArquivo escrever = new LerEscreverArquivo();
		escrever.escreverArquivoEncriptado(listaSaidaArquivo, this.nomeArquivo);
	}
	
	public void adicionarMateria(Materia mat) throws Exception {
		//new Materia(nomeMateria, descricaoMateria, cargaHorariaMateria, codMateria)
		LerEscreverArquivo escrever = new LerEscreverArquivo();
		String linha = mat.getNomeMateria()+this.delimitadorColuna;
		linha += mat.getDescricaoMateria()+this.delimitadorColuna;
		linha += mat.getCargaHorariaMateria()+this.delimitadorColuna;
		linha += mat.getCodMateria();
		escrever.escreverArquivoEncriptadoFinal(this.nomeArquivo, linha);
	}
	
	public Materia buscarMateriaCOD(int codMateria) {
		ArrayList<Materia> listaMateria = lerCurso();
		for(Materia materia:listaMateria) {
			if(materia.getCodMateria() == codMateria)
				return materia;
		}
		return null;
	}


	public void atualizarGrade(String codMateria, Materia mat) throws Exception {
		removerMateria(codMateria);
		adicionarMateria(mat);
	}
}
