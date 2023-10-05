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

public class Triangle {

    private double side1;
    private double side2;
    private double side3;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public Triangle(){
        this.side1= this.side2= this.side3= 1.0;
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
        String toStr= "Side1 "+this.side1+" Side2 "+this.side2+" Side3 "+this.side3;
         return toStr;
    }
}
