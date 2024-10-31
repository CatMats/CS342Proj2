import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class QuitPopup {

    @FXML
    Label label;
    @FXML
    Button yesButton;
    @FXML
    Button noButton;

    @FXML
    public void quitProgram() {
        JavaFXTemplate.getPrimaryStage().close();
    }
    @FXML
    public void quitPopupWindow(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
