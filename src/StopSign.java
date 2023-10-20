
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;

// Define the main class that extends Application
public class StopSign extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
   
    
    Scene scene = new Scene(setupSign(), 250, 250);
    primaryStage.setTitle("StopSign"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  public StackPane setupSign(){
    StackPane pane = new StackPane();

    // Create a polygon and set its properties
    Polygon polygon = new Polygon();
    pane.getChildren().add(polygon);
    polygon.setFill(Color.RED); 
    polygon.setRotate(22.5); // Rotate the polygon by 22.5 degrees to get the correct orientation
    ObservableList<Double> list = polygon.getPoints(); // Get the list of points

    final double w = 200, h = 200; 
    double centerX = w / 2, centerY = h / 2; // find center coordinates
    double radius = Math.min(w, h) * 0.4; // calculate radius of the polygon

    // Add points to the polygon list using a loop
    for (int i = 0; i < 8; i++) {
      list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
      list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
    }

    // Create a text and set its properties
    Text text = new Text("STOP");
    text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 35)); // Set the font style and size
    text.setFill(Color.WHITE); // Set the fill color to white
    pane.getChildren().add(text); // Add the text to the pane

    return pane;

  }
  
  
  public static void main(String[] args) {
    launch(args);
  }
}
