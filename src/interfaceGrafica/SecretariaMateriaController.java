package interfaceGrafica;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import classes.Materia;
import classes.MateriaModel;
import classes.Mediator;
import classes.Usuario;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import persistencia.DAO_Materia;

public class SecretariaMateriaController implements Initializable{

public Usuario usuarioLogado = new Usuario();
	
	//COMPONENTES DOS BOTOES E LAYOUT PADRAO
	@FXML private AnchorPane pane1, pane2, pane3, pane4, opacityPane,drawerPane;
	@FXML private ImageView drawerImage;
	@FXML JFXButton btnMenuLateral1,btnMenuLateral2,btnMenuLateral3,btnMenuLateral4,btnMenuLateral5,btnMenuLateral6,btnMenuLateral7,btnMenuLateral8,btnMenuLateral9;
	@FXML ImageView minimizarImage,warningImageView,fecharImage;
	@FXML Label nomeUsuarioLabel,nivelAcessoLabel,warningTituloLabel,warningMsgLabel;
	@FXML HBox hboxSairSistema;
	@FXML AnchorPane layoutPane,warningPane,warningBackgroundPane;
	@FXML JFXButton btnNavHome,btnNavMatricula,btnNavMateria,btnNavTurma,btnNavCurso,btnNavDiario,btnNavHistorico,btnNavAluno;
	
	//COMPONENTES ESPECIFICOS DA PAGINA
	@FXML private JFXTreeTableView<MateriaModel> treeTableView;
	@FXML private TreeTableColumn<MateriaModel, String> nomeCol;
	@FXML private TreeTableColumn<MateriaModel, String> cargaHorariaCol;
	@FXML private TreeTableColumn<MateriaModel, String> codCol;
	@FXML private TreeTableColumn<MateriaModel, String> descricaoCol;
	@FXML private JFXTextField searchTextField;
	@FXML private JFXTextField codTextField;
	@FXML private JFXTextField nomeTextField;
	@FXML private JFXTextField cargaHorariaTextField;
	@FXML private JFXTextArea descricaoTextArea;
	ObservableList<MateriaModel> obsList;
	private ArrayList<Materia> listMateria;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		//LAYOUT
		layoutEffectInicio();
		panelEffect();
		menuBarEffect();
		setarDadosInterfaceUsuario();
		inicializarBotoesScenes();
		
