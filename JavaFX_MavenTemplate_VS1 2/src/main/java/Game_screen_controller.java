import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class Game_screen_controller {


    @FXML
    VBox player1VBOX;
    @FXML
    VBox player2VBOX;
    @FXML
    Button player1PairPlus;
    @FXML
    Button player2PairPlus;
    @FXML
    Button player1Confirm;
    @FXML
    Button player2Confirm;
    @FXML
    Label player1WarningLabel;
    @FXML
    Label player2WarningLabel;
    @FXML
    HBox player1Hand;
    @FXML
    HBox player2Hand;

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

    static Deck theDeck;
    static Player player1;
    static Player player2;
    // The function for the settings
    @FXML
    public void settingsButton() throws IOException {
        JavaFXTemplate.setScene(2);
    }

    @FXML
    public void player1AnteClick(ActionEvent event) {
        player1AnteTextField = new TextField();
        player1AnteTextField.setPrefWidth(110);
        player1AnteTextField.setPromptText("Ante Bet");
        player1SwapButtonWithTextFields(event, player1AnteTextField);
        player1Confirm.setDisable(false);

    }
    @FXML
    public void player1PairPlus(ActionEvent event) {
        player1PairPlusTextField = new TextField();
        player1PairPlusTextField.setPrefWidth(110);
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
        player2AnteTextField.setPrefWidth(110);
        player2AnteTextField.setPromptText("Ante Bet");
        player2SwapButtonWithTextFields(event, player2AnteTextField);
        player2Confirm.setDisable(false);

    }
    @FXML
    public void player2PairPlus(ActionEvent event) {
        player2PairPlusTextField = new TextField();
        player2PairPlusTextField.setPrefWidth(110);
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
            if (!Character.isDigit(c)) {
                setPlayerWarningText("Ante Bet was invalid! \nPlease put only digits for a bet!",1);
                return;
            }
        }

        // Checks if Ante bet > minimum
        if(Integer.parseInt(anteBet) < 5) {
            setPlayerWarningText("Ante Bet is too low! \nMinimum bet is $5!",1);
            return;
        }

        player1AnteBet = Integer.parseInt(anteBet);

        // If PairPlusBet is valid, then we go here and check stuff
        if (!Objects.equals(pairBet, "FAILED")) {
            for (char c : pairBet.toCharArray()) {
                if (!Character.isDigit(c)) {
                    setPlayerWarningText("Pair Plus Bet was invalid! \nPlease put only digits for a bet!",1);
                    return;}
            }
            if(Integer.parseInt(pairBet) < 5 && Integer.parseInt(pairBet) > 0) {
                setPlayerWarningText("Pair Plus Bet is too low! \nMinimum bet is $5!",1);
                return;
            }
            player1pairBet = Integer.parseInt(pairBet);
        }

        player1Confirm.setDisable(true);
        player1AnteTextField.setDisable(true);
        try {
            player1PairPlusTextField.setDisable(true);
        }
        catch (Exception e) {
            player1PairPlus.setDisable(true);
        }
        setPlayerWarningText("",1);
        if (player2Confirm.isDisable() && player2AnteBet > 0) {
            selectCards();
            return;
        }

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
            if (!Character.isDigit(c)) {
                setPlayerWarningText("Ante Bet was invalid! \nPlease put only digits for a bet!",2);
                return;
            }
        }
        // Checks if Ante bet > minimum
        if(Integer.parseInt(anteBet) < 5) {
            setPlayerWarningText("Ante Bet is too low! \nMinimum bet is $5!",2);
            return;
        }
        player2AnteBet = Integer.parseInt(anteBet);
        // If PairPlusBet is valid, then we go here and check stuff
        if (!Objects.equals(pairBet, "FAILED")) {
            for (char c : pairBet.toCharArray()) {
                if (!Character.isDigit(c)) {
                    setPlayerWarningText("Pair Plus bet was invalid! \nPlease put only digits for a bet!",2);
                    return;
                }
            }
            if(Integer.parseInt(pairBet) < 5 && Integer.parseInt(pairBet) > 0) {
                setPlayerWarningText("Pair Plus Bet is too low! \nMinimum bet is $5!",2);
                return;
            }
            player2pairBet = Integer.parseInt(pairBet);
        }
        player2Confirm.setDisable(true);
        player2AnteTextField.setDisable(true);
        try {
            player2PairPlusTextField.setDisable(true);
        }
        catch (Exception e) {
            player2PairPlus.setDisable(true);
        }
        //this.printBets();
        setPlayerWarningText("",2);
        if (player1Confirm.isDisable() && player1AnteBet > 0) {
            selectCards();
            return;
        }
    }

    // Sets the warning text for a player.  Called from hitting the confirm button and alerts the player that something has gone wrong
    public void setPlayerWarningText(String warning, int player) {
        if (player == 1) {
            player1WarningLabel.setText(warning);
        } else {
            player2WarningLabel.setText(warning);
        }
    }


    // Prints out bet stats for testing
    public static void printBets() {
        System.out.println("Player 1:" + player1AnteBet + "," + player1pairBet);
        System.out.println("Player 2:" + player2AnteBet + "," + player2pairBet);
    }


    // Selects and attempts to display all of the cards for a players' hand
    public void selectCards() {
        theDeck = new Deck();
        player1 = new Player();
        player2 = new Player();
        player1.anteBet = player1AnteBet;
        player1.playBet = player1pairBet;
        player2.anteBet = player2AnteBet;
        player2.playBet = player2pairBet;
        player1.totalWinnings = player1Money;
        player2.totalWinnings = player2Money;
        for(int i = 0; i < 3; i++) {player1.hand.add(theDeck.takeCardFromDeck());}
        for(int i = 0; i < 3; i++) {player2.hand.add(theDeck.takeCardFromDeck());}

        for(int i = 0; i < 3; i++) {
            // First we gotta get the file of the card in the players hand so lets do that
            String name_of_file = "";
            switch (player1.hand.get(i).getValue()) {
                case 2: name_of_file += "2"; break;
                case 3: name_of_file += "3"; break;
                case 4: name_of_file += "4"; break;
                case 5: name_of_file += "5"; break;
                case 6: name_of_file += "6"; break;
                case 7: name_of_file += "7"; break;
                case 8: name_of_file += "8"; break;
                case 9: name_of_file += "9"; break;
                case 10: name_of_file += "10"; break;
                case 11: name_of_file += "jack"; break;
                case 12: name_of_file += "queen"; break;
                case 13: name_of_file += "king"; break;
                case 14: name_of_file += "ace"; break;
            }
            name_of_file += "_of_";

            switch (player1.hand.get(i).getSuit()) {
                case 'C': name_of_file += "clubs"; break;
                case 'D': name_of_file += "diamonds"; break;
                case 'H': name_of_file += "hearts"; break;
                case 'S': name_of_file += "spades"; break;
            }
            name_of_file += ".png";
            System.out.println(name_of_file);
            Image cardImage = new Image(Objects.requireNonNull(Objects.requireNonNull(JavaFXTemplate.class.getResource("/cards/" + name_of_file)).toExternalForm()));;
            ImageView card = new ImageView();
            card.setImage(cardImage);
            card.setPreserveRatio(true);
            card.setFitHeight(130);
            card.setFitWidth(130);
            player1Hand.getChildren().add(i, card);
            //PauseTransition delay = new PauseTransition(Duration.millis(1000));
            //delay.setOnFinished(event -> continue;)
            //delay.play();
        }
        for(int i = 0; i < 3; i++) {
            // First we gotta get the file of the card in the players hand so lets do that
            String name_of_file = "";
            switch (player2.hand.get(i).getValue()) {
                case 2: name_of_file += "2"; break;
                case 3: name_of_file += "3"; break;
                case 4: name_of_file += "4"; break;
                case 5: name_of_file += "5"; break;
                case 6: name_of_file += "6"; break;
                case 7: name_of_file += "7"; break;
                case 8: name_of_file += "8"; break;
                case 9: name_of_file += "9"; break;
                case 10: name_of_file += "10"; break;
                case 11: name_of_file += "jack"; break;
                case 12: name_of_file += "queen"; break;
                case 13: name_of_file += "king"; break;
                case 14: name_of_file += "ace"; break;
            }
            name_of_file += "_of_";

            switch (player2.hand.get(i).getSuit()) {
                case 'C': name_of_file += "clubs"; break;
                case 'D': name_of_file += "diamonds"; break;
                case 'H': name_of_file += "hearts"; break;
                case 'S': name_of_file += "spades"; break;
            }
            name_of_file += ".png";
            System.out.println(name_of_file);
            Image cardImage = new Image(Objects.requireNonNull(Objects.requireNonNull(JavaFXTemplate.class.getResource("/cards/" + name_of_file)).toExternalForm()));;
            ImageView card = new ImageView();
            card.setImage(cardImage);
            card.setPreserveRatio(true);
            card.setFitHeight(130);
            card.setFitWidth(130);
            player2Hand.getChildren().add(i, card);
        }

    }

}

