package xyz.example.football.game_objects;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class FieldLines extends BaseGameObject {

    public FieldLines() {
    }

    @Override
    public void print() {
    }

    @Override
    public Node getNode() {
        return node;
    }

    public void addLines(Pane pane) {
        for (int x = 100; x <= 1400; x += 200) {
            Line line = new Line(x, 0, x, 790);
            line.setStroke(Color.WHITE);
            line.setStrokeWidth(10);
            pane.getChildren().add(line);
        }

        for (int y = 100; y <= 700; y += 200) {
            Line line = new Line(0, y, 1540, y);
            line.setStroke(Color.WHITE);
            line.setStrokeWidth(10);
            pane.getChildren().add(line);
        }
    }
}
