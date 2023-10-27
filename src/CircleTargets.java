import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;




import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class CircleTargets extends Application {

  @Override
  public void start(Stage primaryStage) {
    // create a pane
    Pane pane = new Pane();

    // create a red circle with radius 100
    Circle redCircle = new Circle();
    redCircle.setRadius(100);
    redCircle.setStroke(Color.RED);
    redCircle.setFill(Color.RED);

    // create a blue circle with radius 50
    Circle blueCircle = new Circle();
    blueCircle.setRadius(50);
    blueCircle.setStroke(Color.BLUE);
    blueCircle.setFill(Color.BLUE);

    // bind the centerX and centerY properties of both circles to the pane's width and height, divided by 2
    redCircle.centerXProperty().bind(pane.widthProperty().divide(2));
    redCircle.centerYProperty().bind(pane.heightProperty().divide(2));
    blueCircle.centerXProperty().bind(pane.widthProperty().divide(2));
    blueCircle.centerYProperty().bind(pane.heightProperty().divide(2));

    // create a horizontal line that crosses at the center of the circles
    Line hLine = new Line();
    hLine.setStroke(Color.BLACK);

    // bind the startX and endX properties of the horizontal line to 0 and the pane's width, respectively
    hLine.startXProperty().bind(pane.layoutXProperty());
    hLine.endXProperty().bind(pane.widthProperty());

    // bind the startY and endY properties of the horizontal line to the pane's height divided by 2
    hLine.startYProperty().bind(pane.heightProperty().divide(2));
    hLine.endYProperty().bind(pane.heightProperty().divide(2));

    // create a vertical line that crosses at the center of the circles
    Line vLine = new Line();
    vLine.setStroke(Color.BLACK);

    // bind the startX and endX properties of the vertical line to the pane's width divided by 2
    vLine.startXProperty().bind(pane.widthProperty().divide(2));
    vLine.endXProperty().bind(pane.widthProperty().divide(2));

    // bind the startY and endY properties of the vertical line to 0 and the pane's height, respectively
    vLine.startYProperty().bind(pane.layoutYProperty());
    vLine.endYProperty().bind(pane.heightProperty());

    // add the circles and lines to the pane
    pane.getChildren().addAll(redCircle, blueCircle, hLine, vLine);

    // create a scene with the pane
    Scene scene = new Scene(pane, 400, 400);

    // set the stage title and scene
    primaryStage.setTitle("RedBlueCircleWithLines");
    primaryStage.setScene(scene);

    // show the stage
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
