import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class FileTxtRead {
    public static void main(String[] args) throws Exception {
        Scanner input  = new Scanner(new FileReader("/home/trevorj/Documents/Cosc1047/Assignment 3/readTxtFile/readTxtFile/src/list.txt"));
        ArrayList<Integer> l = readFile(input);
        Collections.sort(l);
        printList(l);
        
    }

    public static ArrayList<Integer> readFile(Scanner in){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0;
        while( in.hasNext()){
            list.add(in.nextInt());
            i++;
        }
        return list;
    } 

    public static void printList(ArrayList<Integer> list){
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+"\t");
            if(i % 15 == 0 && i != 0)
                System.out.println("\n");
        }
    }
}
