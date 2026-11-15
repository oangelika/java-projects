public class Car {
    private int fuelLevel;

    public Car(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public static void drive(Car car, int distance) {
        int fuelConsumption = 10;

        if (car.fuelLevel >= distance * fuelConsumption) {
            System.out.println("Uruchom silnik!");
        } else {
            System.out.println("Brak wystarczającej ilości paliwa!");
        }
    }

}