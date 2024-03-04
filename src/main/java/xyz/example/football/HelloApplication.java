package xyz.example.football;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import xyz.example.football.game_objects.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import static xyz.example.football.core.Constants.HEIGHT;
import static xyz.example.football.core.Constants.WIDTH;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Pane pane = new Pane();
        pane.setMaxWidth(WIDTH);
        pane.setMaxHeight(HEIGHT);

        Image image = new Image(new FileInputStream("src/main/java/images/football_preview.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
        imageView.setFitWidth(WIDTH);
        imageView.setFitHeight(HEIGHT);
        pane.getChildren().add(imageView);

        Button button = new Button("START GAME");
        button.setLayoutX(1100);
        button.setLayoutY(100);
        button.setPrefWidth(200);
        button.setPrefHeight(50);
        button.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: black;");
        button.setOnAction(actionEvent -> {
            button.setVisible(false);
            addGameObjects(pane);
        });
        pane.getChildren().add(button);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setTitle("FOOTBALL");
        stage.setScene(scene);
        stage.show();
    }


    private void addGameObjects(Pane pane) {
        GameWorld gameWorld = new GameWorld();
        Goal goal1 = new Goal(40, 300);
        Goal goal2 = new Goal(1405, 300);
        Ball ball = new Ball(775, 400);
        Player player1 = new Player(600, 320);
        Player player2 = new Player(865, 320);

                               //FieldLines fieldLines = new FieldLines(); ???
                               //fieldLines.addLines(pane);                ???

        List<BaseGameObject> gameObjectList = new ArrayList<>();
        gameObjectList.add(gameWorld);
        gameObjectList.add(goal1);
        gameObjectList.add(goal2);
        gameObjectList.add(ball);
        gameObjectList.add(player1);
        gameObjectList.add(player2);

        for (BaseGameObject gameObject : gameObjectList) {
            pane.getChildren().add(gameObject.getNode());
        }

        addKeyEventHandlers(pane, player1.getNode(), player2.getNode(), ball.getNode());
    }

    private void addKeyEventHandlers(Pane pane, Node player1Node, Node player2Node, Node ballNode) {
        pane.getScene().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    player1Node.setLayoutY(player1Node.getLayoutY() - 5);
                    ballNode.setLayoutY(ballNode.getLayoutY() - 5);
                    break;
                case S:
                    player1Node.setLayoutY(player1Node.getLayoutY() + 5);
                    ballNode.setLayoutY(ballNode.getLayoutY() + 5);
                    break;
                case A:
                    player1Node.setLayoutX(player1Node.getLayoutX() - 5);
                    ballNode.setLayoutX(ballNode.getLayoutX() - 5);
                    break;
                case D:
                    player1Node.setLayoutX(player1Node.getLayoutX() + 5);
                    ballNode.setLayoutX(ballNode.getLayoutX() + 5);
                    break;
                case NUMPAD8:
                    player2Node.setLayoutY(player2Node.getLayoutY() - 5);
                    ballNode.setLayoutY(ballNode.getLayoutY() - 5);
                    break;
                case NUMPAD2:
                    player2Node.setLayoutY(player2Node.getLayoutY() + 5);
                    ballNode.setLayoutY(ballNode.getLayoutY() + 5);
                    break;
                case NUMPAD4:
                    player2Node.setLayoutX(player2Node.getLayoutX() - 5);
                    ballNode.setLayoutX(ballNode.getLayoutX() - 5);
                    break;
                case NUMPAD6:
                    player2Node.setLayoutX(player2Node.getLayoutX() + 5);
                    ballNode.setLayoutX(ballNode.getLayoutX() + 5);
                    break;
                case SPACE:
                    ballNode.setLayoutX(1455);
                    ballNode.setLayoutY(409);
                    break;
                case SHIFT:
                    ballNode.setLayoutX(86);
                    ballNode.setLayoutY(409);
                    break;
            }
            if ((ballNode.getLayoutX() == 1455 && ballNode.getLayoutY() == 409) ||
                    (ballNode.getLayoutX() == 86 && ballNode.getLayoutY() == 409)) {
                try {
                    Image image = new Image(new FileInputStream("src/main/java/images/img.png"));
                    ImageView imageView = new ImageView(image);
                    imageView.setLayoutX(50);
                    imageView.setLayoutY(50);
                    imageView.setFitWidth(200);
                    imageView.setFitHeight(100);
                    pane.getChildren().add(imageView);

                    FadeTransition ft = new FadeTransition(Duration.seconds(5), imageView);
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setAutoReverse(false);
                    ft.play();
                } catch (FileNotFoundException e) {
                    System.err.println(e.getMessage());
                }
            }
        });
    }
    public static void main(String[] args) { launch(args); }
}