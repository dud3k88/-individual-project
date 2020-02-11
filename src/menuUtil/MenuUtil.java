package menuUtil;


import TicTacToe.MainController;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MenuUtil {

    public static MenuBar prepareMenu () {
        MenuBar menuBar = new MenuBar();

        Menu file = new Menu("File");
        MenuItem startGame = new MenuItem("Start New Game");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> MainController.exitApp());
        file.getItems().add(startGame);
        file.getItems().add(exit);


        Menu help = new Menu("Help");
        MenuItem rules = new MenuItem("Rules");
        help.getItems().add(rules);





        menuBar.getMenus().add(file);
        menuBar.getMenus().add(help);


        menuBar.setBackground(new Background(new BackgroundFill(Color.rgb(170, 170  , 170), CornerRadii.EMPTY, Insets.EMPTY)));
        menuBar.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));



        return menuBar;
    }
}