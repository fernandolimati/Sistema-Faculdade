package classes;

public class Usuario {
	private String usuario;
	private String cpf;
	private String senha;
	private String nivelAcesso;
	
	public Usuario() {
		this.usuario = "";
		this.senha = "";
		this.nivelAcesso = "";
		this.cpf = "";
	}
	public Usuario(String cpf, String senha, String nivelAcesso, String usuario) {
		this.usuario = usuario;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
		this.cpf = cpf;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNivelAcesso() {
		return nivelAcesso;
	}
	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
