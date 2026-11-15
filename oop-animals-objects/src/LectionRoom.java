public class LectionRoom extends Room{

    public int NumberRoom;

    public LectionRoom(int NumberRoom){
        this.NumberRoom = NumberRoom;
    }


    @Override
    public void getNumber(){
        System.out.println(345);
    }

    @Override
    public void numberComputerOff(){
        System.out.println(0);
    }

    @Override
    public void numberComputerOn(){
        System.out.println(0);

    }


}
