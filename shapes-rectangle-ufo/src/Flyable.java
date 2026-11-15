public interface Flyable {

    String drive();

    double distance();

    static Flyable hybrid(Flyable objectA, Flyable objectB) {
        return new Flyable() {
            @Override
            public String drive() {
                return objectA.drive() + objectB.drive();
            }

            @Override
            public double distance() {
                return (objectA.distance() > objectB.distance() ? objectA.distance() : objectB.distance());
            }
        };
    }

}

