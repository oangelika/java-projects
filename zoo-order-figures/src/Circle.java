public class Circle implements Figure {

    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double square(){
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimeter(){
        return 2 * Math.PI * radius;
    }


}
