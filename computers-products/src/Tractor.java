public class Tractor extends VehicleWithWheels {
    private int mass;

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void startDriving() {
        if (mass > 11000) {
            System.out.println("Niebezpieczna jazda, odmowa uruchomienia silnika.");
        } else {
            System.out.println("Uruchomienie silnika");
        }
    }
}

