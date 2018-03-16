package interfaceGrafica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class SplashController implements Initializable{

	@FXML AnchorPane principalPane;
	@FXML Pane principal2Pane;
	@FXML Label nomeLabel;
	@FXML Label olaLabel;
	@FXML Pane spinnerPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		splashEffect();
	}
	
	private void mudarScene() {
		try {
			Stage stage = (Stage) principalPane.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
			Parent root = (Parent)loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void splashEffect() {
		TranslateTransition transTransition = new TranslateTransition(Duration.seconds(0.1),nomeLabel);
		transTransition.setByY(+600);
		transTransition.play();
		transTransition.setOnFinished(event ->{
			TranslateTransition transTransition2 = new TranslateTransition(Duration.seconds(0.1),olaLabel);
			transTransition2.setByY(+600);
			transTransition2.play();
			transTransition2.setOnFinished(event2->{
				FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5),principalPane);
				fadeTransition.setFromValue(0);
				fadeTransition.setToValue(1);
				fadeTransition.play();
				fadeTransition.setOnFinished(event3->{
					TranslateTransition transTransition3 = new TranslateTransition(Duration.seconds(1),nomeLabel);
					transTransition3.setByY(-600);
					transTransition3.play();
					transTransition3.setOnFinished(event4 ->{
						TranslateTransition transTransition4 = new TranslateTransition(Duration.seconds(1),olaLabel);
						transTransition4.setByY(-600);
						transTransition4.play();
						transTransition4.setOnFinished(event5 ->{
							FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(4),spinnerPane);
							fadeTransition2.setFromValue(0);
							fadeTransition2.setToValue(1);
							fadeTransition2.play();
							fadeTransition2.setOnFinished(event6->{
								FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(0.5),principalPane);
								fadeTransition3.setFromValue(1);
								fadeTransition3.setToValue(0);
								fadeTransition3.play();
								fadeTransition3.setOnFinished(event7->{
									mudarScene();
								});
							});
						});
					});
				});
			});
		});
	}

}
