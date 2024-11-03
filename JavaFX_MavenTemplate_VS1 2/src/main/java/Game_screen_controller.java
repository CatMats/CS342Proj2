import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Game_screen_controller {
    @FXML
    VBox player1VBOX;
    @FXML
    HBox player1HBox;
    @FXML
    Button settingButtons;


    int player1Money;
    int player2Money;


    @FXML
    public void settingsButton() throws IOException {
        JavaFXTemplate.setScene(2);
    }


    public void player1AnteClick(ActionEvent event) {
        TextField textfield = new TextField();
        textfield.setPromptText("Ante");
        Button tempButton = (Button)event.getSource();
        int indexOfButton = player1VBOX.getChildren().indexOf(tempButton);
        player1VBOX.getChildren().remove(tempButton);
        player1VBOX.getChildren().add(indexOfButton, textfield);

    }
}

