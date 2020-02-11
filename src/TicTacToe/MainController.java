package TicTacToe;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    Button button00, button01, button02, button10, button11, button12, button20, button21, button22;
    @FXML
    Label mainLabelTxt;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        mainLabelTxt.setText("Welcome tic-tac-toe to the game. If you want to play press File/Start New Game");
    }



    public static void exitApp () {
        Platform.exit();
        System.exit(0);
    }

}
