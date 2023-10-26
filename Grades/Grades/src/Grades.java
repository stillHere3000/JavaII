import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.Pane;
import java.util.Date;
//import file io util
import java.io.File;
import java.io.FileInputStream;
//import file io exception
import java.io.IOException;
//import file io scanner
import java.util.Scanner;
//import file io printwriter
import java.io.PrintWriter;
//import file io filenotfoundexception
import java.io.FileNotFoundException;
//import file io filenotfoundexception
import java.io.UnsupportedEncodingException;
//import arraylist
import java.util.ArrayList;


/*
 *     Write a program that creates a GUI that contains a 
 * label ("Enter the data"), a text area and a button. 
 * The user types in the text area lines each containing the 
 * name of a student and an integer representing their grade. 
 * When the user clicks the button, the program should get the 
 * text from the text area and save the data into a binary file 
 * as UTF strings and as integers.  Calculate the average 
 * (a double) of the grades and save it to the end of the 
 * binary file.
 * 
 * 
 */
public class Grades extends Application {
    private BorderPane pane = new BorderPane();
    private TextArea gradeInputTxt = new TextArea();
    private String fileName; 
    private Label label = new Label("Enter the data");
    private Button saveBtn = new Button("Save");
    
    private File file;
    private Scanner scanner;
    private PrintWriter writer;   
    private FileInputStream fis;
    private ArrayList<Integer> grades = new ArrayList<Integer>();



    @Override
    public void start(Stage primaryStage) throws Exception {
        setupInterface();

         // Create a scene and place it in the stage
		Scene scene = new Scene(pane, 500, 250);
		primaryStage.setTitle("Traffic Lights"); 
		primaryStage.setScene(scene); 
		primaryStage.show();
    }

    public void setupInterface() {
        // Create a pane to hold a textArea
        pane.setTop(label);
        pane.setCenter(gradeInputTxt);
        pane.setBottom(saveBtn);

        BorderPane.setAlignment(saveBtn, javafx.geometry.Pos.CENTER);

        saveBtn.setOnAction(e -> {
            saveData();
        });

    }

    public void saveData() {
        //get the text from the text area
        String text = gradeInputTxt.getText();
        //split the text into lines
        String[] lines = text.split("\n");
        //create a file
        file = new File("grades.dat");
        //create a printwriter
        try {
            writer = new PrintWriter(file, "UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding");
        }
        //loop through the lines
        for (String line : lines) {
            //split the line into name and grade
            String[] nameGrade = line.split(" ");
            //write the name and grade to the file
            writer.println(nameGrade[0]+" "+nameGrade[1]); // name of Student
            
            try{
                //convert the grade to an int
                int grade = Integer.parseInt(nameGrade[1]);
                addGrade(grade);
                //write the grade to the file
                //writer.println(grade);
            } catch (NumberFormatException e) {
                System.out.println("Grade is not a number");
            }
        }
        //get the average
        double average = getAverage();
        //write the average to the file
        writer.println("average grade is:\t"+average);
        //close the writer
        writer.close();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverage() {
        double sum = 0;
        for (int grade : grades) {
            sum += (double)grade;
        }
        double sz= (double)grades.size();
        return (double)(sum / (sz));
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
