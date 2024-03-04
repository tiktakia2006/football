package xyz.example.football.game_objects;
import javafx.scene.Node;

public abstract class BaseGameObject {

    Node node;

    double posX = 0;
    double posY = 0;

    double height = 100;
    double width = 100;

    public abstract void print();

    public abstract Node getNode();

}