		//CONTROLES NOVOS
		threadTreeView();
	}
	
	//THREAD PARA TREEVIEW
	public void threadTreeView() {
		Task<?> tarefaCargaPg = new Task<Object>() {

			@Override
			protected String call() throws Exception {
				carregarTreeTableView();
				return null;
			}
		};
		Thread t = new Thread(tarefaCargaPg);
		t.setDaemon(true);
		t.start();
	}
	
	//TREETABLEVIEW COMANDOS E BOTOES 
	public void carregarTreeTableView() {

		nomeCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriaModel,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<MateriaModel, String> param) {
				return param.getValue().getValue().getNomeMateriaProperty();
			}
		});
		cargaHorariaCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriaModel,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<MateriaModel, String> param) {
				return param.getValue().getValue().getCargaHorariaMateriaProperty();
			}
		});
		codCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriaModel,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<MateriaModel, String> param) {
				return param.getValue().getValue().getCodMateriaProperty();
			}
		});
		descricaoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriaModel,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<MateriaModel, String> param) {
				return param.getValue().getValue().getDescricaoMateriaProperty();
			}
		});
		
		obsList = FXCollections.observableArrayList();
		TreeItem<MateriaModel> root = new RecursiveTreeItem<>(obsList, RecursiveTreeObject ::getChildren);
		treeTableView.setRoot(root);
		treeTableView.setShowRoot(false);
		
		DAO_Materia daoMateria = new DAO_Materia();
		listMateria = daoMateria.lerCurso();
		for(Materia objMateria:listMateria)
			obsList.add(new MateriaModel(Integer.toString(objMateria.getCodMateria()), objMateria.getNomeMateria(), objMateria.getDescricaoMateria(), Integer.toString(objMateria.getCargaHorariaMateria())));
	
		searchTextField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				treeTableView.setPredicate(new Predicate<TreeItem<MateriaModel>>() {
					@Override
					public boolean test(TreeItem<MateriaModel> t) {
						return t.getValue().getNomeMateria().contains(newValue) | t.getValue().getCodMateria().contains(newValue);
					}
				});
			}
		});
		
		treeTableView.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> {
			showDetais(newValue);
		});
		
		
	}
	
	@FXML
	void editAction(ActionEvent event){
		try {
			TreeItem<MateriaModel> treeItem = treeTableView.getSelectionModel().getSelectedItem();
			if(!treeItem.getValue().getNomeMateria().equals(nomeTextField.getText()) || !treeItem.getValue().getCodMateria().equals(codTextField.getText()) || !treeItem.getValue().getDescricaoMateria().equals(descricaoTextArea.getText()) || !treeItem.getValue().getCargaHorariaMateria().equals(cargaHorariaTextField.getText()) ) {
				//new Materia(nomeMateria, descricaoMateria, cargaHorariaMateria, codMateria)
				Materia mat = new Materia(nomeTextField.getText(),descricaoTextArea.getText(),Integer.parseInt(cargaHorariaTextField.getText()),Integer.parseInt(codTextField.getText()));
				//new MateriaModel(codMateria, nomeMateria, descricaoMateria, cargaHorariaMateria)
				MateriaModel matModel = new MateriaModel(codTextField.getText(),nomeTextField.getText(),descricaoTextArea.getText(),cargaHorariaTextField.getText());
				DAO_Materia daoMat = new DAO_Materia();
				daoMat.atualizarGrade(treeItem.getValue().getCodMateria(),mat);
				treeItem.setValue(matModel);
				showAlerta("OK", "Sucesso!", "Materia editada com sucesso!");
			}else {
				showAlerta("Erro", "Erro!", "Dados inseridos incorretamente e/ou não alterados do original.");
			}
		}catch (Exception e) {
			showAlerta("Erro", "Erro!", e.getMessage());
		}
	}
	
	
	public void showDetais(TreeItem<MateriaModel> treeItem) {
		if(treeItem != null) {
			codTextField.setText(treeItem.getValue().getCodMateria());
			nomeTextField.setText(treeItem.getValue().getNomeMateria());
			cargaHorariaTextField.setText(treeItem.getValue().getCargaHorariaMateria());
			descricaoTextArea.setText(treeItem.getValue().getDescricaoMateria());
		}		
	}
	
	public void clearFields() {
		searchTextField.setText("");
		codTextField.setText("");
		nomeTextField.setText("");
		cargaHorariaTextField.setText("");
		descricaoTextArea.setText("");
	}
	
	@FXML
	void clearAction(ActionEvent event) {clearFields();}
		

	public String dataHoje() {
		Calendar calendar = Calendar.getInstance();
		return (calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR));
	}
	
	@FXML
	void adicionarAction(ActionEvent event){
		try {
			if(!nomeTextField.getText().isEmpty() && !cargaHorariaCol.getText().isEmpty() && !codTextField.getText().isEmpty() && !descricaoTextArea.getText().isEmpty()) {
				DAO_Materia daoMat = new DAO_Materia();
				//new Materia(nomeMateria, descricaoMateria, cargaHorariaMateria, codMateria)
				Materia mat = new Materia(nomeTextField.getText(),descricaoTextArea.getText(),Integer.parseInt(cargaHorariaTextField.getText()),Integer.parseInt(codTextField.getText()));
				daoMat.adicionarMateria(mat);
				//new MateriaModel(codMateria, nomeMateria, descricaoMateria, cargaHorariaMateria)
				obsList.addAll(new MateriaModel(codTextField.getText(),nomeTextField.getText(),descricaoTextArea.getText(),cargaHorariaTextField.getText()));
				clearFields();
				showAlerta("OK", "Sucesso!", "Materia incluidaa com sucesso!");
			}else {
				showAlerta("Erro", "Erro!", "Insira os dados em todos os campos.");
			}
		}catch (Exception e) {
			showAlerta("Erro", "Erro!", e.getMessage());
		}
	}

	@FXML
	void excluirAction(ActionEvent event){
		try {
			int index=treeTableView.getSelectionModel().getSelectedIndex();
			if(index != -1) {
				MateriaModel matModel = obsList.get(index);
				obsList.remove(index);
				DAO_Materia daoMat = new DAO_Materia();
				daoMat.removerMateria(matModel.getCodMateria().toString());
				clearFields();
				showAlerta("OK", "Sucesso!", "Materia Excluida com sucesso!");
			}
		}catch (Exception e) {
			showAlerta("Erro", "Erro!", e.getMessage());
		}
	}
	
	
	//EFEITOS E INTERFACE BOTOES
 	public void layoutEffectInicio(){
		FadeTransition fade1 = new FadeTransition(Duration.seconds(1),layoutPane);
		fade1.setFromValue(0);
		fade1.setToValue(1);
		fade1.play();
		
		ScaleTransition sTrans = new ScaleTransition(Duration.seconds(0.5),warningPane);
		sTrans.setByX(-1);
		sTrans.setByY(-1);
		sTrans.play();
	}
	public void menuBarEffect() {
		opacityPane.setVisible(false);
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5),opacityPane);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();
		TranslateTransition transTransition = new TranslateTransition(Duration.seconds(0.5),drawerPane);
		transTransition.setByX(-600);
		transTransition.play();
		drawerImage.setOnMouseClicked(event ->{
			opacityPane.setVisible(true);
			FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.5),opacityPane);
			fadeTransition2.setFromValue(0);
			fadeTransition2.setToValue(0.30);
			fadeTransition2.play();
			
			TranslateTransition transTransition2 = new TranslateTransition(Duration.seconds(0.5),drawerPane);
			transTransition2.setByX(600);
			transTransition2.play();
		});
		
		opacityPane.setOnMouseClicked(event2 ->{
			opacityPane.setVisible(false);
			FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(0.5),opacityPane);
			fadeTransition3.setFromValue(0.30);
			fadeTransition3.setToValue(0);
			fadeTransition3.play();
			
			TranslateTransition transTransition3 = new TranslateTransition(Duration.seconds(0.5),drawerPane);
			transTransition3.setByX(-600);
			transTransition3.play();
		});
	}
	public void panelEffect() {
		pane1.setStyle("-fx-background-image: url(\"/imagens/1.jpg\")");
		pane2.setStyle("-fx-background-image: url(\"/imagens/2.jpg\")");
		pane3.setStyle("-fx-background-image: url(\"/imagens/3.jpg\")");
		pane4.setStyle("-fx-background-image: url(\"/imagens/4.jpg\")");
		
		FadeTransition fadeTransition=new FadeTransition(Duration.seconds(3),pane4);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        fadeTransition.setOnFinished(event -> {
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(3),pane3);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {

                FadeTransition fadeTransition2=new FadeTransition(Duration.seconds(3),pane2);
                fadeTransition2.setFromValue(1);
                fadeTransition2.setToValue(0);
                fadeTransition2.play();

                fadeTransition2.setOnFinished(event2 -> {

                    FadeTransition fadeTransition00=new FadeTransition(Duration.seconds(3),pane2);
                    fadeTransition00.setFromValue(0);
                    fadeTransition00.setToValue(1);
                    fadeTransition00.play();


                    fadeTransition00.setOnFinished(event3 -> {
                        FadeTransition fadeTransition11=new FadeTransition(Duration.seconds(3),pane3);
                        fadeTransition11.setFromValue(0);
                        fadeTransition11.setToValue(1);
                        fadeTransition11.play();

                        fadeTransition11.setOnFinished(event4 -> {
                            FadeTransition fadeTransition22=new FadeTransition(Duration.seconds(3),pane4);
                            fadeTransition22.setFromValue(0);
                            fadeTransition22.setToValue(1);
                            fadeTransition22.play();

                            fadeTransition22.setOnFinished(event5 -> {
                            	panelEffect();
                            });
                        });
                    });
                });
            });
        });

        
	}
	private void setarDadosInterfaceUsuario() {
		this.usuarioLogado = Mediator.getInstance().getUser();
		switch(this.usuarioLogado.getNivelAcesso()) {
		case "0":
			nivelAcessoLabel.setText("Administrador");
			break;
		case "1":
			nivelAcessoLabel.setText("Secretaria");
			break;
		case "2":
			nivelAcessoLabel.setText("Professor");
			break;
		case "3":
			nivelAcessoLabel.setText("Coordenador");
			break;
		case "4":
			nivelAcessoLabel.setText("Aluno");
			break;
		}
		nomeUsuarioLabel.setText(this.usuarioLogado.getUsuario().toString());
		
	}
	private void mudarScene(String fxml) {
		try {
			Stage stage = (Stage)minimizarImage.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			stage.setScene(scene);
			
			FadeTransition fade = new FadeTransition(Duration.seconds(0.5),layoutPane);
			fade.setFromValue(1);
			fade.setToValue(0);
			fade.play();
			fade.setOnFinished(event->{
				stage.show();
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void inicializarBotoesScenes() {
		minimizarImage.setOnMouseClicked(event ->{
			Stage stage = (Stage)minimizarImage.getScene().getWindow();
		    stage.setIconified(true);
		});
		hboxSairSistema.setOnMouseClicked(event ->{
			mudarScene("Login.fxml");
		});
		fecharImage.setOnMouseClicked(event ->{
			FadeTransition fade = new FadeTransition(Duration.seconds(1),layoutPane);
			fade.setFromValue(1);
			fade.setToValue(0);
			fade.play();
			fade.setOnFinished(event2->{
				Platform.exit();
			});
		});
		btnNavHome.setOnMouseClicked(event->{
			mudarScene("SecretariaHome.fxml");
		});
		btnNavMatricula.setOnMouseClicked(event->{
			mudarScene("SecretariaMatricula.fxml");
		});
		btnNavMateria.setOnMouseClicked(event->{
			//mudarScene("SecretariaMateria.fxml");
		});
		btnNavTurma.setOnMouseClicked(event->{
			mudarScene("SecretariaTurma.fxml");
		});
		btnNavCurso.setOnMouseClicked(event->{
			mudarScene("SecretariaCurso.fxml");
		});
		btnNavDiario.setOnMouseClicked(event->{
			mudarScene("SecretariaDiario.fxml");
		});
		btnNavHistorico.setOnMouseClicked(event->{
			mudarScene("SecretariaHistorico.fxml");
		});
		btnNavAluno.setOnMouseClicked(event->{
			mudarScene("SecretariaAluno.fxml");
		});
	}
	private void showAlerta(String tipo, String titulo, String msg) {
		//showAlerta("OK", "Sucesso!", "Aluno Excluido com sucesso!");
		//showAlerta("Erro", "Erro!", e.toString());
		String imageURL = "";
		String backgroundColor = "";
		
		if(tipo.equals("Erro")) {
			imageURL = "/imagens/Error_64px.png";
			backgroundColor = "#FF0000";
		}else if(tipo.equals("OK")) {
			imageURL = "/imagens/Checked_48px.png";
			backgroundColor = "#293D08";
		}
		
		warningImageView.setImage(new Image(imageURL));
		warningBackgroundPane.setStyle("-fx-background-color:"+backgroundColor+";-fx-background-radius:25px 25px 0px 0px;");
		warningTituloLabel.setText(titulo);
		warningMsgLabel.setText(msg);
		warningPane.setVisible(true);
		
		ScaleTransition sTrans = new ScaleTransition(Duration.seconds(1),warningPane);
		sTrans.setByX(1);
		sTrans.setByY(1);
		sTrans.play();
		
		sTrans.setOnFinished(event ->{
			FadeTransition fade = new FadeTransition(Duration.seconds(2),warningPane);
			fade.setFromValue(1);
			fade.setToValue(0);
			fade.play();
			
			fade.setOnFinished(event2->{
				ScaleTransition sTrans2 = new ScaleTransition(Duration.seconds(0.5),warningPane);
				sTrans2.setByX(-1);
				sTrans2.setByY(-1);
				sTrans2.play();
				
				warningPane.setVisible(false);
				
				FadeTransition fade2 = new FadeTransition(Duration.seconds(0.5),warningPane);
				fade2.setFromValue(0);
				fade2.setToValue(1);
				fade2.play();
			});
		});
	}

}
