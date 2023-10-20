import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;


public class TicTacToe extends Application{

    
        // draw Stage
        @Override
        public void start(Stage primaryStage){
            //create a scene and place it in the stage
            Scene scene = new Scene(setupBoardGame(), 500, 400);
            

            primaryStage.setTitle("Excercise_14.2");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public GridPane setupBoardGame(){
            //String UrlPath="/home/trevorj/Documents/Cosc1047/Assignment5/Assignment5/flags";
            // load four images and Views
            Image XImage = new Image("./tictactoe/x.jpeg");               ImageView XView = new ImageView(XImage);
            Image OImage = new Image("./tictactoe/o.jpeg");               ImageView OView = new ImageView(OImage);
            Image BlankImage = new Image("./tictactoe/blank.png");        ImageView BlankView = new ImageView(BlankImage);


            setImageViewStyles(XView); setImageViewStyles(OView); setImageViewStyles(BlankView); 
            
            GridPane gridPane = new GridPane();

            gridPane.add(new ImageView(OImage), 0, 0);  gridPane.add(new ImageView(XImage), 1, 0);   gridPane.add(new ImageView(OImage), 2, 0);

            gridPane.add(new ImageView(XImage), 0, 1);  gridPane.add(new ImageView(BlankImage), 1, 1); gridPane.add(new ImageView(XImage), 2, 1);

            gridPane.add(new ImageView(BlankImage), 0, 2); gridPane.add(new ImageView(BlankImage), 1, 2); gridPane.add(new ImageView(BlankImage), 2, 2);
            
            
            gridPane.setPadding(new Insets(15, 15, 15, 15));
            gridPane.setHgap(10);        gridPane.setVgap(10);

            return gridPane;
        }

        public void setImageViewStyles(ImageView imgV){
            imgV.setFitHeight(50);        imgV.setFitWidth(50);        
        }

        public static void main(String[] args){
            Application.launch(args);
        }

    
}
