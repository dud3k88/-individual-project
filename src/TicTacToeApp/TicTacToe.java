package TicTacToeApp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.stream.Collectors;


public class TicTacToe extends Application {

    public static MainBoard mainBoard = new MainBoard();
    public static Label label = new Label();
    public static boolean playerVsPlayer = false;
    public static boolean turnX = true;
    public static Numerator playerX = new Numerator(0);
    public static Numerator playerO = new Numerator(0);
    public static Label counter = new Label();


    private static Parent createScene (){
        Pane root = new Pane();
        root.setPrefSize(600, 702);

        Button reset = new Button();
        reset.setText("RESET");
        reset.setFont(new Font(15));
        reset.setLayoutX(200);
        reset.setLayoutY(602);
        reset.setPrefSize(200, 50);
        reset.setOnAction(event -> Status.resetGame());

        Button playerVsComp = new Button();
        playerVsComp.setText("PLAYER vs COMPUTER");
        playerVsComp.setWrapText(true);
        playerVsComp.setFont(new Font(15));
        playerVsComp.setLayoutX(0);
        playerVsComp.setLayoutY(602);
        playerVsComp.setPrefSize(200,50);


        Button plaVsPlayer = new Button();
        plaVsPlayer.setText("PLAYER vs PLAYER");
        plaVsPlayer.setWrapText(true);
        plaVsPlayer.setFont(new Font(15));
        plaVsPlayer.setLayoutX(0);
        plaVsPlayer.setLayoutY(652);
        plaVsPlayer.setPrefSize(200, 50);
        plaVsPlayer.setOnAction(action -> {
            playerVsPlayer = true;
            playerX.setNumerator(0);
            playerO.setNumerator(0);
            counter.setText("X " + playerO.getNumerator() + " " + playerO.getNumerator());

        });


        Button exit = new Button();
        exit.setText("EXIT");
        exit.setFont(new Font(15));
        exit.setLayoutX(200);
        exit.setLayoutY(652);
        exit.setPrefSize(200, 50);
        exit.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });

        label.setText("Hello");
        label.setTextFill(Color.RED);
        label.setFont(new Font(20));
        label.setLayoutX(470);
        label.setLayoutY(640);
        label.setAlignment(Pos.CENTER);


        root.getChildren().addAll(Arrays.stream(mainBoard.tiles).flatMap(Arrays::stream).collect(Collectors.toList()));
        root.getChildren().addAll(reset, playerVsComp, plaVsPlayer, exit, label);


        return root;
    }



    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(TicTacToe.createScene());
        primaryStage.setTitle("TIC TAC TOE");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
