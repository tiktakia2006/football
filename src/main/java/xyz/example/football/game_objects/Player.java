package xyz.example.football.game_objects;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends AbstractDynamicObject {

    public Player(double posX, double posY) {
        height = 150;
        width = 80;

        Rectangle rectangle = new Rectangle();
        rectangle.setX(posX);
        rectangle.setY(posY);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        rectangle.setFill(Color.BROWN);

        node = rectangle;
    }

    @Override
    public void move() {

    }

    @Override
    public void print() {

    }

    @Override
    public Node getNode() {
        return node;
    }
}
