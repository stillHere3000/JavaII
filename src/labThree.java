import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class labThree {
    /*
     * Write a test program that does the following tasks:
    1. Open a text file called sides.txt which contains three randomly generated integers between 1 and 10. 
    2. Input the three integers from the sides.txt file. 
    3. Write a try block. In the block, create a new Triangle object using the three integers.
    4. Write a catch block to handle the IllegalTriangleException. In the block, print the message:  "IllegalTriangleException: The triangle cannot be created."
     */
    public static void main(String[] args) throws Exception {
        Scanner input  = new Scanner(new FileReader("/home/trevorj/Documents/Cosc1047/Lab3/labThree/src/sides.txt"));
         
        int []sides = new int[3];
        int i =0;
        while (input.hasNextInt() && i < 3) {
            sides[i] = input.nextInt(); i++;
        }
        input.close();

        try {
            Triangle t = new Triangle(sides[0], sides[1], sides[2]);
        }catch (IllegalTriangleException e){
            System.out.println("IllegalTriangleException: The triangle cannot be created.");
        }finally{
            System.out.println("End of Program");
        }
    }
}
