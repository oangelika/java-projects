public class Bird implements Flyable, Speakable {
    @Override
    public String drive() {
        return "Wings";
    }

    @Override
    public double distance() {
        return 20.0;
    }

    @Override
    public String speak() {
        return "Chirk-Chirk";
    }
}
