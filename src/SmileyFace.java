// import the javafx libraries
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

// create a class that extends Application
public class SmileyFace extends Application {

    // override the start method
    @Override
    public void start(Stage primaryStage) {

        // create a pane to hold the shapes
        Pane pane = new Pane();

        // create a circle for the face
        Circle face = new Circle(200, 200, 150);
        face.setFill(Color.WHITE);
        face.setStroke(Color.BLACK);

        // create two ellipses and circles for the eyes
        Ellipse leftEye = new Ellipse(140, 150, 30,20);
        Circle leftPupil= new Circle(142,150,18);
        leftEye.setFill(Color.WHITE);
        leftEye.setStroke(Color.BLACK);
        Ellipse rightEye = new Ellipse(260, 150, 30,20);
        Circle rightPupil= new Circle(262,150,18);
        
        rightEye.setFill(Color.WHITE);
        rightEye.setStroke(Color.BLACK);

        //create a nose
        // create a polygon for the nose
        Polygon nose = new Polygon();
        nose.getPoints().addAll(new Double[]{
            240.0, 250.0, //1st Edge
            170.0, 250.0, //2nd Edge
            200.0, 190.0  // Final Edge
        });
        nose.setFill(Color.WHITE);
        nose.setStroke(Color.BLACK);

        // create an arc for the mouth
        Arc mouth = new Arc(200, 250, 80, 50, 180, 180);
        mouth.setFill(Color.WHITE);
        mouth.setStroke(Color.BLACK);
        mouth.setType(ArcType.OPEN);

        // add the shapes to the pane
        pane.getChildren().addAll(face, leftEye, leftPupil, nose, rightEye, rightPupil, mouth);

        // create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Smiley Face");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // launch the application
    public static void main(String[] args) {
        launch(args);
    }
}
