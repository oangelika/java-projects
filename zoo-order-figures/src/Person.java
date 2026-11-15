public class Person {

    private String name;
    private String surname;
    private int age;

    Person (String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void getData(){
        System.out.println(this.name + " " + this.surname + " " + this.age);
    }

    public void setAge(int age){
        this.age = age;
    }
}
