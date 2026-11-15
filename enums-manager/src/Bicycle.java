public class Bicycle extends Vehicle {

    private String type;

    public Bicycle(int amountOfWheels, int maxSpeed, String type) {
        super(amountOfWheels, maxSpeed);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void drive(){
        System.out.println("I'm bicycle, I drive, I have " + getAmountOfWheels() +
                " wheels and " + getMaxSpeed() + " miles away. " +
                "I using for " + type);
    }
}
