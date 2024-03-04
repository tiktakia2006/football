package xyz.example.football.game_objects;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends AbstractDynamicObject {

    public Ball(double posX, double posY) {
        height = 70;
        width = 70;

        Circle circle = new Circle(50);
        circle.setLayoutX(posX);
        circle.setLayoutY(posY);
        circle.setRadius(height / 2);
        circle.setFill(Color.ROSYBROWN);

        node = circle;
    }

    @Override
    public void print() {

    }

    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public void move() {

    }

    void kick() {

    }
}
