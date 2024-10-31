import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

// added imports
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.Objects;


public class JavaFXTemplate extends Application {

	private static Stage primaryStage;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		JavaFXTemplate.primaryStage = primaryStage;
		//primaryStage.setTitle("Welcome to JavaFX");
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/main_screen.fxml")));
		primaryStage.setTitle("Three Card Poker");
			//s1.getStylesheets().add("/styles/style1.css");

		Scene scene = new Scene(root, 700,700);
		scene.getStylesheets().add(Objects.requireNonNull(Objects.requireNonNull(getClass().getResource("/test.css")).toExternalForm()));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static Stage getPrimaryStage() {return primaryStage;}

}
