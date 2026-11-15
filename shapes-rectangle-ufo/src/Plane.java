public class Plane implements Flyable{

    private String model;

    public Plane(String model){
        this.model = model;
    }

    @Override
    public String drive(){
        return "Boeing 777";
    }
    @Override
    public double distance(){
        return 200.0;
    }

}
