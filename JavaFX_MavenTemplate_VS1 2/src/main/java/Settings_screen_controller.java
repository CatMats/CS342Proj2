import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

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
        JavaFXTemplate.setScene(1);
    }

    public void backgroundButtonAction(ActionEvent event) throws IOException{
        JavaFXTemplate.changeBG();
    }

    public void resetButtonAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.NONE, null, ButtonType.YES, ButtonType.NO);
        alert.setTitle("Are you sure you want to reset the game?");
        alert.setHeaderText("Are you sure you want to reset the game?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.NO) {alert.close();}
        else if (result.get() == ButtonType.YES) {JavaFXTemplate.resetGameScreen();}
    }

    public void titleButtonAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.NONE, null, ButtonType.YES, ButtonType.NO);
        alert.setTitle("Are you sure you want to return to title?");
        alert.setHeaderText("Are you sure you want to return to title?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.NO) {alert.close();}
        else if (result.get() == ButtonType.YES) {JavaFXTemplate.setScene(0);}
    }
}
