public class Person implements Comparable<Person>{

    private int age;
    private String name;

    Person (String name, int age){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

//    @Override
//    public int compareTo(Person o) {
//        return this.name.compareTo(o.name);
//    }

    @Override
    public int compareTo(Person o){
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
