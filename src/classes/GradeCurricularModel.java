package classes;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GradeCurricularModel extends RecursiveTreeObject<GradeCurricularModel>{

	
	private StringProperty nomeGradeCurricular;
	private StringProperty cargaHorariaCurso;
	private StringProperty dataCriacaoGrade;
	
	
	public GradeCurricularModel(String nomeGradeCurricular, String cargaHorariaCurso,
			String dataCriacaoGrade) {
		super();
		this.nomeGradeCurricular = new  SimpleStringProperty(nomeGradeCurricular);
		this.cargaHorariaCurso = new  SimpleStringProperty(cargaHorariaCurso);
		this.dataCriacaoGrade = new  SimpleStringProperty(dataCriacaoGrade);
	}
	
	public StringProperty getNomeGradeCurricularProperty() {
		return nomeGradeCurricular;
	}
	public void setNomeGradeCurricularProperty(StringProperty nomeGradeCurricular) {
		this.nomeGradeCurricular = nomeGradeCurricular;
	}
	public String getNomeGradeCurricular() {
		return nomeGradeCurricular.get();
	}
	public void setNomeGradeCurricular(String nomeGradeCurricular) {
		this.nomeGradeCurricular.set(nomeGradeCurricular);
	}
	
	
	public StringProperty getCargaHorariaCursoProperty() {
		return cargaHorariaCurso;
	}
	public void setCargaHorariaCursoProperty(StringProperty cargaHorariaCurso) {
		this.cargaHorariaCurso = cargaHorariaCurso;
	}
	public String getCargaHorariaCurso() {
		return cargaHorariaCurso.get();
	}
	public void setCargaHorariaCurso(String cargaHorariaCurso) {
		this.cargaHorariaCurso.set(cargaHorariaCurso);
	}
	
	public StringProperty getDataCriacaoGradeProperty() {
		return dataCriacaoGrade;
	}
	public void setDataCriacaoGradeProperty(StringProperty dataCriacaoGrade) {
		this.dataCriacaoGrade = dataCriacaoGrade;
	}
	public String getDataCriacaoGrade() {
		return dataCriacaoGrade.get();
	}
	public void setDataCriacaoGrade(String dataCriacaoGrade) {
		this.dataCriacaoGrade.set(dataCriacaoGrade);
	}
	
}
