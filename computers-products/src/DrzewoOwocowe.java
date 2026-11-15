public class DrzewoOwocowe extends DrzewoLisciaste {
    private String nazwaOwoca;

    public DrzewoOwocowe(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, int ksztaltLiscia, String nazwaOwoca) {
        super(wiecznieZielone, wysokosc, przekrojDrzewa, ksztaltLiscia);
        this.nazwaOwoca = nazwaOwoca;
    }

    public String getNazwaOwoca() {
        return nazwaOwoca;
    }

    public String toString() {
        return "DrzewoOwocowe{" +
                "wiecznieZielone=" + isWiecznieZielone() +
                ", wysokość=" + getWysokosc() +
                ", przekrój drzewa='" + getPrzekrojDrzewa() + '\'' +
                ", kształt liścia=" + getKsztaltLiscia() +
                ", nazwa owoca='" + nazwaOwoca + '\'' +
                '}';
    }
}