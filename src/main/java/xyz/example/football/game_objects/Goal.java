package xyz.example.football.game_objects;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Goal extends BaseGameObject {

    public Goal(double posX, double posY) {
        height = 210;
        width = 95;

        Rectangle rectangle = new Rectangle();
        rectangle.setX(posX);
        rectangle.setY(posY);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        rectangle.setFill(Color.DARKVIOLET);

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
