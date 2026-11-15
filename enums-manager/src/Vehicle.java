public class Vehicle {

    private int amountOfWheels;
    private int maxSpeed;

    public Vehicle(int amountOfWheels, int maxSpeed) {
        this.amountOfWheels = amountOfWheels;
        this.maxSpeed = maxSpeed;
    }

    public void drive(){};

    public int getAmountOfWheels() {
        return amountOfWheels;
    }

    public void setAmountOfWheels(int amountOfWheels) {
        this.amountOfWheels = amountOfWheels;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
