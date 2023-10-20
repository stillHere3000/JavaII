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
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Group;

public class paintedGrid extends Application {
    int [][] gridValues = new int[15][15];
    @Override
    public void start(Stage primaryStage) {
        
        
        Scene scene = new Scene(setupGrid(), 600, 600);
       

        primaryStage.setTitle("Four Fans");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane setupGrid(){
            
            
        GridPane gridPane = new GridPane();

        Rectangle tempValue;
        for (int i = 0; i < gridValues.length; i++) {
            for (int j = 0; j < gridValues[i].length; j++) {                 
                tempValue = new Rectangle(10, 10); 
                tempValue.setFill(Color.color (Math.random (), Math.random (), Math.random ()));               
                gridPane.add(tempValue, i, j);
            }
        }
        
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setHgap(3);        gridPane.setVgap(3);

        return gridPane;
        }


    // The main method is only needed for the IDE with limited JavaFX support.
    public static void main(String[] args) {
        launch(args);
    }
    
}
