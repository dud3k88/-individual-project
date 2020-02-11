package TicTacToe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import menuUtil.MenuUtil;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("main.fxml"));

        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);


        stackPane.getChildren().add(MenuUtil.prepareMenu());
        stackPane.setAlignment(Pos.TOP_CENTER);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setOnCloseRequest(event -> MainController.exitApp());
        primaryStage.setHeight(700.0);
        primaryStage.setWidth(600.0);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
