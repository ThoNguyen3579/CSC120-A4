
import java.util.ArrayList;

public class Train implements TrainRequirements{
    
    // Attributes
    private Engine engine; // an engine for train to run
    private ArrayList<Car> cars; // the list of cars currently attached
    private int passengerCapacity; // total capacity of the whole train

    /**
     * Constructor
     */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, 
        int nCars, int passengerCapacity) {
        // initialize the constructor
        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity); // create a new engine
        this.cars = new ArrayList<Car>(nCars); // create a list of cars with nCars attached
        this.passengerCapacity = passengerCapacity;

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
        Car car_i = this.cars.get(i);
        return car_i;
    } 

    /**
    * getter for the maximum total capacity across all cars
    * @return maximum total capacity (type int)
    */
    public int getMaxCapacity(){
        return this.passengerCapacity;
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
        System.out.println("There are " + cars.size() + " cars attached to this train");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("The passengers in car " + (i+1) + " are:");
            cars.get(i).printManifest();
        }

    }
    public static void main(String[] args) {
        Car myCar = new Car(30);
        Car yourCar = new Car(25);

        Passenger robbert = new Passenger("Robbert");
        Passenger ella = new Passenger("Ella");
        Passenger michelle = new Passenger("Michelle");
        Passenger jude = new Passenger("Jude");
        
        myCar.addPassenger(ella);
        myCar.addPassenger(robbert);
        yourCar.addPassenger(michelle);
        yourCar.addPassenger(jude);

        Train myTrain = new Train(FuelType.ELECTRIC , 57.0, 100.0 , 2 , 100 );
        myTrain.cars.add(myCar);
        myTrain.cars.add(yourCar);

        myTrain.printManifest();
    }

}
