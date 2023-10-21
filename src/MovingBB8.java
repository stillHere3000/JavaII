
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javafx.stage.Stage;


public class MovingBB8 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) { 

		BB8Pane pane = new BB8Pane();
		pane.setOnKeyPressed(e -> { 
            switch (e.getCode()) {
                case LEFT: pane.moveLeft(); break;
                case RIGHT: pane.moveRight(); break;
            }

		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 120);
		primaryStage.setTitle("MovingBB8"); 
		primaryStage.setScene(scene); 
		primaryStage.show();

		pane.requestFocus();
	}

    public static void main(String[] args) {
        launch(args);
    }
} 

class BB8Pane extends Pane {

	private Circle circle1 = new Circle(200, 50, 15);
	private Circle circle2 = new Circle(200, 70, 20);
	private Line line = new Line(200, 25, 200, 35);

	public BB8Pane() {
		line.setStroke(Color.BLACK);
		circle1.setFill(Color.CORAL);
		circle2.setFill(Color.CORAL);

		getChildren().addAll(circle1, circle2, line);
	}

	public void moveLeft() {
        if(this.line.getEndX() <= 20) return;
            this.setTranslateX(this.getTranslateX() - 10);        
	}

	public void moveRight() {
        if(this.line.getEndX() >= 370) return;
        this.setTranslateX(this.getTranslateX() + 10);

	}


}