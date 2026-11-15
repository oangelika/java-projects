public class Manager extends Person{

    private String name;
    private int age;
    private String street;
    private int house;

    public Manager(String name, int age, String street, int house) {
        this.name = name;
        this.age = age;
        this.street = street;
        this.house = house;
    }

    @Override
    public void SayHello(){
        System.out.println("Hello, my name is " + name +
                " and I am " + age + " years old. " +
                "I live on " + street + " " + house);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }


}
