import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class BinaryGrid extends Application {
    private int[][] gridValues = new int[50][50];
    
    @Override
    public void start(Stage primaryStage) {
        fillArray();
        // create a scene and place it in the stage
        Scene scene = new Scene(setupGrid(), 500, 400);

        primaryStage.setTitle("Binary Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane setupGrid(){
            
            
        GridPane gridPane = new GridPane();

        Label tempValue;
        for (int i = 0; i < gridValues.length; i++) {
            for (int j = 0; j < gridValues[i].length; j++) { 
                tempValue= new Label(""+(this.gridValues[i][j]));
                tempValue.setTextFill(javafx.scene.paint.Color.GRAY);                
                gridPane.add(tempValue, i, j);
            }
        }
        
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setHgap(3);        gridPane.setVgap(3);

        return gridPane;
        }

    public void fillArray() {
        int temp;
        for (int i = 0; i < gridValues.length; i++) {
            for (int j = 0; j < gridValues[i].length; j++) { 
                temp = (int)(Math.random() * 2)%2;
                this.gridValues[i][j] = temp;
            }
        }
    } 

    public static void main(String[] args) {
        launch(args);

    }
    
}
