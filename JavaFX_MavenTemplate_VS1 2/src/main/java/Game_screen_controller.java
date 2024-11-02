import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Game_screen_controller {
    @FXML
    Button settingButtons;

    @FXML
    public void settingsButton() throws IOException {
        JavaFXTemplate.setScene(2);
    }
}

