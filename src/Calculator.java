import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
public class Calculator extends Application {

    private TextField firstOperandField;
    private TextField secondOperandField;
    private TextField resultField;
    
   
    @Override
    public void start(Stage primaryStage) {
        
        
        Scene scene = new Scene(setupCalc(), 375, 300);
       

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane setupCalc(){           
            
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(25, 25, 25, 25));
        pane.setHgap(30);        pane.setVgap(30);

        Label firstOpLabel = new Label("First Operand");      pane.add(firstOpLabel,0,0);                              

        firstOperandField = new TextField();      setTxtStyles(firstOperandField);        pane.add(firstOperandField,2,0);
        
        Label secondOpLabel= new Label("Second Operand");     pane.add(secondOpLabel,0,1);

        secondOperandField = new TextField(); setTxtStyles(secondOperandField);       pane.add(secondOperandField,2,1);


        Label resultLabel= new Label("Result");        pane.add(resultLabel,0,2);

        resultField = new TextField();        setTxtStyles(resultField);        pane.add(resultField,2,2);  

        Button addBtn = new Button("Add");          pane.add(addBtn,0,3);   addBtn.setPrefWidth(60);
        Button subBtn = new Button("Subtract");     pane.add(subBtn,1,3);   subBtn.setPrefWidth(120);
        Button clearBtn= new Button("Clear");       pane.add(clearBtn,2,3); clearBtn.setPrefWidth(60);

        addBtn.setOnAction(e -> addHandler());      subBtn.setOnAction(e -> subHandler());      clearBtn.setOnAction(e -> clearHandler());
        GridPane.setColumnSpan(firstOpLabel, 2);    GridPane.setColumnSpan(secondOpLabel, 2); 
        
        GridPane.setHalignment(firstOpLabel, javafx.geometry.HPos.LEFT);    GridPane.setHalignment(firstOperandField, javafx.geometry.HPos.CENTER);
        GridPane.setHalignment(secondOpLabel, javafx.geometry.HPos.LEFT);   GridPane.setHalignment(secondOperandField, javafx.geometry.HPos.CENTER);
        GridPane.setHalignment(resultLabel, javafx.geometry.HPos.LEFT);    GridPane.setHalignment(resultField, javafx.geometry.HPos.CENTER);
        GridPane.setHalignment(addBtn, javafx.geometry.HPos.RIGHT);       GridPane.setHalignment(subBtn, javafx.geometry.HPos.LEFT);       
        GridPane.setHalignment(clearBtn, javafx.geometry.HPos.CENTER);
        return pane;
        }

        public void addHandler(){
            //System.out.println("opfield"+firstOperandField.getLength());
            int firstOperand = (firstOperandField.getLength() != 0)?Integer.parseInt(firstOperandField.getText()):0;
            int secondOperand = (secondOperandField.getLength() != 0)?Integer.parseInt(secondOperandField.getText()):0;
            int result = firstOperand + secondOperand;
            resultField.setText(Integer.toString(result));
        }

        public void subHandler(){
            int firstOperand = (firstOperandField.getLength() != 0)?Integer.parseInt(firstOperandField.getText()):0;
            int secondOperand = (secondOperandField.getLength() != 0)?Integer.parseInt(secondOperandField.getText()):0;
            int result = firstOperand - secondOperand;
            resultField.setText(Integer.toString(result));
        }

        public void clearHandler(){
            firstOperandField.setText("");
            secondOperandField.setText("");
            resultField.setText("");
        }

        public void setTxtStyles(TextField txtFV){
            txtFV.setPrefWidth(60);
            //imgV.setFitHeight(60);        imgV.setFitWidth(60);
                    
        }


    // The main method is only needed for the IDE with limited JavaFX support.
    public static void main(String[] args) {
        launch(args);
    }  
}
