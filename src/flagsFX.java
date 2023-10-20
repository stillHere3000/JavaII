

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;


public class flagsFX extends Application{
    // draw Stage
    @Override
    public void start(Stage primaryStage){
        //create a scene and place it in the stage
        Scene scene = new Scene(setupFlagImages(), 500, 400);
        
        primaryStage.setTitle("Excercise_14.01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane setupFlagImages(){
        //String UrlPath="/home/trevorj/Documents/Cosc1047/Assignment5/Assignment5/flags";
        // load four images and Views
        Image CanadaFlag = new Image("./flags/Flag_of_Canada.png");        ImageView CanadaView = new ImageView(CanadaFlag);
        Image ChinaFlag = new Image("./flags/Flag_of_China.png");          ImageView ChinaView = new ImageView(ChinaFlag);
        Image GBFlag = new Image("./flags/Flag_of_Great_Britain.png");     ImageView GBView = new ImageView(GBFlag);
        Image USFlag = new Image("./flags/Flag_of_the_United_States.png"); ImageView USView = new ImageView(USFlag);

        setImageViewStyles(USView); setImageViewStyles(GBView); 
        setImageViewStyles(ChinaView); setImageViewStyles(CanadaView);

        GridPane gridPane = new GridPane();

        gridPane.add(CanadaView, 0, 0); gridPane.add(ChinaView, 1, 0);
        gridPane.add(GBView, 0, 1); gridPane.add(USView, 1, 1);
        gridPane.setPadding(new Insets(15, 15, 15, 15));
        gridPane.setHgap(10);        gridPane.setVgap(10);

        return gridPane;

        
    }

    public void setImageViewStyles(ImageView imgV){
        imgV.setFitHeight(150);        imgV.setFitWidth(200);        
    }

    public static void main(String[] args){
        Application.launch(args);
    }
    
}
