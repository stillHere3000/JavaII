import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;

import javafx.*;
import javafx.animation.PathTransition;
import javafx.*;

public class MovingCar extends Application{

    private double BaseLeftX = 50;
    private double BaseLeftY = 75;
    
    Pane pane = new Pane();

    @Override
    public void start(Stage primaryStage) {
        
        setupCarTop();
        setupCarBody(); 
        setupCarWheelz();

        PathTransition pt = new PathTransition(Duration.millis(10000), new Line(BaseLeftX+50,BaseLeftY+50, 625, BaseLeftY+50), pane);
        pt.setCycleCount(5);
        pt.play();
        

        // Create a scene and place it in the stage
		Scene scene = new Scene(pane, 500, 250);
		primaryStage.setTitle("Moving Car"); 
		primaryStage.setScene(scene); 
		primaryStage.show();
		
    }

    

    public void setupCarWheelz(){
        Circle wh1= new Circle(BaseLeftX + 15, BaseLeftY -5, 5);
        Circle wh2= new Circle(BaseLeftX + 35, BaseLeftY -5, 5);
        wh1.setFill(Color.BLACK);
        wh2.setFill(Color.BLACK);
        pane.getChildren().addAll(wh1, wh2);
    }

    public void setupCarTop(){
        Polygon trapezoid = new Polygon();

        //Set the coordinates of the vertices
        trapezoid.getPoints().addAll(new Double[]{
            BaseLeftX + 20, BaseLeftY - 30, //Top left
            BaseLeftX + 30, BaseLeftY - 30, //Top right
            BaseLeftX + 40, BaseLeftY - 20, //bottom right
            BaseLeftX + 10, BaseLeftY - 20 //bottom left
        });

        //Set the fill color
        trapezoid.setFill(Color.BLUE);
        pane.getChildren().add(trapezoid);
    }

    public void setupCarBody(){
        Rectangle carBody = new Rectangle(BaseLeftX, BaseLeftY-20, 50, 10);
            
        /*BaseLeftX , BaseLeftY - 20, //Base left
                                            BaseLeftX + 50, BaseLeftY - 20, //Base right
                                            BaseLeftX + 10, BaseLeftY - 10, //bottom right
                                            BaseLeftX + 50, BaseLeftX - 10 //bottom left
                                        );*/

        //Set the fill color
        carBody.setFill(Color.LAVENDER);
        pane.getChildren().add(carBody);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        launch(args);
    }
}


   


    



    /*public void moveLeft() {
        x -= 10;
        circle.setCenterX(x);
        line.setStartX(x - 10);
        line.setEndX(x + 10);
    }

    public void moveRight() {
        x += 10;
        circle.setCenterX(x);
        line.setStartX(x - 10);
        line.setEndX(x + 10);
    }

    public void moveUp() {
        y -= 10;
        circle.setCenterY(y);
        line.setStartY(y + 10);
        line.setEndY(y + 10);
    }

    public void moveDown() {
        y += 10;
        circle.setCenterY(y);
        line.setStartY(y + 10);
        line.setEndY(y + 10);
    }*/
