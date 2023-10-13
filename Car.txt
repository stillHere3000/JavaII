
/*
 *     3. Write a concrete subclass named Car that extends the Vehicle class and implements the Drivable 
 * and Comparable interfaces. 
 *     (i) The class should contain a String data field: model and an integer data field: speed. 
 *         Provide appropriate constructors and setter/getter methods for this class.  
 *     (ii) Override the equals method in the Object class. Two Car objects are equal if their models are the same. 
 *     (iii) Implement the steer() method to display “Turn steering wheel.” 
 *     (iv) Implement the howToDrive() method that returns a string “Step on gas pedal.” 
 *     (v) Implement the compareTo method to compare two cars on the basis of speed. 
 * 
 */
public class Car extends Vehicle implements Drivable, Comparable<Car> {
    private String model;
    private int speed;

    public Car() {
        super();
        this.model = "unknown";
        this.speed = 0;
    }

    public Car(String color, java.util.Date dateMade, String model, int speed) {
        super(color, dateMade);
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return this.model;
    }   

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return this.speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void steer() {
        System.out.println("Turn steering wheel.");
    }

    @Override
    public String howToDrive() {
        return "Step on gas pedal.";
    }

    @Override
    public int compareTo(Car car) {
        return this.speed - car.getSpeed();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Car) {
            return this.model.equals(((Car) o).getModel());
        }
        return false;
    }

    public String toString() {
        return "\nCar: " + this.model + "\tSpeed:" + this.speed + "mph\t"+super.toString();
    }
}   
    

