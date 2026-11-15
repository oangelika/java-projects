public class Bus extends Vehicle {

    protected int wheel;

    public Bus(String name, double speed, int wheel) {
        super(name, speed);
        this.wheel = wheel;
    }

    @Override
    public void drive() {
        System.out.println("Bus" + speed);
    }
}
