import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Game_screen_controller implements Initializable {


    @FXML
    public Label dealerLabel;
    @FXML
    public Label player1Label;
    @FXML
    public Button player1Ante;
    @FXML
    public Label player2Label;
    @FXML
    public Button player2Ante;
    @FXML
    public HBox player1EmptyCards;
    @FXML
    public HBox player2EmptyCards;
    @FXML
    public HBox dealerEmptyCards;
    @FXML
    public Line horizontalLine;
    @FXML
    public Line middleVerticalLine;
    @FXML
    public VBox player1PlayVbox;
    @FXML
    public Label player1Label2;
    @FXML
    public HBox player1PlayBet;
    @FXML
    public Button player1PlayButton;
    @FXML
    public Button player1HoldButton;
    @FXML
    public VBox player2PlayVbox;
    @FXML
    public Label player2Label2;
    @FXML
    public HBox player2PlayBet;
    @FXML
    public Button player2PlayButton;
    @FXML
    public Button player2HoldButton;
    @FXML
    public HBox dealerHand;
    @FXML
    public Label gameStatus;
    @FXML
    public Button continueButton;
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
    Label player1WinningsLabel;
    @FXML
    Label player2WinningsLabel;
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


    static Player player1;
    static Player player2;
    static Dealer dealer;
    boolean player1PlayStatus;
    boolean player2PlayStatus;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        player1 = new Player();
        player2 = new Player();
        dealer = new Dealer();


        player1.totalWinnings = 0;
        player2.totalWinnings = 0;
    }



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

        player1.anteBet = Integer.parseInt(anteBet);

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
            player1.pairPlusBet = Integer.parseInt(pairBet);
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
        if (player2Confirm.isDisable() && player2.anteBet > 0) {
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
        player2.anteBet = Integer.parseInt(anteBet);
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
            player2.pairPlusBet = Integer.parseInt(pairBet);
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
        if (player1Confirm.isDisable() && player1.anteBet > 0) {
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
        System.out.println("Player 1:" + player1.anteBet + "," + player1.pairPlusBet);
        System.out.println("Player 2:" + player2.anteBet + "," + player2.pairPlusBet);
    }

    // Selects and attempts to display all of the cards for a players' hand
    public void selectCards() {
        //for(int i = 0; i < 3; i++) {player1.hand.add(theDeck.takeCardFromDeck());}
        //for(int i = 0; i < 3; i++) {player2.hand.add(theDeck.takeCardFromDeck());}
        ArrayList<Card> dealtHand = new ArrayList<>();
        dealtHand = dealer.dealHand();
        for(int i = 0; i < 3; i++) {
            player1.hand.add(dealtHand.get(i));
        }
        ArrayList<Card> dealt2Hand = new ArrayList<>();
        dealt2Hand = dealer.dealHand();
        for(int i = 0; i < 3; i++) {
            player2.hand.add(dealt2Hand.get(i));
        }

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
            //System.out.println(name_of_file);
            Image cardImage = new Image(Objects.requireNonNull(Objects.requireNonNull(JavaFXTemplate.class.getResource("/cards/" + name_of_file)).toExternalForm()));;
            ImageView card = new ImageView();
            card.setImage(cardImage);
            card.setPreserveRatio(true);
            card.setFitHeight(130);
            card.setFitWidth(130);
            int duration = 1000 * (i + 1);
            PauseTransition delay = new PauseTransition(Duration.millis(duration));
            int finalI = i;
            delay.setOnFinished(event -> {player1Hand.getChildren().add(finalI, card);});
            delay.play();
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
            //System.out.println(name_of_file);
            Image cardImage = new Image(Objects.requireNonNull(Objects.requireNonNull(JavaFXTemplate.class.getResource("/cards/" + name_of_file)).toExternalForm()));;
            ImageView card = new ImageView();
            card.setImage(cardImage);
            card.setPreserveRatio(true);
            card.setFitHeight(130);
            card.setFitWidth(130);
            int duration = 1000 * (i + 1);
            PauseTransition delay = new PauseTransition(Duration.millis(duration));
            int finalI = i;
            delay.setOnFinished(event -> {player2Hand.getChildren().add(finalI, card);});
            delay.play();
        }
        PauseTransition pause = new PauseTransition(Duration.millis(4000));
        pause.setOnFinished(event -> {setUpPlayBet();});
        pause.play();

    }

    // Setups the game screen for a play bet and hides all old ui elements
    public void setUpPlayBet() {
        swapGamePhases(false);

    }

    // Swaps between setting up Play Bet with the Ante/Pair Bet
    public void swapGamePhases(boolean value) {
        player1VBOX.setVisible(value);
        player2VBOX.setVisible(value);
        player1WarningLabel.setVisible(value);
        player2WarningLabel.setVisible(value);
        player1PlayVbox.setVisible(!value);
        player2PlayVbox.setVisible(!value);
    }

    // Sets the respective player with the respective status
    public void setPlayer1PlayButton() {
        player1PlayStatus = true;
        player1PlayButton.setDisable(true);
        player1HoldButton.setDisable(true);
        player1.playBet = player1.anteBet;
        if (player2PlayButton.isDisable()) {setDealershand();}
    }
    public void setPlayer1HoldButton() {
        player1PlayStatus = false;
        player1PlayButton.setDisable(true);
        player1HoldButton.setDisable(true);
        player1.totalWinnings += -1 * (player1.anteBet += player1.pairPlusBet);
        updatePlayerWinningsLabel();
        if (player2PlayButton.isDisable()) {setDealershand();}
    }
    public void setPlayer2PlayButton() {
        player2PlayStatus = true;
        player2PlayButton.setDisable(true);
        player2HoldButton.setDisable(true);
        player2.playBet = player2.anteBet;
        if (player1PlayButton.isDisable()) {setDealershand();}
    }
    public void setPlayer2HoldButton() {
        player2PlayStatus = false;
        player2PlayButton.setDisable(true);
        player2HoldButton.setDisable(true);
        player2.totalWinnings += -1 * (player2.anteBet += player2.pairPlusBet);
        updatePlayerWinningsLabel();
        if (player1PlayButton.isDisable()) {setDealershand();}
    }

    // Updates the labels for winnings when called
    public void updatePlayerWinningsLabel() {
        player1WinningsLabel.setText("Total Winnings: " + player1.totalWinnings);
        player2WinningsLabel.setText("Total Winnings: " + player2.totalWinnings);
    }

    // Sets up the Dealer hand logically & visually
    public void setDealershand() {
        player1PlayVbox.setVisible(false);
        player2PlayVbox.setVisible(false);
        dealer.dealersHand = dealer.dealHand();
        for (int i = 0; i < 3; i++) {
            // First we gotta get the file of the card in the players hand so lets do that
            String name_of_file = "";
            switch (dealer.dealersHand.get(i).getValue()) {
                case 2:
                    name_of_file += "2";
                    break;
                case 3:
                    name_of_file += "3";
                    break;
                case 4:
                    name_of_file += "4";
                    break;
                case 5:
                    name_of_file += "5";
                    break;
                case 6:
                    name_of_file += "6";
                    break;
                case 7:
                    name_of_file += "7";
                    break;
                case 8:
                    name_of_file += "8";
                    break;
                case 9:
                    name_of_file += "9";
                    break;
                case 10:
                    name_of_file += "10";
                    break;
                case 11:
                    name_of_file += "jack";
                    break;
                case 12:
                    name_of_file += "queen";
                    break;
                case 13:
                    name_of_file += "king";
                    break;
                case 14:
                    name_of_file += "ace";
                    break;
            }
            name_of_file += "_of_";

            switch (dealer.dealersHand.get(i).getSuit()) {
                case 'C':
                    name_of_file += "clubs";
                    break;
                case 'D':
                    name_of_file += "diamonds";
                    break;
                case 'H':
                    name_of_file += "hearts";
                    break;
                case 'S':
                    name_of_file += "spades";
                    break;
            }
            name_of_file += ".png";
            //System.out.println(name_of_file);
            Image cardImage = new Image(Objects.requireNonNull(Objects.requireNonNull(JavaFXTemplate.class.getResource("/cards/" + name_of_file)).toExternalForm()));
            ;
            ImageView card = new ImageView();
            card.setImage(cardImage);
            card.setPreserveRatio(true);
            card.setFitHeight(130);
            card.setFitWidth(130);
            int duration = 1000 * (i + 1);
            PauseTransition delay = new PauseTransition(Duration.millis(duration));
            int finalI = i;
            delay.setOnFinished(event -> {dealerHand.getChildren().add(finalI, card);});
            delay.play();
        }
        PauseTransition delay = new PauseTransition(Duration.millis(4000));
        delay.setOnFinished(event -> {calculateResults();});
        delay.play();

    }

    // Checks to see which bets were won and which ones are lost
    public void calculateResults() {
        // if player1 chose to play
        String status = "";
        if(player1PlayStatus == true) {
            switch (ThreeCardLogic.compareHands(dealer.dealersHand, player1.hand)) {
                case 2: {
                    status += "Player 1 has won the Ante Bet!\n";
                    player1.totalWinnings += player1.anteBet * 2 + player1.pairPlusBet * 2;
                    break;
                }
                case 0: {
                    status += "Player 1 has lost the Ante Bet!\n";
                    player1.totalWinnings += -1 * (player1.anteBet + player1.playBet);
                    break;
                }
            }
            int pairPlusWinnings = ThreeCardLogic.evalPPWinnings(player1.hand, player1.pairPlusBet);
            // Checks if the player has placed a bet and they didn't hold
            if (ThreeCardLogic.evalPPWinnings(player1.hand, player1.pairPlusBet) > 0) {
                if (ThreeCardLogic.evalPPWinnings(player1.hand, player1.pairPlusBet) > 0 && player1PlayStatus) {
                    status += "Player 1 has won the Pair Plus Bet!\n";
                    player1.totalWinnings += pairPlusWinnings;
                } else if (ThreeCardLogic.evalPPWinnings(player1.hand, player1.pairPlusBet) > 0 && !player1PlayStatus) {
                    status += "Player 1 would have won the Pair Plus Bet if they stayed...\n";
                } else {
                    status += "Player 1 has lost the Pair Plus Bet!\n";
                    player1.totalWinnings += -1 * (player1.pairPlusBet);
                }
            }
        }
        if(player2PlayStatus == true) {
            switch (ThreeCardLogic.compareHands(dealer.dealersHand, player2.hand)) {
                case 2: {
                    status += "Player 2 has won the Ante Bet!\n";
                    player2.totalWinnings += player2.anteBet * 2 + player2.pairPlusBet * 2;
                    break;
                }
                case 0: {
                    status += "Player 2 has lost the Ante Bet!\n";
                    player2.totalWinnings += -1 * (player2.anteBet + player2.playBet);
                    break;
                }
            }
            int pairPlusWinnings = ThreeCardLogic.evalPPWinnings(player2.hand, player2.pairPlusBet);
            // Checks if the player has placed a bet and they didn't hold
            if (ThreeCardLogic.evalPPWinnings(player1.hand, player1.pairPlusBet) > 0) {
                if (ThreeCardLogic.evalPPWinnings(player2.hand, player2.pairPlusBet) > 0 && player2PlayStatus) {
                    status += "Player 2 has won the Pair Plus Bet!\n";
                    player2.totalWinnings += pairPlusWinnings;
                } else if (ThreeCardLogic.evalPPWinnings(player2.hand, player2.pairPlusBet) > 0 && !player2PlayStatus) {
                    status += "Player 2 would have won the Pair Plus Bet if they stayed...\n";
                } else {
                    status += "Player 2 has lost the Pair Plus Bet!\n";
                    player2.totalWinnings += -1 * (player2.pairPlusBet);
                }
            }

        }
        gameStatus.setText(status);
        continueButton.setDisable(false);
        updatePlayerWinningsLabel();
    }

    // Resets the game for the next round!
    public void restartGame() {
        continueButton.setDisable(true);
        player1.hand.clear();
        player1.pairPlusBet = 0;
        player1.playBet = 0;
        player1.anteBet = 0;

        player2.hand.clear();
        player2.pairPlusBet = 0;
        player2.playBet = 0;
        player2.anteBet = 0;
        dealer.dealersHand.clear();
        swapGamePhases(true);

        player1AnteTextField.setDisable(false);
        player1PairPlus.setDisable(false);
        try {
            player1PairPlusTextField.setDisable(false);
        } catch (Exception e) {
            ;
        }
        player1Confirm.setDisable(false);
        player1PlayButton.setDisable(false);
        player1HoldButton.setDisable(false);
        player2AnteTextField.setDisable(false);
        player2PairPlus.setDisable(false);
        try {
            player2PairPlusTextField.setDisable(false);
        } catch (Exception e) {
            ;
        }
        player2Confirm.setDisable(false);
        player2PlayButton.setDisable(false);
        player2HoldButton.setDisable(false);

        gameStatus.setText("");


        player1Hand.getChildren().clear();
        player2Hand.getChildren().clear();
        dealerHand.getChildren().clear();

        gameStatus.setText("");

    }

}

