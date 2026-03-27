public class Engine implements EngineRequirements {

    // Attributes
    private FuelType f; // a FuelType f indicating what type of fuel it uses
    private double CurrentFuel; // a double storing the current fule level
    private double MaxFuel; // a double storing the maximum fule level

    /**
     * Constructor
     */
    public Engine(FuelType f, double CurrentFuel, double MaxFuel) {
        // initialize the constructor
        this.MaxFuel = MaxFuel;
        this.CurrentFuel = CurrentFuel;
        this.f = f;
    }

    /**
    * getter for f
    */
    public FuelType getFuelType() {
        return this.f;
    }

    /**
    * getter for MaxFuel
    */
    public double getMaxFuel() {
        return this.MaxFuel;
    }

    /**
    * getter for CurrentFuel
    */
    public double getCurrentFuel() {
        return this.CurrentFuel;
    }

    /**
    * reset the current fuel level to the maximum.
    */
    public void refuel(){
        this.CurrentFuel = this.MaxFuel;
    }    

    /**
    * decrease current fuel level
    * @return Boolean: True when current fuel level is > 0 and False otherwise
    */
    public Boolean go() {
        double n = 20;
        this.CurrentFuel -= n; // decrease 20 as train goes on
        System.out.println("The remaining current level is " + CurrentFuel);//print the remaining current fuel level
        return this.CurrentFuel >= n; // return true when current level > 0 
    }
    
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }
}
