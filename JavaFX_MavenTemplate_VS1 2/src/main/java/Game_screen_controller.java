import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

public class Game_screen_controller {


    @FXML
    VBox player1VBOX;
    @FXML
    VBox player2VBOX;
    @FXML
    Button player1Confirm;
    @FXML
    Button player2Confirm;
    @FXML
    Button settingButtons;

    TextField player1AnteTextField;
    TextField player1PairPlusTextField;
    TextField player2AnteTextField;
    TextField player2PairPlusTextField;
    static int player1AnteBet;
    static int player2AnteBet;
    static int player1pairBet = 0;
    static int player2pairBet = 0;


    int player1Money;
    int player2Money;

    // The function for the settings
    @FXML
    public void settingsButton() throws IOException {
        JavaFXTemplate.setScene(2);
    }

    @FXML
    public void player1AnteClick(ActionEvent event) {
        player1AnteTextField = new TextField();
        player1AnteTextField.setPromptText("Ante Bet");
        player1SwapButtonWithTextFields(event, player1AnteTextField);
        player1Confirm.setDisable(false);

    }
    @FXML
    public void player1PairPlus(ActionEvent event) {
        player1PairPlusTextField = new TextField();
        player1PairPlusTextField.setPromptText("Pair Plus Bet");
        player1SwapButtonWithTextFields(event, player1PairPlusTextField);
    }
    // Swaps the button in the player 1's choices with a textfield when clicked
    public void player1SwapButtonWithTextFields(ActionEvent event, TextField textfield) {
        Button tempButton = (Button)event.getSource();
        int indexOfButton = player1VBOX.getChildren().indexOf(tempButton);
        player1VBOX.getChildren().remove(tempButton);
        player1VBOX.getChildren().add(indexOfButton, textfield);
    }

    @FXML
    public void player2AnteClick(ActionEvent event) {
        player2AnteTextField = new TextField();
        player2AnteTextField.setPromptText("Ante Bet");
        player2SwapButtonWithTextFields(event, player2AnteTextField);
        player2Confirm.setDisable(false);

    }
    @FXML
    public void player2PairPlus(ActionEvent event) {
        player2PairPlusTextField = new TextField();
        player2PairPlusTextField.setPromptText("Pair Plus Bet");
        player2SwapButtonWithTextFields(event, player2PairPlusTextField);
    }
    // Swaps the button in the player 2's choices with a textfield when clicked
    public void player2SwapButtonWithTextFields(ActionEvent event, TextField textfield) {
        Button tempButton = (Button)event.getSource();
        int indexOfButton = player2VBOX.getChildren().indexOf(tempButton);
        player2VBOX.getChildren().remove(tempButton);
        player2VBOX.getChildren().add(indexOfButton, textfield);
    }

    public void player1ReadyButton(ActionEvent event) {
        String anteBet = player1AnteTextField.getText();
        String pairBet;
        // checks if pairBet exists
        try {pairBet = player1PairPlusTextField.getText();}
        catch(Exception ignored) {pairBet = "FAILED";}


        if (anteBet == null || anteBet.isEmpty()) {return;}
        // Checks if Ante Bet isn't invalid
        for (char c : anteBet.toCharArray()) {
            if (!Character.isDigit(c)) {return;} // TODO: Lets put a pop-up here below the ready button saying the min bet isn't valid
        }
        // Checks if Ante bet > minimum
        if(Integer.parseInt(anteBet) < 5) {return;} // TODO: probably some feed that the bet is too low
        player1AnteBet = Integer.parseInt(anteBet);
        // If PairPlusBet is valid, then we go here and check stuff
        if (!Objects.equals(pairBet, "FAILED")) {
            for (char c : pairBet.toCharArray()) {
                if (!Character.isDigit(c)) {return;} // TODO: Lets put a pop-up here below the ready button saying the min bet isn't valid
            }
            if(Integer.parseInt(pairBet) < 5) {return;} // TODO: probably some feed that the bet is too low
            player1pairBet = Integer.parseInt(pairBet);
        }
        player1Confirm.setDisable(true);
        if (player2Confirm.isDisable()) {return;} //TODO: Move to the next step of the game

    }
    public void player2ReadyButton(ActionEvent event) {
        String anteBet = player2AnteTextField.getText();
        String pairBet;
        // checks if pairBet exists
        try {pairBet = player2PairPlusTextField.getText();}
        catch(Exception ignored) {pairBet = "FAILED";}


        if (anteBet == null || anteBet.isEmpty()) {return;}
        // Checks if Ante Bet isn't invalid
        for (char c : anteBet.toCharArray()) {
            if (!Character.isDigit(c)) {return;} // TODO: Lets put a pop-up here below the ready button saying the min bet isn't valid
        }
        // Checks if Ante bet > minimum
        if(Integer.parseInt(anteBet) < 5) {return;} // TODO: probably some feed that the bet is too low
        player2AnteBet = Integer.parseInt(anteBet);
        // If PairPlusBet is valid, then we go here and check stuff
        if (!Objects.equals(pairBet, "FAILED")) {
            for (char c : pairBet.toCharArray()) {
                if (!Character.isDigit(c)) {return;} // TODO: Lets put a pop-up here below the ready button saying the min bet isn't valid
            }
            if(Integer.parseInt(pairBet) < 5) {return;} // TODO: probably some feed that the bet is too low
            player2pairBet = Integer.parseInt(pairBet);
        }
        player2Confirm.setDisable(true);
        //this.printBets();
        if (player1Confirm.isDisable()) {return;} //TODO: Move to the next step of the game


    }

    // Prints out bet stats for testing
    public static void printBets() {
        System.out.println("Player 1:" + player1AnteBet + "," + player1pairBet);
        System.out.println("Player 2:" + player2AnteBet + "," + player2pairBet);
    }



}

