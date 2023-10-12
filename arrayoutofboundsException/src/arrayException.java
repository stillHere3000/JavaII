
import java.util.Scanner;

public class arrayException {

    public static int [] array;
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        arrayCreation(); printArray();
        try {
            arrayAccess(input);
        }
        catch (IndexOutOfBoundsException e) {
            throw new Exception("Out of Bounds: value ");
        }
        catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
        
    }

    public static void arrayCreation() {
        array= new int [100]; int temp;

        for(int i=0; i<100; i++) {
            temp = (int)(Math.random()*100)+1;
            array[i]=temp;
        }        
    }

    public static void printArray() {
        for(int i=0; i<100; i++) {
            System.out.print(array[i]+"\t");
            if(i%15==0) System.out.println( );
        }
    }

    public static void arrayAccess(Scanner in)  {
        int index=0;
        try{ 
            System.out.print("\nPlease enter an index: ");
            index = in.nextInt();
            if( index < 0 || index > 99) {
                throw new IndexOutOfBoundsException("Out of Bounds: value "+ index);                
            }            
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Out of Bounds: value ");
        }
        
        finally {
            //System.out.println("The index you chose is "+index + " and the value is "+array[index]);
        }
    }
}
