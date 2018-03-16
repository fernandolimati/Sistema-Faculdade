package persistencia;

import java.util.ArrayList;

import classes.GeradorHash;
import classes.Usuario;

public class DAO_Usuario {
	String nomeArquivo;
	String delimitadorColuna;
	
	public DAO_Usuario() {
		this.delimitadorColuna = ";";
		this.nomeArquivo = "bancoUsuariosDB.csv";
	}
	
	private ArrayList<Usuario> lerUsuarios(){
		LerEscreverArquivo leitura = new LerEscreverArquivo();
		ArrayList<String> linhasArquivo;
		ArrayList<Usuario> listaObj = new ArrayList<Usuario>();
		try {
			linhasArquivo = leitura.lerArquivo(nomeArquivo);
			for(String linha:linhasArquivo) {
				String[] vetorColunas = linha.split(this.delimitadorColuna);
	          	listaObj.add(new Usuario(vetorColunas[1], vetorColunas[2], vetorColunas[3], vetorColunas[0]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaObj;
	}
	public Usuario autenticarUsuario(String cpf, String senha) throws Exception {
		ArrayList<Usuario> listaObjUsuario = lerUsuarios();
		GeradorHash gh = new GeradorHash();
		String hashEntrada = gh.gerarHash(senha);
		for(Usuario usuario:listaObjUsuario) {
			if(hashEntrada.equals(usuario.getSenha()) && usuario.getCpf().equals(cpf)) {
				return usuario;
			}
		}
		return null;
	}
}
