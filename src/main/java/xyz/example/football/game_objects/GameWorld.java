package xyz.example.football.game_objects;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static xyz.example.football.core.Constants.HEIGHT;
import static xyz.example.football.core.Constants.WIDTH;


public class GameWorld extends BaseGameObject {

    public GameWorld() {
        height = HEIGHT;
        width = WIDTH;


        Rectangle rectangle = new Rectangle();
        rectangle.setX(posX);
        rectangle.setY(posY);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        rectangle.setFill(Color.GREEN);

        node = rectangle;
    }

    @Override
    public void print() {

    }

    @Override
    public Node getNode() {
        return node;
    }

}
