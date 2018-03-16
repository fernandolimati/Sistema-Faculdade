package interfaceGrafica;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		this.stage = primaryStage;
		mainWindow();
	}
	
	public void mainWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("Splash.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			scene.getStylesheets().addAll(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setResizable(true);
			stage.centerOnScreen();
			stage.show();
		} catch (IOException e) {
			
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
