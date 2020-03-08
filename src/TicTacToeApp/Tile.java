package TicTacToeApp;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


class Tile extends StackPane {

    private ShapeValue shapeValue;
    private Image cross = new Image("file:src/resources/cross.png");
    private Image circle = new Image("file:src/resources/circle.png");


    public ShapeValue getShapeValue() {
        return shapeValue;
    }

    public void setShapeValue(ShapeValue shapeValue) {
        this.shapeValue = shapeValue;
    }

    Tile(ShapeValue shapeValue) {


        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(200);
        rectangle.setWidth(200);
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        setShapeValue(ShapeValue.EMPTY);
        setAlignment(Pos.CENTER);
        getChildren().add(rectangle);

        if (getShapeValue() == ShapeValue.EMPTY) {
            rectangle.setFill(null);
        }
        setOnMouseClicked(action -> {
            if (!TicTacToe.possibleMove){
            }
            if (TicTacToe.playerVsPlayer) {
                if (action.getButton() == MouseButton.PRIMARY) {
                    if (!TicTacToe.turnX || getShapeValue() == ShapeValue.CIRCLE || getShapeValue() == ShapeValue.CROSS) {
                        return;
                    }
                    {
                        rectangle.setFill(new ImagePattern(cross));
                        setShapeValue(ShapeValue.CROSS);
                        TicTacToe.turnX = false;
                        chcecStatusNow();
                    }
                }
                if (action.getButton() == MouseButton.SECONDARY) {
                    if (TicTacToe.turnX || getShapeValue() == ShapeValue.CROSS || getShapeValue() == ShapeValue.CIRCLE) {
                        return;
                    }
                    {
                        rectangle.setFill(new ImagePattern(circle));
                        setShapeValue(ShapeValue.CIRCLE);
                        TicTacToe.turnX = true;
                        chcecStatusNow();
                    }
                }
            }
            if (TicTacToe.playerVsComputer) {
                if (!TicTacToe.possibleMove) {
                    return;
                }
                if (action.getButton() == MouseButton.SECONDARY) {
                    return;
                }
                if (action.getButton() == MouseButton.PRIMARY) {
                    if (!TicTacToe.turnX || getShapeValue() == ShapeValue.CIRCLE || getShapeValue() == ShapeValue.CROSS) {
                        return;
                    }
                    rectangle.setFill(new ImagePattern(cross));
                    setShapeValue(ShapeValue.CROSS);
                    TicTacToe.turnX = false;
                    chcecStatusNow();
                    if (!TicTacToe.possibleMove) {
                        return;
                    }
                }
                List<Tile> tileList = Arrays.stream(TicTacToe.mainBoard.tiles)
                        .flatMap(array -> Arrays.stream(array))
                        .filter(field -> field.getShapeValue() == ShapeValue.EMPTY)
                        .collect(Collectors.toList());
                if (tileList.size() > 0) {
                    Tile tile = tileList.get(randomNumber(tileList.size()));
                    Rectangle node = (Rectangle) tile.getChildren().get(0);
                    tile.setShapeValue(ShapeValue.CIRCLE);
                    node.setFill(new ImagePattern(circle));
                    TicTacToe.turnX = true;
                    chcecStatusNow();
                }
            }
        });
    }

    public int randomNumber (int limit){
        Random generator = new Random();
        int random = generator.nextInt(limit);

        return random;
    }

    public void chcecStatusNow () {
        Result result = Status.chcecResult();
        if (result == Result.O_WINNER) {
            TicTacToe.playerO.setNumerator(TicTacToe.playerO.getNumerator() + 1);
            TicTacToe.counter.setText("X  [" + TicTacToe.playerX.getNumerator()
                    + "] : [" + TicTacToe.playerO.getNumerator() + "] O");
            TicTacToe.possibleMove = false;
            TicTacToe.label.setText("Winner O");
            TicTacToe.label.setTextFill(Color.GREEN);
            return;
        }
        if (result == Result.X_WINNER) {
            TicTacToe.playerX.setNumerator(TicTacToe.playerX.getNumerator() + 1);
            TicTacToe.counter.setText("X  [" + TicTacToe.playerX.getNumerator()
                    + "] : [" + TicTacToe.playerO.getNumerator() + "] O");
            TicTacToe.possibleMove = false;
            TicTacToe.label.setText("Winner X");
            TicTacToe.label.setTextFill(Color.RED);
        }
        if (result == Result.DRAW) {
            TicTacToe.possibleMove = false;
            TicTacToe.label.setText("Draw");
            return;
        }
        if (result == Result.DURING) {
            if (TicTacToe.turnX) {
                TicTacToe.label.setText("X TURN");
                TicTacToe.label.setTextFill(Color.RED);
                TicTacToe.label.setLayoutX(460);
            }
            if (!TicTacToe.turnX) {
                TicTacToe.label.setText("O TURN");
                TicTacToe.label.setTextFill(Color.GREEN);
                TicTacToe.label.setLayoutX(460);
            }
        }

    }
}







