import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Calculate extends Application{
    private BorderPane pane = new BorderPane(); 
    private Button CalculateBtn = new Button("Calculate");
    private Label operator = new Label("");
    private RadioButton multiplyBtn= new RadioButton("Multiply");
    private RadioButton divideBtn = new RadioButton("Divide");
    private Label result = new Label("");
    private TextField num1 = new TextField();
    private TextField num2 = new TextField();
    private VBox paneforOperators = new VBox();
    private HBox paneForTextFields = new HBox();

    public static void main(String[] args) {
        
        launch(args);
    }

    public void setupLambda() {
        multiplyBtn.setOnAction(e -> { 
            operator.setText("*"); 
        });

        divideBtn.setOnAction(e -> { 
            operator.setText("/"); 
        });
    }

    @Override
    public void start(Stage primaryStage) {
        
        pane.setTop(CalculateBtn);
        pane.setLeft(result);
        paneforOperators.getChildren().addAll(multiplyBtn, divideBtn);
        //pane.setCenter(num2);
        pane.setRight(paneforOperators);
        paneForTextFields.getChildren().addAll(num1, operator, num2);
        pane.setBottom(paneForTextFields);
        setupLambda();
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class CalculateHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            double resultValue = 0;
            if (e.getSource() == CalculateBtn) {
                if (multiplyBtn.isSelected()) {
                    
                   resultValue= Double.parseDouble(num1.getText()) * Double.parseDouble(num2.getText());
                    result.setText(String.valueOf(resultValue));
                }
                else if (divideBtn.isSelected()) {
                    if( Double.parseDouble(num2.getText()) != 0){
                        resultValue = Double.parseDouble(num1.getText()) / Double.parseDouble(num2.getText());
                        result.setText(String.valueOf(resultValue));
                    }
                    else{
                        result.setText("Cannot divide by zero");
                    }                    
                    
                }
            }
        }
    }
    
}
