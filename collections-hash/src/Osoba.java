public class Osoba {

    private String imie;

    private int rokUrodzenia;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }


    public Osoba(String imie, int rokUrodzenia) {
        this.imie = imie;
        this.rokUrodzenia = rokUrodzenia;
    }

    public static boolean wKolekcji(Collection kol, String imie, int rokUrodzenia) {
        return kol.contains(new Osoba(imie, rokUrodzenia));

    }

    public int compareTo(Osoba o) {
               int result = this.imie.compareTo(o.imie);
               if (result == 0) {
                   result = Integer.compare(this.rokUrodzenia, o.rokUrodzenia);
               }
               return result;
           }
       }

