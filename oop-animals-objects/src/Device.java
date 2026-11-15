public class Device {

    public int cpuFr;
    protected int screenDiagonal;

    public Device(int cpuFr, int screenDiagonal){
        this.cpuFr = cpuFr;
        this.screenDiagonal = screenDiagonal;
    }

    public void getInfo(){
        System.out.println("Hello from Device");
        System.out.println(this.cpuFr);
    }

    public void devicePrint(){
        System.out.println("It's device");
    }


}


