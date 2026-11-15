public class Calculator extends CalculatingDevice {

    public Calculator(String name) {
        super(name);
    }
    public String calculate(double x, double y) {
        String result = super.calculate(x, y) + "; " + x + "-" + y + "=" + (x - y);
        return result;
    }
}