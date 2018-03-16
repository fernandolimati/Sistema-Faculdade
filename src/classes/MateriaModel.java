package classes;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MateriaModel  extends RecursiveTreeObject<MateriaModel>{
	private StringProperty codMateria;
	private StringProperty nomeMateria;
	private StringProperty descricaoMateria;
	private StringProperty cargaHorariaMateria;
	
	public MateriaModel(String codMateria, String nomeMateria, String descricaoMateria,
			String cargaHorariaMateria) {
		super();
		this.codMateria = new SimpleStringProperty(codMateria);
		this.nomeMateria = new SimpleStringProperty(nomeMateria);
		this.descricaoMateria = new SimpleStringProperty(descricaoMateria);
		this.cargaHorariaMateria = new SimpleStringProperty(cargaHorariaMateria);
	}
	public StringProperty getCodMateriaProperty() {
		return codMateria;
	}
	public void setCodMateriaProperty(StringProperty codMateria) {
		this.codMateria = codMateria;
	}
	public StringProperty getNomeMateriaProperty() {
		return nomeMateria;
	}
	public void setNomeMateriaProperty(StringProperty nomeMateria) {
		this.nomeMateria = nomeMateria;
	}
	public StringProperty getDescricaoMateriaProperty() {
		return descricaoMateria;
	}
	public void setDescricaoMateriaProperty(StringProperty descricaoMateria) {
		this.descricaoMateria = descricaoMateria;
	}
	public StringProperty getCargaHorariaMateriaProperty() {
		return cargaHorariaMateria;
	}
	public void setCargaHorariaMateriaProperty(StringProperty cargaHorariaMateria) {
		this.cargaHorariaMateria = cargaHorariaMateria;
	}
	
	public String getCodMateria() {
		return codMateria.get();
	}
	public void setCodMateria(String codMateria) {
		this.codMateria.set(codMateria);
	}
	public String getNomeMateria() {
		return nomeMateria.get();
	}
	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria.set(nomeMateria);
	}
	public String getDescricaoMateria() {
		return descricaoMateria.get();
	}
	public void setDescricaoMateria(String descricaoMateria) {
		this.descricaoMateria.set(descricaoMateria);
	}
	public String getCargaHorariaMateria() {
		return cargaHorariaMateria.get();
	}
	public void setCargaHorariaMateria(String cargaHorariaMateria) {
		this.cargaHorariaMateria.set(cargaHorariaMateria);
	}
	
	
	
}
