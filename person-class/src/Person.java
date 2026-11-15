public class Person {

    private String name;
    private String street;
    private int house;


    public Person(String name, String street, int house) {
        this.name = name;
        this.street = street;
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void getAdress(){
        System.out.println(street + " " + house);
    }
}
