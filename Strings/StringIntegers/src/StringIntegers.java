import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.lang.StringBuilder;

public class StringIntegers {
    //public  static  int[] rawInput;
    public static ArrayList<Integer> rawInput;
   

    
    public static void main(String[] args) throws Exception {
        System.out.println("Please Enter 10 inetgers");

        Scanner input = new Scanner(System.in); 
        //rawInput = new int[10];
        //strElements = new StringBuilder();
        rawInput = new ArrayList <Integer>(); 
        captureInputs(input);
        removeDuplicate(rawInput);
        printList(rawInput);

        input.close();

    }

    public static void captureInputs(Scanner in){
        int i = 0; 
        while( i < 10){
            rawInput.add(  in.nextInt() );
            i++;
        }
    }

    public static void removeDuplicate ( ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if( list.get(i) == list.get(j)){
                    list.remove(j);
                }
            }
        }
    }

    public static void printList(ArrayList<Integer> list){
        System.out.print("\nThe distinct integers are \n");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
    
}
