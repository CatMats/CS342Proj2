import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main_menu_controller {
    @FXML
    BorderPane bP;

    @FXML
    VBox Vbox;

    @FXML
    Label label;

    @FXML
    Button startButton;

    @FXML
    Button endButton;



    @FXML
    public void startGame(ActionEvent event) throws IOException {

    }
    @FXML
    public void quitGame(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/quit_popup.fxml"));
        Parent root = loader.load();
        Main_menu_controller myctr = loader.getController();
        Stage substage = new Stage();
        substage.setTitle("Do you want to quit?");

        //((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
