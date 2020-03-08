package TicTacToeApp;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class Status {

    public static void resetGame (){

        Tile[][] tiles = TicTacToe.mainBoard.tiles;

        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                tiles[i][j].setShapeValue(ShapeValue.EMPTY);
                Rectangle rectangle = (Rectangle) tiles[i][j].getChildren().get(0);
                rectangle.setFill(Color.WHITE);


            }
        }
        TicTacToe.possibleMove = true;
        TicTacToe.playerVsPlayer = false;
        TicTacToe.playerVsComputer = false;
        TicTacToe.turnX = true;
        TicTacToe.label.setText("Start New Game");
        TicTacToe.label.setLayoutX(435);
    }

    public static Result chcecResult (){
        Tile[][] tiles = TicTacToe.mainBoard.tiles;
        for (int i = 0; i <3; i++) {
            if (tiles[0][i].getShapeValue() == tiles[1][i].getShapeValue()
            && tiles[0][i].getShapeValue() == tiles[2][i].getShapeValue()) {
                if (tiles[0][i].getShapeValue() == ShapeValue.CIRCLE){
                    return Result.O_WINNER;
                }else if (tiles[0][i].getShapeValue() == ShapeValue.CROSS){
                    return Result.X_WINNER;
                }
            }
        }
        for (int j = 0; j <3; j++) {
            if (tiles[j][0].getShapeValue() == tiles[j][1].getShapeValue()
            && tiles[j][0].getShapeValue() == tiles[j][2].getShapeValue()){
                if (tiles[j][0].getShapeValue() == ShapeValue.CIRCLE){
                    return Result.O_WINNER;
                }else if (tiles[j][0].getShapeValue() == ShapeValue.CROSS){
                    return Result.X_WINNER;
                }
            }
        }
        if (tiles[0][0].getShapeValue() == tiles[1][1].getShapeValue()
        && tiles[0][0].getShapeValue() == tiles[2][2].getShapeValue()){
            if (tiles[0][0].getShapeValue() == ShapeValue.CIRCLE){
                return Result.O_WINNER;
            }else if (tiles[0][0].getShapeValue() == ShapeValue.CROSS){
                return Result.X_WINNER;
            }
        }

        if (tiles[2][0].getShapeValue() == tiles[1][1].getShapeValue() &&
                tiles[2][0].getShapeValue() == tiles[0][2].getShapeValue()) {
            if (tiles[2][0].getShapeValue() == ShapeValue.CIRCLE) {
                return Result.O_WINNER;
            } else if (tiles[2][0].getShapeValue() == ShapeValue.CROSS) {
                return Result.X_WINNER;
            }
        }

        boolean isEmpty = false;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (tiles[x][y].getShapeValue() == ShapeValue.EMPTY) {
                    isEmpty = true;
                }
            }
        }
        if (!isEmpty) {
            return Result.DRAW;
        }
        return Result.DURING;
    }
}

