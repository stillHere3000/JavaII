/*
 * Design a class named Triangle that extends GeometricObject (as shown below).  
 * The class should contain the following three private double data fields: side1, side2, side3 with default values 1.0 
 * to denote three sides of the triangle.  

In addition, the class should have the following constructors and methods:
    1. A no-arg constructor that initializes all three sides to 0 .
    2. A constructor that creates a triangle with the specified side1, side2, and side3. 
    3. The setter methods for three data fields. 
    4. The getter methods for three data fields. 
    5. A method named getPerimeter() that returns the perimeter of this triangle.
    6. A method named toString() that returns a string description for the triangle. 
 */

 import java.util.Scanner;




public class Triangle {

    private double side1;
    private double side2;
    private double side3;
    private GeometricObject gObj;

    /*
     * Write a test program that does the following tasks:
    1. Prompts the user to enter three sides of the triangle. 
    - The program creates a Triangle object with these sides. 
    - Prompt the user to enter a color and a Boolean value to indicate whether the triangle is filled. 
    - Use these two input values to set the data fields color and filled. 
    2. Invoke the Triangle object’s getPerimeter() and toString() methods. 
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Please the three sides of a the Triangle");
        Scanner userInput= new Scanner(System.in);
        Triangle T= captureTriangleValues(userInput);  
        T.gObj =    captureGeometricValues(userInput);
        System.out.println(T.toString());
        
    }

    public static Triangle captureTriangleValues(Scanner in ){
        double sd1, sd2, sd3; sd1= sd2= sd3= 1.0;
        for(int i = 0;  i < 3 ; i++){
           switch(i){                
                case 0:    sd1= in.nextDouble();       break;
                case 1:    sd2= in.nextDouble();       break;
                case 2:    sd3= in.nextDouble();       break;
                default:                            break;
           }
        }
        return (new Triangle(sd1, sd2, sd3)); 
    }

    public static GeometricObject captureGeometricValues(Scanner in ){
        String color="white";  Boolean filled= false;  String tmpColor;
        for(int i = 0;  i < 3 ; i++){
           switch(i){                
                case 0:    
                    System.out.println("Please Enter the Color");
                    tmpColor= in.next();
                    color = ( tmpColor== "")?"white":tmpColor;
                break;
                case 1:    
                    System.out.println("Is the Triangle Filled (Y)es or (N)o");
                    int temp= Character.toUpperCase(in.next().charAt(0) );
                    filled= (temp == 'Y' )?true:false;
                break;
                
                default:                            break;
           }
        }
        return (new GeometricObject(color, filled)); 
    }

    public Triangle(){
        this.side1= this.side2= this.side3= 1.0;
        this.gObj= new GeometricObject();
       
    }

    public Triangle(double side1, double side2, double side3){
        side1= side2= side3= 1.0;
    }

    public void setSide1(double sd){
        this.side1= (sd >= 0)? sd: 0 ;
    }
 
     public double getSide1(){
         return this.side1;
    }

    public void setSide2(double sd){
        this.side2= (sd >= 0)? sd: 0 ;
    }
 
    public double getSide2(){
         return this.side2;
    }

    public void setSide3(double sd){
        this.side3= (sd >= 0)? sd: 0 ;
    }
 
    public double getSide3(){
         return this.side3;
    }

    public double getPerimeter(){
         return this.side1+this.side2+this.side3;
    }

    public String toString(){
        String toStr= "\nSide1 "+this.side1+" Side2 "+this.side2+" Side3 "+this.side3+"\n";
        toStr= toStr + this.gObj.toString();
        return toStr;
    }
}
