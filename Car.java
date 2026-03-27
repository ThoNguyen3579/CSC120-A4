
import java.util.ArrayList;
import java.util.List;


public class Car implements CarRequirements {

    //Attributes
    public ArrayList<Passenger> Passenger_ArrayList; // a public list of passenger 
    private int Capacity; // a private capacity type int

     /**
     * Constructor
     * @param Capacity (type int)
     * @return Capacity of type int and Passenger_ArrayList - a modifiable list of Passenger
     */
    public Car(int Capacity) {
        // initialize the constructor
        this.Capacity = Capacity; 
        this.Passenger_ArrayList = new ArrayList<Passenger>(Capacity);    // return a list of passenger with the limit size of the capacity
    }

    /**
    * getter for Capacity
    */
    public int getCapacity(){
        return this.Capacity;
    }

    /**
    * setter for capacity
    */
    public void setCapacity(int newCapacity){
        this.Capacity = newCapacity;
    }

    /**
    * @return the number of remaining seats through subtracting number of passengers in the list from capacity
    */
    public int seatsRemaining(){
        int seatsRemaining = this.Capacity - this.Passenger_ArrayList.size();
        return seatsRemaining;
    }

    /**
    * add passenger from the car 
    * @param p (type Passenger)
    * @return `True` if the operation was successful, and `False` otherwise.
    */
    public Boolean addPassenger(Passenger p){
        int old_list_size = this.Passenger_ArrayList.size(); // storing the intial number of passengers
        if (seatsRemaining() > 0){ // if the seat remaining are > 0
            if (!this.Passenger_ArrayList.contains(p)){
            Passenger_ArrayList.add(p); //add passenger to the list
            }
        }
        return Passenger_ArrayList.size() == old_list_size+1; // Return True if the size of the list increases by 1 and false otherwise
    }
    
    /**
    * remove passenger from the car 
    * @param p (type Passenger)
    * @return `True` if the operation was successful, and `False` otherwise.
    */
    public Boolean removePassenger(Passenger p){
        int old_list_size = this.Passenger_ArrayList.size(); // storing the intial number of passengers
        if (Passenger_ArrayList.contains(p)){ // if the list of passenger contains passenger p, remove them
            Passenger_ArrayList.remove(p);
        }
        return Passenger_ArrayList.size() == old_list_size-1; // Return True if the size of the list decreases by 1 and false otherwise
    }

    /**
    * print out the list of passengers nicely formatted
    */
    public void printManifest(){
        StringBuilder Passenger_StringBuilder = new StringBuilder(this.Passenger_ArrayList.size()); // create a string builder
        for (Passenger p: this.Passenger_ArrayList){ // add elements in Passenger_ArrayList into this string builder
            String new_p = p + "\r\n"; // creating a string with passenger and adding new line 
            Passenger_StringBuilder.append(new_p); // append the string to the string builder
        }
        if(this.Passenger_ArrayList.isEmpty()){
            System.out.println("This car is EMPTY."); // print message if car is empty
        } else {
        System.out.println(Passenger_StringBuilder.toString()); // if car is not empty, print out the string builder that is converted to string
    }
    }


    public static void main(String[] args) {
        Car my_Car = new Car(100);
        Passenger myPassenger = new Passenger("mimi");
        Passenger hia = new Passenger("Hia");
        my_Car.addPassenger(myPassenger);
        my_Car.addPassenger(hia);
        my_Car.addPassenger(hia);
        my_Car.printManifest();
        my_Car.removePassenger(myPassenger);
        my_Car.printManifest();
        my_Car.removePassenger(myPassenger);
    }
}