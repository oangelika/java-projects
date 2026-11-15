public class Car {

    private String brand;
    private double engineVolume;
    private int millage;

    public Car (String brand, double engineVolume, int millage){
        this.brand = brand;
        this.engineVolume = engineVolume;
        this.millage = millage;
    }

    public String getBrand(){
        return this.brand;

    }

    public int getMillage(){
        return this.millage;

    }
    public void setBrand(String brand){
        this.brand = brand;

    }

    public void drive(){
        this.millage += 100;

    }
}
