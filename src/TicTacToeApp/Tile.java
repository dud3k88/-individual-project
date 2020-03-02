package TicTacToeApp;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;



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


        setAlignment(Pos.CENTER);
        getChildren().add(rectangle);


        if (getShapeValue() == ShapeValue.EMPTY) {
            rectangle.setFill(null);
        }


        setOnMouseClicked(action -> {
            if (TicTacToe.playerVsPlayer) {
                if (action.getButton() == MouseButton.PRIMARY){
                    if(!TicTacToe.turnX || getShapeValue()==ShapeValue.CIRCLE || getShapeValue()==ShapeValue.CROSS) {
                        return;
                    }
                    {
                     rectangle.setFill(new ImagePattern(cross));
                     setShapeValue(ShapeValue.CROSS);
                     TicTacToe.turnX = false;
                    }
                }

                if (action.getButton() == MouseButton.SECONDARY){
                    if (TicTacToe.turnX || getShapeValue()==ShapeValue.CROSS || getShapeValue()==ShapeValue.CIRCLE) {
                        return;
                    }
                    {
                     rectangle.setFill(new ImagePattern(circle));
                     setShapeValue(ShapeValue.CIRCLE);
                     TicTacToe.turnX = true;
                    }
                }
            }
        });

    }

    public void checkResult (){
    }
}







