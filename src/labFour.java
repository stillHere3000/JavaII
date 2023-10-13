
/*
 * 
 *     1. Write an abstract superclass called Vehicle that contains the following private data fields: 
 *          color: a string that holds the color of the vehicle.  
 *          dateMade: the date the vehicle was manufactured. 
 *          Provide appropriate constructors and setter/getter methods for this class
 *          Include an abstract void method named steer().
 * 
 *      Write a test program to test your classes and interface.   
 */

public class labFour {
    public static void main(String[] args) throws Exception {
        Car ligntningMcQueen = new Car("red", new java.util.Date(), "Lightning McQueen", 200);
        Car TheBatmobile = new Car("black", new java.util.Date(), "The Batmobile", 300);

        System.out.println("The First Car object:");        System.out.println(ligntningMcQueen.toString());
        System.out.println("The First Car object:");        System.out.println(TheBatmobile.toString());
        System.out.println("Testing equals: boolean value is \t"+ligntningMcQueen.equals(TheBatmobile));       boolean testEquality= ligntningMcQueen.equals(TheBatmobile); 
        if(testEquality){
            System.out.println("ligntningMcQueen is equal to TheBatmobile");
        }else{          
            System.out.println("ligntningMcQueen is NOT equal to TheBatmobile");
        }

        System.out.println("According to Ligfnting McQueen this is How you Drive & Steer: ");
        testDrive ((Drivable)ligntningMcQueen);
        ligntningMcQueen.steer();
        System.out.println("According to The Batmobile this is How you Drive it: ") ;
        testDrive ((Drivable)TheBatmobile);  
        TheBatmobile.steer();
        int speedDifference = ligntningMcQueen.compareTo(TheBatmobile);
        if(speedDifference>0){
            System.out.println("Lightning McQueen is faster than The Batmobile "+speedDifference+"mph");
        }
        else{
            System.out.println("The Batmobile is faster than Lightning McQueen by "+speedDifference+"mph");
        }
        
    }

    public static void testDrive(Drivable d) {
        System.out.println(d.howToDrive());
    }
        
}
