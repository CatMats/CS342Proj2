import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Main_menu_controller {
    @FXML
    Button startGame;
    @FXML
    Button quitGame;
    @FXML
    Label titleLabel;




    @FXML
    public void startGame(ActionEvent event) throws IOException {
        JavaFXTemplate.setScene(1);
    }
    @FXML
    public void quitGame(ActionEvent event) throws IOException{
        Alert alert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.YES, ButtonType.NO);
        alert.setTitle("Do You want to quit?");
        alert.setHeaderText("Are you sure you want to quit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.NO) {alert.close();}
        else if (result.get() == ButtonType.YES) {((Stage)(((Button)event.getSource()).getScene().getWindow())).close();}
    }
}
