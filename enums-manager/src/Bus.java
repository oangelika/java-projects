public class Bus extends Vehicle {

    private int amountOfPassengers;

    public Bus(int amountOfWheels, int maxSpeed, int amountOfPassengers) {
        super(amountOfWheels, maxSpeed);
        this.amountOfPassengers = amountOfPassengers;
    }

    public int getAmountOfPassengers() {
        return amountOfPassengers;
    }

    public void setAmountOfPassengers(int amountOfPassengers) {
        this.amountOfPassengers = amountOfPassengers;
    }

    @Override
    public void drive(){
        System.out.println("I'm car, I drive, I have " + getAmountOfWheels() +
                " wheels and " + getMaxSpeed() + " miles away. " +
                "I have " + amountOfPassengers + " passengers.");
    }
}
