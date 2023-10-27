import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class secHandAnimation extends Application {
  @Override
  public void start(Stage primaryStage) {
    // create a pane
    Pane pane = new Pane();

    // create a circle with radius 150 and center it on the stage
    Circle circle = new Circle(150, 150, 150);
    circle.setFill(Color.TRANSPARENT);
    circle.setStroke(Color.BLACK);

    // create an array of 100 lines, each with one end at the center of the circle
    // and the other end at a different angle on the circle
    Line[] lines = new Line[100];
    for (int i = 0; i < lines.length; i++) {
      // calculate the angle in radians
      double angle = Math.toRadians(i * 3.6);

      // calculate the endX and endY values using trigonometry
      double endX = 150 + 150 * Math.cos(angle);
      double endY = 150 + 150 * Math.sin(angle);

      // create a line with these values
      lines[i] = new Line(150, 150, endX, endY);
      lines[i].setStroke(Color.RED);
    }

    // create an array of 100 key frames, each with a duration of 0.1 seconds
    // and a key value that changes the endX and endY properties of the line
    // to match one of the lines in the array
    KeyFrame[] keyFrames = new KeyFrame[100];
    for (int i = 0; i < keyFrames.length; i++) {
      // create a key frame with these values
      keyFrames[i] = new KeyFrame(Duration.seconds(i * 0.1),
          new KeyValue(lines[0].endXProperty(), lines[i].getEndX()),
          new KeyValue(lines[0].endYProperty(), lines[i].getEndY()));
    }

    // create a timeline with these key frames and set it to cycle indefinitely
    Timeline timeline = new Timeline(keyFrames);
    timeline.setCycleCount(Timeline.INDEFINITE);

    // add the circle and the first line to the pane
    pane.getChildren().addAll(circle, lines[0]);

    // create a scene with the pane
    Scene scene = new Scene(pane, 300, 300);

    // set the stage title and scene
    primaryStage.setTitle("LineCircleAnimation");
    primaryStage.setScene(scene);

    // show the stage
    primaryStage.show();

    // play the timeline
    timeline.play();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
