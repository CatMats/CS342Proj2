import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Settings_screen_controller {
    @FXML
    Button backButton;
    @FXML
    Button backgroundButton;
    @FXML
    Button resetButton;
    @FXML
    Button titleButton;

    public void backButtonAction(ActionEvent event) throws IOException {
        JavaFXTemplate.setScene(2);
    }

    public void backgroundButtonAction(ActionEvent event) {
    }

    public void resetButtonAction(ActionEvent event) throws IOException {
        JavaFXTemplate.resetGameScreen();
    }

    public void titleButtonAction(ActionEvent event) throws IOException {
        JavaFXTemplate.setScene(0);
    }
}
