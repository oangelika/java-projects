public class Starship implements Flyable <Integer>{

    @Override
    public Integer getT(){
        return 800;
    }


    @Override
    public String getSound(){
        return "motor, fly";
    }
}
