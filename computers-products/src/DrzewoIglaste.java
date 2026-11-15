public class DrzewoIglaste extends Drzewo {
    private int iloscIgiel;
    private double dlugoscSzyszki;

    public DrzewoIglaste(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, int iloscIgiel, double dlugoscSzyszki) {
        super(wiecznieZielone, wysokosc, przekrojDrzewa);
        this.iloscIgiel = iloscIgiel;
        this.dlugoscSzyszki = dlugoscSzyszki;
    }

    public int getIloscIgiel() {
        return iloscIgiel;
    }

    public double getDlugoscSzyszki() {
        return dlugoscSzyszki;
    }

    public String toString() {
        return "DrzewoIglaste{" +
                "wiecznieZielone=" + isWiecznieZielone() +
                ", wysokość=" + getWysokosc() +
                ", przekrój drzewa='" + getPrzekrojDrzewa() + '\'' +
                ", ilość igieł=" + iloscIgiel +
                ", długość szyszek=" + dlugoscSzyszki +
                '}';
    }
}