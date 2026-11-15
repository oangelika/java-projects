public class Main1 {
    public static void main(String[] args) {
        Person person = new Person("John Smith");
        System.out.println(person.display());

        Firefighter firefighter = new Firefighter("Mike Johnson", "10 years");
        System.out.println(firefighter.display());
    }
}

