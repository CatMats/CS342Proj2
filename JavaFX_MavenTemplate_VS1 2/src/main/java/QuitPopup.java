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

    public void quitProgram(ActionEvent event) {
        JavaFXTemplate.getPrimaryStage().close();
    }
    public void quitPopupWindow(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
