public class Pers <T, P extends Number>{

    public T id;
    public P value;


    public Pers(T id, P value){
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString(){
        return id + " " + value;
    }



}
