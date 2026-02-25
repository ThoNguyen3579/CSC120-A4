public class Passenger implements PassengerRequirements{
     //attribute
    private String name; // name of passenger (string type)

    /**
    * Constructor
    * @param name (type String)
    * @return passenger name (type String)
    */
    public Passenger(String name) {
        // initialize the constructor
        this.name = name; // return passenger name
    }

    /**
    * turn the object into human readable message when printed out
    */
    public String toString(){
        return this.name;
    }

    /**
    * board a passenger onto a specific car using car class
    * @param c (type car)
    */
    public void boardCar(Car c){
        Boolean on_board = c.addPassenger(this);
        if (on_board){ 
            // print messages according to different situtations
            System.out.println("Passenger "+ this + " is on board!");
        } else {
            System.out.println("Nah this car is full, cannot add!");
        }
    }

        /**
    * remove a passenger out of a specific car using car class
    * @param c (type car)
    */
    public void getOffCar(Car c){
        Boolean off_car = c.addPassenger(this);
        if (off_car){
            // print messages according to different situtations
            System.out.println("Passenger " + this + " is out of the car!");
        } else {
            System.out.println("Nah the passenger is not on board, cannot remove!");
        }    }

    public static void main(String[] args) {
        Car my_Car = new Car(100);
        Passenger myPassenger = new Passenger("mimi");
        Passenger hia = new Passenger("Hia");
        myPassenger.boardCar(my_Car);
        hia.boardCar(my_Car);
        myPassenger.getOffCar(my_Car);
        myPassenger.getOffCar(my_Car);
    }
}
