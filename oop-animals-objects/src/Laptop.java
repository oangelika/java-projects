public class Laptop extends Device {

    public int batteryPower;

    public Laptop (int cpuFr, int screenDiagonal){
        super(cpuFr, screenDiagonal);

        this.batteryPower = 100;

    }

    public void uselaptop(){
        System.out.println("You are using laptop");
        this.batteryPower -= 1;
    }

    public void shareScreen(int diagonal){
        this.screenDiagonal = diagonal;
    }

    @Override
    public void getInfo() {
        System.out.println("Hello from Laptop");

    }


}
