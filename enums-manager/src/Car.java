public class Car extends Vehicle{

    private int engineVolume;
    private int fuelConsumption;

    public Car(int amountOfWheels, int maxSpeed, int engineVolume, int fuelConsumption) {
        super(amountOfWheels, maxSpeed);
        this.engineVolume = engineVolume;
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;

    }

    @Override
    public void drive(){
        System.out.println("I'm car, I drive, I have " + getAmountOfWheels() +
                        " wheels and " + getMaxSpeed() + " miles away. " +
                "My engine volume is " + getEngineVolume() +
                " and I can eat " + fuelConsumption + " liters of fuel.");
    }
}
