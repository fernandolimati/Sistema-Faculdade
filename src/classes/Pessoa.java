package classes;

public class Pessoa {
	
	protected String nomePessoa;
	protected String cpfPessoa;
	protected String telefonePessoa;
	protected String enderecoPessoa;
	
	public Pessoa() {
		this.nomePessoa = "";
		this.cpfPessoa  = "";
		this.telefonePessoa = "";
		this.enderecoPessoa = "";
	}
	public Pessoa(String nomePessoa, String cpfPessoa, String telefonePessoa, String enderecoPessoa) {
		this.nomePessoa = nomePessoa;
		this.cpfPessoa = cpfPessoa;
		this.telefonePessoa = telefonePessoa;
		this.enderecoPessoa = enderecoPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public String getCpfPessoa() {
		return cpfPessoa;
	}
	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}
	public String getTelefonePessoa() {
		return telefonePessoa;
	}
	public void setTelefonePessoa(String telefonePessoa) {
		this.telefonePessoa = telefonePessoa;
	}
	public String getEnderecoPessoa() {
		return enderecoPessoa;
	}
	public void setEnderecoPessoa(String enderecoPessoa) {
		this.enderecoPessoa = enderecoPessoa;
	}
}
