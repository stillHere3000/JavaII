import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ComboBox;
import javafx.collections.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.*;
import javafx.animation.PathTransition;
import javafx.*;

public class DynamicPanel extends Application {

    private GridPane pane = new GridPane(); 
    private Pane outerPane= new Pane();   
    private Slider redSlider, greenSlider, blueSlider, opacitySlider; 
    Label showColorsLabel; 
   

   private TextField graphicTextGapBox= new TextField("30");

    @Override
    public void start(Stage primaryStage){
        
        setupHeader();
        
         // Create a scene and place it in the stage 
         Scene scene = new Scene(outerPane, 600, 250);
		primaryStage.setTitle("Lunch Menu"); 
		primaryStage.setScene(scene); 
		primaryStage.show();   
    }
    
     public void setupHeader(){
        
        //paneforCombox.setLeft(new Label ("Food Item"));
        
        showColorsLabel= new Label("Show Colors");
        Label redLabel= new Label("Red");     Label greenLabel= new Label("Green");        Label blueLabel= new Label("Blue"); Label opacityLabel= new Label("Opacity");
        redSlider= new Slider();     greenSlider= new Slider();     blueSlider= new Slider();       opacitySlider= new Slider();
        setSliderStyles(redSlider);     setSliderStyles(greenSlider);     setSliderStyles(blueSlider);
        opacitySlider.setMin(0);        opacitySlider.setMax(100);        opacitySlider.setValue(100);
        opacitySlider.setShowTickLabels(true);        opacitySlider.setShowTickMarks(true);       opacitySlider.setMajorTickUnit(50);        opacitySlider.setMinorTickCount(5);        opacitySlider.setBlockIncrement(10);
        showColorsLabel.setPadding(new Insets(10, 10, 10, 10));
        redLabel.setPadding(new Insets(10, 10, 10, 10));  
        pane.add(showColorsLabel, 0, 0);
        GridPane.setColumnSpan(showColorsLabel, 2);
        GridPane.setHalignment(showColorsLabel, javafx.geometry.HPos.CENTER);


        pane.add(redLabel, 0, 1); pane.add(redSlider, 1, 1);
        pane.add(greenLabel, 0, 2); pane.add(greenSlider, 1, 2);
        pane.add(blueLabel, 0, 3); pane.add(blueSlider, 1, 3);
        pane.add(opacityLabel,0, 4);                 pane.add(opacitySlider, 1, 4);
        pane.setLayoutX(200);   pane.setLayoutY(25);
        pane.setHgap(10);   pane.setVgap(10);
        
        outerPane.getChildren().add(pane);
        //showColorsLabel.setStyle("-fx-text-fill: rgb(" + redSlider.getValue() + ", " + greenSlider.getValue() + ", " + blueSlider.getValue() + ")");
        Paint  paint= Color.rgb((int)redSlider.getValue(), (int)greenSlider.getValue(), (int)blueSlider.getValue());
        
        showColorsLabel.setTextFill(paint);     showColorsLabel.setOpacity((double)opacitySlider.getValue()/100);
        setupColor();

    }

    public void setupColor(){

        redSlider.valueProperty().addListener(ov -> {
            int redValue= (int)redSlider.getValue();
            System.out.println("redValue: " + redValue+ ", greenValue: " + (int)greenSlider.getValue() + ", blueValue: " + (int)blueSlider.getValue());
            showColorsLabel.setTextFill(Color.rgb(redValue, (int)greenSlider.getValue(), (int)blueSlider.getValue()))   ;
            //showColorsLabel.setStyle("-fx-text-fill: rgb(" + redValue + ", " + (int)greenSlider.getValue() + ", " + (int)blueSlider.getValue() + ")");
            
        });

        greenSlider.valueProperty().addListener(ov -> {
            int greenValue= (int)greenSlider.getValue();
            System.out.println("greenValue: " + greenValue+ ", redValue: " + (int)redSlider.getValue() + ", blueValue: " + (int)blueSlider.getValue());
            showColorsLabel.setTextFill(Color.rgb((int)redSlider.getValue(), greenValue, (int)blueSlider.getValue()))   ;
            //showColorsLabel.setStyle("-fx-text-fill: rgb(" + (int)redSlider.getValue() + ", " + greenValue + ", " + (int)blueSlider.getValue() + ")");
           
        });

        blueSlider.valueProperty().addListener(ov -> {
            int blueValue= (int)blueSlider.getValue();
            System.out.println("blueValue: " + blueValue+", redValue: "+(int)redSlider.getValue() + ", greenValue: " + (int)greenSlider.getValue());
            showColorsLabel.setTextFill(Color.rgb((int)redSlider.getValue(), (int)greenSlider.getValue(), blueValue))   ;
            //showColorsLabel.setStyle("-fx-text-fill: rgb(" + (int)redSlider.getValue() + ", " + (int)greenSlider.getValue() + ", " + blueValue + ")");
            
        });

        opacitySlider.valueProperty().addListener(ov -> {
            double opacityValue= (double)opacitySlider.getValue()/100;
            System.out.println("opacityValue: " + opacityValue);
            showColorsLabel.setOpacity(opacityValue);
        });

        
    }
    
    public void setImageViewStyles(ImageView imgV){
        imgV.setFitHeight(150);        imgV.setFitWidth(200);        
    }

    public void setSliderStyles(Slider slider){
        slider.setMin(0);        slider.setMax(255);        slider.setValue(0);
        slider.setShowTickLabels(true);        slider.setShowTickMarks(true);        slider.setMajorTickUnit(50);        slider.setMinorTickCount(5);        slider.setBlockIncrement(10);
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
