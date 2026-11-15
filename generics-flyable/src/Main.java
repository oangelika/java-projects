public class Main {
    public static void main(String[] args) {

        System.out.println(Main.sum ("fly", "rise"));

        System.out.println(Main.getType(new Starship()));
    }

    public static <T> T sum(T p1, T p2){
        if (p1 instanceof String && p2 instanceof String) {
            return (T) ((String) p1 + (String) p2); // Конкатенация строк
        } else if (p1 instanceof Integer && p2 instanceof Integer) {
            return (T) (Integer) ((Integer) p1 + (Integer) p2); // Сложение целых чисел
        } else {
            throw new IllegalArgumentException("Unsupported types for addition.");
        }
    }

    public static <T extends Starship> String getType(T obj ){
        return obj.getClass().getSimpleName();

    }


}