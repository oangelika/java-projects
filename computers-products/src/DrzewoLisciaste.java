public class DrzewoLisciaste extends Drzewo {
    private int ksztaltLiscia;

    public DrzewoLisciaste(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, int ksztaltLiscia) {
        super(wiecznieZielone, wysokosc, przekrojDrzewa);
        this.ksztaltLiscia = ksztaltLiscia;
    }

    public int getKsztaltLiscia() {
        return ksztaltLiscia;
    }

    public String toString() {
        return "DrzewoLisciaste{" +
                "wiecznieZielone=" + isWiecznieZielone() +
                ", wysokość=" + getWysokosc() +
                ", przekrój drzewa='" + getPrzekrojDrzewa() + '\'' +
                ", kształt liścia=" + ksztaltLiscia +
                '}';
    }
}