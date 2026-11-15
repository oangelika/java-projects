public class UFO implements Flyable, Speakable {
    @Override
    public String drive() {
        return "Antigravity";
    }

    @Override
    public double distance() {
        return 20000.0;
    }

    @Override
    public String speak() {
        return "Bep-Bop";
    }
}

