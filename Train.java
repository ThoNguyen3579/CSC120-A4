
import java.util.ArrayList;

public class Train implements TrainRequirements{
    
    // Attributes
    private Engine engine; // an engine for train to run
    private ArrayList<Car> cars; // the list of cars currently attached

    /**
     * Constructor
     */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, 
        int nCars, int passengerCapacity) {
        // initialize the constructor
        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity); // create a new engine
        this.cars = new ArrayList<Car>(nCars); // create a list of cars with nCars attached
        for (int i = 0; i < nCars; i++) {
            this.cars.get(i).setCapacity(passengerCapacity); // set the capacity of the cars
        }
    }

    /**
    * getter for engine
    * @return engine (type Engine)
    */
    public Engine getEngine(){
        return this.engine;
    }

    /**
    * getter for a specific car
    * @param i (type int)
    * @return car_i(type Car)
    */
    public Car getCar(int i){
        Car car_i = cars.get(i);
        return car_i;
    } 

    /**
    * getter for the maximum total capacity across all cars
    * @return maximum total capacity (type int)
    */
    public int getMaxCapacity(){
        int sum = 0; // initial value for the total maximum capacity
        for (int i = 0; i < this.cars.size(); i++) {
            sum += this.cars.get(i).getCapacity(); // add up the total maximum capacity
        }
        return sum; // return the total maximum capacity
    }

    /**
    * getter for the number of remaining open seats across all cars
    * @return number of seats remaning (type int)
    */
    public int seatsRemaining(){
        int seatsRemaining = 0; // set initial value for seats remaining
        for (int i = 0; i < cars.size(); i++) {
            seatsRemaining += this.cars.get(i).seatsRemaining(); // sum up the number of seats remaining in each car
        }
        return seatsRemaining; // return total seat remaining
    }

    /**
     * print a roster of all passengers
    */
    public void printManifest(){
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).printManifest();
        }

    }
}
