public class Car extends Vehicle {

    protected int capacity;

    public Car(String name, double speed, int capacity) {
        super(name, speed);
        this.capacity = capacity;
    }

    @Override
    public void drive(){
        System.out.println("Car" + speed);
    }
}
