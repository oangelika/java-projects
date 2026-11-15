public class Virus implements Flyable {
    @Override
    public String drive() {
        return "Bacteria";
    }

    @Override
    public double distance() {
        return 0.02;
    }
}
