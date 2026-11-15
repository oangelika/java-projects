public class CalculatingDevice {
    private String name;

    public CalculatingDevice(String name) {
        this.name = name;
    }

    public String calculate(double x, double y) {
        String result = name + ": " + x + "+" + y + "=" + (x + y);
        return result;
    }

    public static void printRes(CalculatingDevice[] a, double x, double y) {
        for (CalculatingDevice device : a) {
            String result = device.calculate(x, y);
            System.out.println(result);
        }
    }
}



