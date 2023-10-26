//import Date util
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

/*
 * Write a program that stores a Date object for the current time,
 *  the double value 2.5, and an array of five int 
 * values 1, 2, 3, 4, and 5, into a file named file1.dat.  
 * Then provide code to read and display all the data stored in 
 * the file.  
 * 
 */
public class SimpleFile {

    private String fileName;
    private int[] intArray= {1, 2, 3, 4, 5};;
    private Date date;
    private File file;
    private Scanner scanner;
    private PrintWriter writer;
    private double doubleValue = 2.5;
    private FileInputStream fis;

    public SimpleFile(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
        this.fileName = fileName;
        
        this.file = new File(fileName);
        this.scanner = new Scanner(file, "UTF-8");
        this.writer = new PrintWriter(fileName, "UTF-8");
        this.date = new Date();
        fis= new FileInputStream(fileName);
        
    }

    public void write() throws FileNotFoundException, UnsupportedEncodingException {
        writer.println(date.toString());
        writer.println(doubleValue);
        for (int i = 0; i < intArray.length; i++) {
            writer.println(intArray[i]);
        }
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        try{
            SimpleFile simpleFile = new SimpleFile("/home/trevorj/Documents/Cosc1047/LabEight/simpleFile/src/file1.dat");
            simpleFile.write();
            //simpleFile.read();
        }
        finally{}

        
    }
}
