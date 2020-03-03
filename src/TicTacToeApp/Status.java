package TicTacToeApp;

import javafx.scene.shape.Rectangle;

public class Status {

    public static void resetGame (){

        Tile[][] tiles = TicTacToe.mainBoard.tiles;

        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                tiles[j][i].setShapeValue(ShapeValue.EMPTY);
                Rectangle rectangle = (Rectangle) tiles[j][i].getChildren().get(0);
                rectangle.setFill(null);
            }


        }
    }

    // Metoda sprawdzająca wygraną,
}
