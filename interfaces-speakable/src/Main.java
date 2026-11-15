import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Flyable fly1 = new Plane();
        Flyable fly2 = new Virus();
        Flyable fly3 = Flyable.hybrid(fly1, fly2);
        Flyable[] fly = {fly1, fly2, fly3};

        Speakable speak1 = () -> "Hello";
        Speakable speak2 = new UFO() {
            @Override
            public String speak() {
                return "Bup-Bup";
            }
        };

        Speakable speak3 = new Bird();
        Speakable[] speak = {speak1, speak2, speak3};
        System.out.println(odleglosc(fly).getClass().getName() + ' ' + odleglosc(fly).distance());
        System.out.println(najglosniejszy(speak).getClass().getName() + ' ' + najglosniejszy(speak).speak());

    }


    public static Flyable odleglosc(Flyable[] fly) {
        Flyable min = fly[0];
        for (int i = 1; i < fly.length; i++) {
            if (min.distance() > fly[i].distance()) {
                min = fly[i];
            }
        }
        return min;
    }

    public static Speakable najglosniejszy(Speakable[] speak) {
        Speakable max = speak[0];
        for (int i = 1; i < speak.length; i++) {
            if (max.speak().length() < speak[i].speak().length()) {
                max = speak[i];
            }
        }
        return max;
    }
}