import java.util.Scanner;

public class Assignment5{
    public static void main(String[] args) throws Exception {
        Scanner in= new Scanner(System.in); int choice ;

        do{
            System.out.println("Choose one of three options\n"+
                                "1\tDisplay the flags\n"+ "2\tTicTac Toe board\n"
                                +"3\tDisplay 3 Random Cards\n"+
                                "0\tto exit\n");
            choice = in.nextInt();
            switch(choice){
                case 1:            System.out.println("Display the flags");         break;
                case 2:            System.out.println("TicTac Toe board");          break;
                case 3:            System.out.println("Display 3 Random Cards");    break;
                case 0:            System.out.println("Exit");                      break;
                default:           System.out.println("Invalid choice");
            }
        }while(choice != 0);

        in.close();
    }
}
