import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ComboBox;
import javafx.collections.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javax.management.Descriptor;

import javafx.*;
import javafx.animation.PathTransition;
import javafx.*;

public class LunchMenu extends Application {

    private BorderPane pane = new BorderPane();      
    private VBox drinkmenu = new VBox(25);
    private ComboBox<String> cbo= new ComboBox<>();
    private String[] menuItems= {"Please Select an Item","Hot, Dog", "Sandwich", "Hamburger"};
    BorderPane paneforCombox= new BorderPane();
    private TextArea priceBox= new TextArea("0.00");
    private double totalPrice= 0.00; double foodPrice, drinkPrice= 0.00;
    private int selectedDrink= -1;
    private Boolean drinkSelected= false;
    private Boolean foodSelected= false;




    @Override
    public void start(Stage primaryStage){
        
        setupMenu();     
        setupDrinksMenu();   
        setupPriceBox();
        setupSubmitButton();

         // Create a scene and place it in the stage
		Scene scene = new Scene(pane, 500, 250);
		primaryStage.setTitle("Lunch Menu"); 
		primaryStage.setScene(scene); 
		primaryStage.show();
    } 

    public void setupMenu(){
        
        //paneforCombox.setLeft(new Label ("Food Item"));
        paneforCombox.setTop(cbo);
        paneforCombox.setPrefWidth(225);
        pane.setTop(paneforCombox);
        cbo.setPrefWidth(200);        

        ObservableList<String> menulist= FXCollections.observableArrayList(  menuItems
        );  

        cbo.setOnAction(e -> {
            addFoodPrice(); foodSelected= true;
        });
        cbo.getItems().addAll(menulist);
        cbo.setValue("Please Select an Item");        
        
    }



    public void setupDrinksMenu(){
        Label drinksLabel= new Label ("Drink:");
         ToggleGroup group = new ToggleGroup();        
		
        RadioButton coffeButn = new RadioButton("Coffee");        coffeButn.setToggleGroup(group);
        RadioButton teaButn = new RadioButton("Tea");        teaButn.setToggleGroup(group);
        RadioButton popButn = new RadioButton("Pop");        popButn.setToggleGroup(group);
        drinkmenu.setStyle("-fx-border-color:green");

        coffeButn.setOnAction(e -> {           
                            addDrinkPrice(0); selectedDrink=0; drinkSelected= true;
        });

        teaButn.setOnAction(e -> {           
                            addDrinkPrice(1); selectedDrink= 1; drinkSelected= true;
        });

        popButn.setOnAction(e -> {           
                            addDrinkPrice(2); selectedDrink= 2; drinkSelected= true;
        });

        drinkmenu.getChildren().addAll(drinksLabel, coffeButn, teaButn, popButn);
        

        pane.setLeft(drinkmenu);
    }

    public void setupPriceBox(){
        priceBox.setPrefWidth(200);
        priceBox.setPrefHeight(150);
        pane.setCenter(priceBox);

    }

    public void setupSubmitButton(){
        Pane tempPane= new Pane();

        Button subBtn= new Button("Submit");
        tempPane.getChildren().addAll(subBtn);
        //.setAlignment(subBtn,javafx.geometry.Pos.CENTER);
        pane.setBottom(tempPane);       

    }

    public void addDrinkPrice(int i){
        
        switch(i){
            case 0: drinkPrice= 2.00;   break;
            case 1: drinkPrice=1.75;    break;
            case 2: drinkPrice=2.50;   break;
            default: break;

        }
        totalPrice = foodPrice +  drinkPrice;
        priceBox.setText(""+totalPrice);
        
    }    

    public void addFoodPrice(){
               
        switch(cbo.getSelectionModel().getSelectedIndex()){
            case 1: foodPrice= 5.00;   break;
            case 2: foodPrice=4.75;    break;
            case 3: foodPrice =6.50;   break;
            default: break;
        }
      
        totalPrice = foodPrice +  drinkPrice;
        priceBox.setText(""+totalPrice);      
        
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
