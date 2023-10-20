import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Group;

public class FourFans extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        // create a scene and place it in the stage
        StackPane pane = new StackPane();
        pane.getChildren().add(setupFan(100,100));
        pane.getChildren().add(setupFan(400,100));
        pane.getChildren().add(setupFan(400,400));
        pane.getChildren().add(setupFan(100,400));
        Scene scene = new Scene(pane, 600, 600);
       

        primaryStage.setTitle("Four Fans");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Pane setupFan(int x, int y){
            
        Circle  circle = new Circle(x, y, 100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        
        
        // Create a group to hold the arcs
        Pane root = new Pane ();
        root.getChildren ().add (circle);

        // Create a loop to create four arcs with different start angles
        for (int i = 0; i < 4; i++) {
            // Create an arc with center (200, 200), radius 100, start angle i * 90, length 30 and round type
            Arc arc2 = new Arc (x, y, 100, 100, i * 90, 20);
            arc2.setType (ArcType.ROUND);

            // Set the stroke color to black and the fill color to random
            arc2.setStroke (Color.BLACK);
            arc2.setFill (Color.color (Math.random (), Math.random (), Math.random ()));

            // Add the arc to the group
            root.getChildren ().add (arc2);
        }

        return root;
    }

    // The main method is only needed for the IDE with limited JavaFX support.
    public static void main(String[] args) {
        launch(args);
    }
    
}
