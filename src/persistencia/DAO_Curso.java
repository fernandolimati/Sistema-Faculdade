package persistencia;


public class DAO_Curso {

	String nomeArquivo;
	String delimitadorColuna;
	
	public DAO_Curso() {
		this.delimitadorColuna = ";";
		this.nomeArquivo = "bancoCursoDB.csv";
	}
	
//	private ArrayList<Usuario> lerCurso(){
//		LerEscreverArquivo leitura = new LerEscreverArquivo();
//		ArrayList<String> linhasArquivo;
//		ArrayList<Curso> listaObj = new ArrayList<Curso>();
//		try {
//			linhasArquivo = leitura.lerArquivo(nomeArquivo);
//			for(String linha:linhasArquivo) {
//				String[] vetorColunas = linha.split(this.delimitadorColuna);
//				//new Curso(idCurso, nomeCurso, matriculaCurso, dataMatriculaCurso, statusCurso, gradeCurricular, listaMateriaCursada, listaMateriaCursando)
//	          	listaObj.add(new Curso() );
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return listaObj;
//	}
	
}
