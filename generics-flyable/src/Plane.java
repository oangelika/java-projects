public class Plane implements Flyable <String>{


    @Override
    public String getT(){
        return "air";
    }

    @Override
    public String getSound(){
        return "motor";
    }
}
