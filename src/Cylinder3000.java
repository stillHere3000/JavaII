import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;

import javafx.stage.Stage;

public class Cylinder3000 extends Application {
    @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a group to hold the 3D shape
    Group root = new Group();

    // Create a cylinder with radius 50 and height 100
    Cylinder cylinder = new Cylinder(50, 100) ; 
    

   // Create a group and add the cylinder to it
   // Group root = new Group ();
    root.getChildren ().add (cylinder);

    // Create a scene with width 600 and height 400
    Scene scene = new Scene (root, 600, 400);

    // Create a perspective camera and set its position and rotation
     PerspectiveCamera camera = new PerspectiveCamera ();
    camera.setTranslateX (-200);
     camera.setTranslateY (-100);
    camera.setTranslateZ (-300);
    camera.setRotate(15);
    
    // Set the camera of the scene to the perspective camera
    scene.setCamera (camera);

    // Create a stage and set its title and scene
    Stage stage = new Stage ();
    stage.setTitle ("Drawing a Cylinder in JavaFX");
    stage.setScene (scene);

    // Show the stage
    stage.show ();


  }

  // The main method is only needed for the IDE with limited JavaFX support.
  public static void main(String[] args) {
    launch(args);
  }
    
}
