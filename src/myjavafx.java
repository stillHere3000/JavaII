import java.util.Stack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;


public class myjavafx extends Application{

    @Override
    public void start(Stage primaryStage){
       //create an pane of type HBox to hold the images
        //StackPane pane = new StackPane();//(new HBox(10));
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));

        //create a label and set its properties
        Label swiftLabel= new Label("Swift");
        swiftLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        swiftLabel.setTranslateY(35);
        pane.getChildren().add(swiftLabel);
        


        //create an image object and add it the pane
        Image SwiftImage = new Image("swift-logo.jpeg");
        ImageView swiftView= new ImageView(SwiftImage);
        swiftView.setFitHeight(100);
        swiftView.setFitWidth(100);
        pane.getChildren().add(swiftView );

        //create a label and set its properties
        Label CplusplusLabel= new Label("C++");
        CplusplusLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        CplusplusLabel.setTranslateY(35);
        pane.getChildren().add(CplusplusLabel);


        //create an image object and add it the pane
        Image CplusplusImage = new Image("cplusplus.jpeg");
        ImageView CplusplusView= new ImageView(CplusplusImage);
        CplusplusView.setFitHeight(100);
        CplusplusView.setFitWidth(100);
        pane.getChildren().add(CplusplusView );
        

         //create a label and set its properties
        Label javaLabel= new Label("Java");
        javaLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        javaLabel.setTranslateY(35);
        pane.getChildren().add(javaLabel);


        //create an image object and add it the pane
        Image javaImage = new Image("java.jpeg");
        ImageView javaView= new ImageView(javaImage);
        javaView.setFitHeight(100);
        javaView.setFitWidth(100);
        pane.getChildren().add(javaView );
        
        //create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Programming Languages");
        primaryStage.setScene(scene);
        primaryStage.show();

  

    }

    public static void main(String[] args){
        Application.launch(args);
    }

    
}
