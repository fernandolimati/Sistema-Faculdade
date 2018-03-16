package persistencia;

import java.util.ArrayList;

import classes.GradeCurricular;
import classes.Materia;

public class DAO_GradeCurricular {
	String nomeArquivo;
	String delimitadorColuna;
	
	public DAO_GradeCurricular() {
		this.delimitadorColuna = ";";
		this.nomeArquivo = "bancoGradeCurricularDB.csv";
	}
	
	
	public ArrayList<GradeCurricular> lerCurso(){
		LerEscreverArquivo leitura = new LerEscreverArquivo();
		ArrayList<String> linhasArquivo;
		ArrayList<GradeCurricular> listaObj = new ArrayList<GradeCurricular>();
		try {
			linhasArquivo = leitura.lerArquivoEncriptado(nomeArquivo);
			for(String linha:linhasArquivo) {
				String[] vetorColunas = linha.split(this.delimitadorColuna);
				//new GradeCurricular(nomeGradeCurricular, cargaHorariaCurso, dataCriacaoGrade, listaMateriaGrade)
				GradeCurricular grade = new GradeCurricular(vetorColunas[0] ,vetorColunas[1] ,vetorColunas[2] ,new ArrayList<Materia>());
				ArrayList<Materia> listaMateria = new ArrayList<Materia>();
				if(vetorColunas.length > 3) {
					DAO_Materia daoMateria = new DAO_Materia();
					for(int i=3;i<vetorColunas.length;i++) {
						listaMateria.add(daoMateria.buscarMateriaCOD(Integer.parseInt(vetorColunas[i])));
					}
					grade.setListaMateriaGrade(listaMateria);
				}
				listaObj.add(grade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaObj;
	}

	public ArrayList<Materia> removerAlunoEditar(String nomeGrade) throws Exception {
		ArrayList<GradeCurricular> listaGrade = lerCurso();
		ArrayList<GradeCurricular> listaSaida = new ArrayList<GradeCurricular>();
		ArrayList<Materia> listaMateria = new ArrayList<>();
		for(GradeCurricular grade:listaGrade) {
			if(!grade.getNomeGradeCurricular().equals(nomeGrade))
				listaSaida.add(grade);
			else listaMateria = (grade.getListaMateriaGrade());
		}
		gravarGrade(listaSaida);
		return listaMateria;
	}
	
	public void gravarGrade(ArrayList<GradeCurricular> listaGrade) throws Exception {
		//new GradeCurricular(nomeGradeCurricular, cargaHorariaCurso, dataCriacaoGrade, listaMateriaGrade)
		ArrayList<String> listaSaidaArquivo = new ArrayList<String>();
		for(GradeCurricular grade:listaGrade) {
			String linha = grade.getNomeGradeCurricular()+this.delimitadorColuna;
			linha += grade.getCargaHorariaCurso()+this.delimitadorColuna;
			linha += grade.getDataCriacaoGrade()+this.delimitadorColuna;
			for(Materia materia:grade.getListaMateriaGrade())
				linha+=materia.getCodMateria()+delimitadorColuna;
			listaSaidaArquivo.add(linha);
		}
		LerEscreverArquivo escrever = new LerEscreverArquivo();
		escrever.escreverArquivoEncriptado(listaSaidaArquivo, this.nomeArquivo);
	}
	
	public void adicionarGrade(GradeCurricular grade) throws Exception {
		//new GradeCurricular(nomeGradeCurricular, cargaHorariaCurso, dataCriacaoGrade, listaMateriaGrade)
		LerEscreverArquivo escrever = new LerEscreverArquivo();
		String linha = grade.getNomeGradeCurricular()+this.delimitadorColuna;
		linha += grade.getCargaHorariaCurso()+this.delimitadorColuna;
		linha += grade.getDataCriacaoGrade()+this.delimitadorColuna;
		if(grade.getListaMateriaGrade().size()>0) {
			for(Materia materia:grade.getListaMateriaGrade()) 
				linha += materia.getCodMateria()+this.delimitadorColuna;
		}
		escrever.escreverArquivoEncriptadoFinal(this.nomeArquivo, linha);
	}
	
	public void atualizarGrade(String nomeGrade, GradeCurricular objGrade) throws Exception {
		objGrade.setListaMateriaGrade(removerAlunoEditar(nomeGrade));
		adicionarGrade(objGrade);
	}
	
	public void removerGrade(String nomeGrade) throws Exception {
		ArrayList<GradeCurricular> listaGrade = lerCurso();
		ArrayList<GradeCurricular> listaSaida = new ArrayList<GradeCurricular>();
		for(GradeCurricular grade:listaGrade) {
			if(!grade.getNomeGradeCurricular().equals(nomeGrade))
				listaSaida.add(grade);
		}
		gravarGrade(listaSaida);
	}
}
