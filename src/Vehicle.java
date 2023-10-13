
/*
 * 
 *     1. Write an abstract superclass called Vehicle that contains the following private data fields: 
color: a string that holds the color of the vehicle.  
     dateMade: the date the vehicle was manufactured. 
                  Provide appropriate constructors and setter/getter methods for this class. 
                  Include an abstract void method named steer().
 * 
 */
public abstract class Vehicle {
    private String color;
    private java.util.Date dateMade;

    public Vehicle() {
        this.color = "white";
        this.dateMade = new java.util.Date();
    }

    public Vehicle(String color, java.util.Date dateMade) {
        this.color = color;
        this.dateMade = dateMade;
    }

    public String getColor() {
        return this.color;
    }   

    public void setColor(String color) {
        this.color = color;
    }

    public java.util.Date getDateMade() {
        return this.dateMade;
    }
    
    public void setDateMade(java.util.Date dateMade) {
        this.dateMade = dateMade;
    }

    public abstract void steer();

    public String toString() {
        return "\tColor: " + this.color + "\tDate made: " + this.dateMade;
    }
}
