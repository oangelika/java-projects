public class PractiseRoom extends Room {

    public int computerAmmount;

    public PractiseRoom(int computerAmmount){
        this.computerAmmount = computerAmmount;
    }

    @Override
    public void numberComputerOff(){
        System.out.println(20);
    }

    @Override
    public void numberComputerOn(){
        System.out.println(2);
    }

    @Override
    public void getNumber(){
        System.out.println(999);
    }
}
