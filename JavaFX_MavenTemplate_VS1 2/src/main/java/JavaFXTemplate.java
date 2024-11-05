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
	private static Scene main_menu_screen;
	private static Scene game_screen;
	private static Scene setting_screen;
	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create Scenes
		Parent root = FXMLLoader.load(Objects.requireNonNull(JavaFXTemplate.class.getResource("/main_screen.fxml")));
		main_menu_screen = new Scene(root, 800,800);
		main_menu_screen.getStylesheets().add(Objects.requireNonNull(Objects.requireNonNull(JavaFXTemplate.class.getResource("/test.css")).toExternalForm()));

		root = FXMLLoader.load(Objects.requireNonNull(JavaFXTemplate.class.getResource("/game_screen.fxml")));
		game_screen = new Scene(root, 800,800);
		game_screen.getStylesheets().add(Objects.requireNonNull(Objects.requireNonNull(JavaFXTemplate.class.getResource("/test.css")).toExternalForm()));

		root = FXMLLoader.load(Objects.requireNonNull(JavaFXTemplate.class.getResource("/settings_screen.fxml")));
		setting_screen = new Scene(root, 800,800);
		setting_screen.getStylesheets().add(Objects.requireNonNull(Objects.requireNonNull(JavaFXTemplate.class.getResource("/test.css")).toExternalForm()));

		JavaFXTemplate.primaryStage = primaryStage;
		primaryStage.setTitle("Three Card Poker");
		primaryStage.setScene(main_menu_screen);
		primaryStage.show();
	}
	// Reference for primaryStage for other classes
	public static Stage getPrimaryStage() {return primaryStage;}

	// Changes the scene into another scene
	// probably coded better idk (okay i coded it better :) )
	public static void setScene(int i) throws IOException {
		switch (i) {
			case 0:
				primaryStage.setScene(main_menu_screen);
				break;
			case 1:
				primaryStage.setScene(game_screen);
				break;
			case 2:
				primaryStage.setScene(setting_screen);
				break;
		}

	}

	public static void resetGameScreen() throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(JavaFXTemplate.class.getResource("/game_screen.fxml")));
		game_screen = new Scene(root, 700,700);
		game_screen.getStylesheets().add(Objects.requireNonNull(Objects.requireNonNull(JavaFXTemplate.class.getResource("/test.css")).toExternalForm()));
	}

}
