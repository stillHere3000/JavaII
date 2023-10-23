
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


public class MovingCircle extends Application {


	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) { 

		MyMovingPane pane = new MyMovingPane();
		pane.setPadding(new Insets(25, 25, 25, 25));
        
		pane.setOnKeyPressed(e -> { 
            switch (e.getCode()) {
                case LEFT: pane.moveLeft(); break;
                case RIGHT: pane.moveRight(); break;
				case UP: pane.movingUp(); break;
				case DOWN: pane.movingDown(); break;
            }

		});
		
				

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 500, 250);
		primaryStage.setTitle("Moving Circle"); 
		primaryStage.setScene(scene); 
		primaryStage.show();

		pane.requestFocus();
	}

	

    public static void main(String[] args) {
        launch(args);
    }
} 

class MyMovingPane extends Pane {

	private int CenterX= 200;
	private int CenterY= 50;
	private int radius= 15;


	private Circle circle = new Circle(CenterX, CenterY, 15);
	private GridPane p;
	

	public MyMovingPane() {
		
		circle.setFill(Color.BLACK);
		

		getChildren().addAll(circle);

		p =setupButtons();
		p.setLayoutX(80); p.setLayoutY(120);
		
		this.getChildren().add(p); 
		
		
	}

	public GridPane setupButtons(){
		GridPane gdPane= new GridPane();
		
        Button leftBtn = new Button("Left");          gdPane.add(leftBtn,0,0);   leftBtn.setPrefWidth(60);
        Button rightBtn = new Button("Right");     gdPane.add(rightBtn,1,0);   rightBtn.setPrefWidth(60);
        Button upBtn= new Button("Up");       gdPane.add(upBtn,2,0); upBtn.setPrefWidth(60);
		Button downBtn= new Button("Down");       gdPane.add(downBtn,3,0); downBtn.setPrefWidth(60);

		leftBtn.setOnAction(e -> moveLeft());      rightBtn.setOnAction(e -> moveRight());      
		upBtn.setOnAction(e -> movingUp()); downBtn.setOnAction(e -> movingDown());
		return gdPane;

	}

	public void moveLeft() {
		//checkHorizontal();
		Point2D point= this.circle.localToScene(CenterX, CenterY); 
		
		if(Math.abs(point.getX()) <= this.radius) return;
            this.circle.setTranslateX(this.circle.getTranslateX() - 10);        
	}

	public void checkHorizontal(){
		Point2D point= this.circle.localToScene(this.circle.getRadius()*2, this.circle.getRadius()*2);
        Point2D point2= this.circle.localToScene(CenterX, CenterY); 
		Point2D point3= circle.localToScreen(0,0);
		Point2D point4= this.parentToLocal(0,0); 
		Point2D point5= super.localToScene(0,0);
		Point2D point6= this.circle.parentToLocal(point);
		Point2D point7= this.circle.localToParent(point);
		Point2D point8= this.screenToLocal(point);
		Point2D point9= super.screenToLocal(point);
		Point2D point10= circle.sceneToLocal(0,0);

		//Point2D point5= this.circle.localToParent(circle, 0);
		 //(Node)(this.circle).getX();

		System.out.println(point.getX()+"\t"+point2.getX()+"\t"+point3.getX()
							+"\t"+point4.getX()+"\t"+point5.getX()+"\t"+point6.getX()+
							"\t"+point7.getX()+"\t"+point8.getX()+"\t"+point9.getX()+"\t"+point10.getX());
	}

	public void moveRight() {
		//checkHorizontal();
		Point2D point= this.circle.localToScene(CenterX, CenterY); 
		if(Math.abs(point.getX()) >= super.getWidth()) return;
        this.circle.setTranslateX(this.circle.getTranslateX() + 10);

	}

	public void movingUp() {
		Point2D point= this.circle.localToScene(CenterX, CenterY); 
		if(Math.abs(point.getY()) <= this.radius) return;
		this.circle.setTranslateY(this.circle.getTranslateY() - 10);
	}

	public void movingDown() {
		Point2D point= this.circle.localToScene(CenterX, CenterY); 
		if(Math.abs(point.getY()) >= super.getHeight()) return;
		this.circle.setTranslateY(this.circle.getTranslateY() + 10);
	}


}