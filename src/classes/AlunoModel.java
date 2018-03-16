package classes;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AlunoModel extends RecursiveTreeObject<AlunoModel>{

	StringProperty nome,cpf,dataCadastro,status,formado,telefone,endereco;
	
	
	
	public AlunoModel(String nome, String cpf, String dataCadastro, String status, String formado, String telefone, String endereco) {
		super();
		this.nome = new SimpleStringProperty(nome);
		this.cpf = new SimpleStringProperty(cpf);
		this.dataCadastro = new SimpleStringProperty(dataCadastro);
		this.status = new SimpleStringProperty(status);
		this.formado = new SimpleStringProperty(formado);
		this.telefone = new SimpleStringProperty(telefone);
		this.endereco = new SimpleStringProperty(endereco);
	}
		

	public StringProperty telefoneProperty() {
		return telefone;
	}
	public String getTelefone() {
		return telefone.get();
	}
	public void setTelefone(String telefone) {
		this.telefone.set(telefone);
	}

	public StringProperty enderecoProperty() {
		return endereco;
	}
	public String getEndereco() {
		return this.endereco.get();
	}
	public void setEndereco(String endereco) {
		this.endereco.set(endereco);
	}

	public StringProperty nomeProperty() {
		return nome;
	}
	public String getNome() {
		return this.nome.get();
	}
	public void setNome(String nome) {
		this.nome.set(nome);;
	}

	public StringProperty cpfProperty() {
		return cpf;
	}
	public String getCpf() {
		return this.cpf.get();
	}
	public void setCpf(String cpf) {
		this.cpf.set(cpf);;
	}

	public StringProperty dataCadastroProperty() {
		return dataCadastro;
	}
	public String getDataCadastro() {
		return dataCadastro.get();
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro.set(dataCadastro);
	}

	public StringProperty statusProperty() {
		return status;
	}
	public String getStatus() {
		return status.get();
	}
	public void setStatus(String status) {
		this.status.set(status);
	}

	public StringProperty formadoProperty() {
		return formado;
	}
	public String getFormado() {
		return formado.get();
	}
	public void setFormado(String formado) {
		this.formado.set(formado);
	}

	
	
}
