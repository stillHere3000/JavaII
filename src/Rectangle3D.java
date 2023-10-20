// Import the necessary classes
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Box;

// Define the main class that extends Application
public class Rectangle3D extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a group to hold the 3D shape
    Group root = new Group();

    // Create a box and set its properties
    Box box = new Box();
    box.setWidth(100); // Set the width of the box
    box.setHeight(50); // Set the height of the box
    box.setDepth(75); // Set the depth of the box
    box.setTranslateX(250); // Set the x position of the box
    box.setTranslateY(100); // Set the y position of the box
    box.setTranslateZ(400); // Set the z position of the box
    box.setRotate(50);
    // box.setRotateX(50); // Set the x rotation of the box
    // box.setRotateY(50); // Set the y rotation of the box
    // box.setRotateZ(50); // Set the z rotation of the box

    // Create a material and set its color
    PhongMaterial material = new PhongMaterial();
    material.setDiffuseColor(Color.GREEN); // Set the diffuse color to green

    // Apply the material to the box
    box.setMaterial(material);

      // Create a group and add the box to it
    //Group root = new Group ();
    root.getChildren ().add (box);

    // Create a scene with width 600 and height 400
    Scene scene = new Scene (root, 600, 400);

    // Create a perspective camera and set its position and rotation
    PerspectiveCamera camera = new PerspectiveCamera ();
   
    camera.setRotate(-45);
    //camera.setRotateY (45);

    // Set the camera of the scene to the perspective camera
    scene.setCamera (camera);

    // Create a stage and set its title and scene
    Stage stage = new Stage ();
    stage.setTitle ("Drawing a Rectanguloid in JavaFX");
    stage.setScene (scene);

    // Show the stage
    stage.show ();

  }

  // The main method is only needed for the IDE with limited JavaFX support.
  public static void main(String[] args) {
    launch(args);
  }
}
