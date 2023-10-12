import java.util.ArrayList;
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class readHTTPFIle {

    public static ArrayList<Integer> listFinal,listFinal2;
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://liveexample.pearsoncmg.com/data/Scores.txt");
        BufferedReader input = new BufferedReader(  new InputStreamReader(url.openStream()));
        Scanner inputScn  = new Scanner(url.openStream());
        
        listFinal = new ArrayList<Integer>();        listFinal2 = new ArrayList<Integer>();

        readFile(input);        alternateReadFile(inputScn);
        
        printList(); printList2();
        input.close(); inputScn.close(); 
        
    }

    public static void alternateReadFile(Scanner input){
        while(input.hasNext()){
            listFinal2.add( input.nextInt());            
        }
    }

    public static void readFile(BufferedReader in){        
            
        try {            
            String s;
            do{
                s= in.readLine();
                if(s != null)
                     processLine(s);
               
            }while( s != null);
            
        }            
        catch (IOException e) {
            e.printStackTrace();
        }        
    }

    public static void processLine(String s){
        String [] tokens = s.split(" ");
        
        for(int i = 0; i < tokens.length; i++){
            listFinal.add(Integer.parseInt(tokens[i]));
        }        
    }

    public static void printList(){
        System.out.println( "Buffered read output");
        int total= 0; double average =0;
        for(int i = 0; i < listFinal.size(); i++){
            System.out.print(listFinal.get(i)+"\t");
            total += listFinal.get(i);
            
            if((i+1)%5 == 0)
                System.out.println( );
        }
        average = total/listFinal.size();
        System.out.println( );
        System.out.println( "Total: "+total+"\tAverage: "+average);
    }

    public static void printList2(){
        System.out.println( "Scanner read output");
        int total= 0; double average =0;
        for(int i = 0; i < listFinal2.size(); i++){
            System.out.print(listFinal2.get(i)+"\t");
            total += listFinal2.get(i); 
            if((i+1)%5 == 0)
                System.out.println( );
        }
        average = total/listFinal2.size();
        System.out.println( "\nTotal: "+total+"\tAverage: "+average);
        System.out.println( );
    }
}
