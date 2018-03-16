package interfaceGrafica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import classes.Mediator;
import classes.Usuario;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import persistencia.DAO_Usuario;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class LoginController implements Initializable{
	
	@FXML private JFXTextField cpfTextField;
	@FXML private JFXPasswordField passwordField;
	@FXML private JFXButton btnMinimizar,btnLogar;
	@FXML private StackPane stackPane;
	@FXML AnchorPane loginPane;
	@FXML Pane loginPane2;
	Usuario usuarioAutenticado;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		layoutEffectInicio();
		cpfTextField.setText("016.327.251-42");
		passwordField.setText("Fernando123");
	}
	
	private void layoutEffectInicio(){
		FadeTransition fade1 = new FadeTransition(Duration.seconds(1.0),loginPane);
		fade1.setFromValue(0);
		fade1.setToValue(1);
		fade1.play();
	}
	
	@FXML public void loginApp() throws Exception {
		if(cpfTextField.getText().equals("") || passwordField.getText().equals("")) {
			Text usuarioSenhaVazios = new Text("Por favor checar os dados de login.\n"
					+ "Login e/ou senha não foram digitados.\n"
					+ "Caso tenha problemas, entre em contato com a equipe de suporte.");
			dialogMostrar(stackPane, new Text("Autenticação:"), usuarioSenhaVazios);
		}else{
			if(autenticarUsuario(cpfTextField.getText(), passwordField.getText())) {
				String layout = "";
				switch(usuarioAutenticado.getNivelAcesso()) {
				case "0":
					layout = "SecretariaHome.fxml";//ADMINISTRADOR
					break;
				case "1":
					layout = "SecretariaHome.fxml";//SECRETARIA
					break;
				case "2":
					layout = "ProfessorHome.fxml";//PROFESSOR
					break;
				case "3":
					layout = "CoordenadorHome.fxml";//COORDENADOR
					break;
				case "4":
					layout = "AlunoHome.fxml";//ALUNO
					break;
				}
				
				Mediator.getInstance().setUser(usuarioAutenticado);

				Stage stage = (Stage) btnLogar.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader(getClass().getResource(layout));
				Parent root = (Parent)loader.load();
				Scene scene = new Scene(root);
				
				FadeTransition fade = new FadeTransition(Duration.seconds(0.5),loginPane2);
				fade.setFromValue(1);
				fade.setToValue(0);
				fade.play();
				fade.setOnFinished(event ->{
					FadeTransition fade2 = new FadeTransition(Duration.seconds(0.5),loginPane);
					fade2.setFromValue(1);
					fade2.setToValue(0);
					fade2.play();
					fade2.setOnFinished(event2 ->{
						stage.setScene(scene);
						stage.centerOnScreen();
						stage.show();
					});
				});
			}else {
				Text usuarioAutenticado = new Text("Login não efetuado com Sucesso.\n"
						+ "Login e/ou senha não foram autenticados.\n"
						+ "Caso tenha problemas, entre em contato com a equipe de suporte.");
				dialogMostrar(stackPane, new Text("Autenticação:"), usuarioAutenticado);
			}			
		}
		
	}	
	
	@FXML public void textFieldEnter(KeyEvent keyEvent) throws Exception{if(keyEvent.getCode().equals(KeyCode.ENTER))threadlogin();}
	
	@FXML public void sairSistema() {Platform.exit();}
	
	public void threadlogin() {
		Task<?> tarefaCargaPg = new Task<Object>() {

			@Override
			protected String call() throws Exception {
				loginApp();
				return null;
			}
		};
		Thread t = new Thread(tarefaCargaPg);
		t.setDaemon(true);
		t.start();
	}
	
	@FXML public void btnMinimizarOnAction() throws IOException{
	    Stage stage = (Stage)btnMinimizar.getScene().getWindow();
	    stage.setIconified(true);
	}

	private void dialogMostrar(StackPane stackPane,Text titulo, Text msg) {
		JFXDialogLayout content = new JFXDialogLayout();
		content.setHeading(titulo);
		content.setBody(msg);
		JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.TOP);
		JFXButton button = new JFXButton("OK");
		button.setStyle("-fx-background-color: #404300; -fx-text-fill:white; -fx-font-weight: bolder;");
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				dialog.close();
			}
		});;
		content.setActions(button);
		dialog.show();
	}
	
	private boolean autenticarUsuario(String cpf, String senha) throws Exception {
		String cpfClear = cpf.replace(".", " ");
		cpfClear = cpfClear.replace("-", " ");
		cpfClear = cpfClear.replace(" ", "");
		DAO_Usuario daoUsuario = new DAO_Usuario();
		Usuario objUsuario = daoUsuario.autenticarUsuario(cpfClear, senha);
		if(objUsuario == null)return false;
		else {
			this.usuarioAutenticado = objUsuario;
			return true;
		}
	}
}
