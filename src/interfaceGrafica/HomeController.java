package interfaceGrafica;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import com.jfoenix.controls.JFXButton;

import classes.Mediator;
import classes.Usuario;
import javafx.scene.control.Label;

public class HomeController implements Initializable {

	public Usuario usuarioLogado = new Usuario();
	
	@FXML private AnchorPane pane1, pane2, pane3, pane4, opacityPane,drawerPane;
	@FXML private ImageView drawerImage;
	@FXML private JFXButton btnHome1,btnHome2,btnHome3,btnHome4,btnHome5,btnHome6,btnHome7,btnHome8,btnHome9;
	@FXML JFXButton btnMenuLateral1,btnMenuLateral2,btnMenuLateral3,btnMenuLateral4,btnMenuLateral5,btnMenuLateral6,btnMenuLateral7,btnMenuLateral8,btnMenuLateral9;
	@FXML ImageView minimizarImage;
	@FXML ImageView fecharImage;
	@FXML Label nomeUsuarioLabel,nivelAcessoLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		minimizarImage.setOnMouseClicked(event ->{
			Stage stage = (Stage)minimizarImage.getScene().getWindow();
		    stage.setIconified(true);
		});
		fecharImage.setOnMouseClicked(event ->{Platform.exit();});
		panelEffect();
		menuBarEffect();
		setarDadosInterfaceUsuario();
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
}
	


