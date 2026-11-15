import java.util.ArrayList;
import java.util.List;


public class Collection {

    private String collectionName;

    private List<Osoba> lista = new ArrayList<Osoba>();


    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }


    public boolean contains(Osoba osoba) {
        return lista.contains(osoba);
    }

    public Collection(String collectionName, List<Osoba> lista) {
        this.collectionName = collectionName;
        this.lista = lista;
    }
}
