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

import java.io.IOException;
import java.util.Objects;


public class JavaFXTemplate extends Application {

	private static Stage primaryStage;
	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		JavaFXTemplate.primaryStage = primaryStage;
		primaryStage.setTitle("Three Card Poker");
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/main_screen.fxml")));
		Scene scene = new Scene(root, 700,700);
		scene.getStylesheets().add(Objects.requireNonNull(Objects.requireNonNull(getClass().getResource("/test.css")).toExternalForm()));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// Reference for primaryStage for other classes
	public static Stage getPrimaryStage() {return primaryStage;}

	// Changes the scene into another scene
	// probably coded better idk
	public static void setScene(int i) throws IOException {
		switch (i) {
			case 0:
				Parent root = FXMLLoader.load(Objects.requireNonNull(JavaFXTemplate.class.getResource("/main_screen.fxml")));
				Scene scene = new Scene(root, 700,700);
				scene.getStylesheets().add(Objects.requireNonNull(Objects.requireNonNull(JavaFXTemplate.class.getResource("/test.css")).toExternalForm()));
				primaryStage.setScene(scene);
				break;
			case 1:
				root = FXMLLoader.load(Objects.requireNonNull(JavaFXTemplate.class.getResource("/game_screen.fxml")));
				scene = new Scene(root, 700,700);
				scene.getStylesheets().add(Objects.requireNonNull(Objects.requireNonNull(JavaFXTemplate.class.getResource("/test.css")).toExternalForm()));
				primaryStage.setScene(scene);
				break;
			case 2:
				root = FXMLLoader.load(Objects.requireNonNull(JavaFXTemplate.class.getResource("/settings_screen.fxml")));
				scene = new Scene(root, 700,700);
				scene.getStylesheets().add(Objects.requireNonNull(Objects.requireNonNull(JavaFXTemplate.class.getResource("/test.css")).toExternalForm()));
				primaryStage.setScene(scene);
				break;
		}

	}
}
