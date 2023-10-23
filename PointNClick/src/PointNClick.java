
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import javafx.*;

import javafx.*;
import java.util.ArrayList;



public class PointNClick extends Application {

    private double clickX = 0;
    private double clickY = 0;
    private ArrayList <Double []> points = new ArrayList <Double []> ();
    private ArrayList <Circle> circles = new ArrayList <Circle> ();
    private Pane pane;

    @Override // Override the start method in the Application class
	public void start(Stage primaryStage) { 

		pane = new Pane();
		pane.setPadding(new Insets(25, 25, 25, 25));
        
		pane.setOnMouseClicked(e -> { 
            clickX= e.getX();     clickY= e.getY(); 
            if(!hasBeenClickedBefore()){
                addPoint();     
            }  

            switch (e.getButton()) {
                case PRIMARY: createCircle(); break;
                case SECONDARY:  
                    removeCircle((int)clickX, (int)clickY);     
                    break;
                case MIDDLE:  break;
                case NONE: break;				
            }
		});
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 500, 250);
		primaryStage.setTitle("PointNClick"); 
		primaryStage.setScene(scene); 
		primaryStage.show();

	}

    public boolean hasBeenClickedBefore(){

        for (int i = 0; i < points.size(); i++){
            if (points.get(i)[0] == clickX && points.get(i)[1] == clickY){
                System.out.println("You have clicked this point before");
                removeCircle((int)clickX, (int)clickY);
                return true;
            }
        }
        System.out.println("You have not clicked this point before");
        return false;
    }

    public void removeCircle(int x, int y){
        for (int i = 0; i < circles.size(); i++){
            if (circles.get(i).getCenterX() == x && circles.get(i).getCenterY() == y){
                pane.getChildren().remove(circles.get(i));
                circles.remove(i);
            }
        }
    }


    public void addPoint(){
        Double [] point = {clickX, clickY};
        points.add(point);
    }

    public void createCircle(){
        Circle circle = new Circle(clickX, clickY, 10);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circles.add(circle);
        pane.getChildren().add(circle);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        launch(args);
    }
}

