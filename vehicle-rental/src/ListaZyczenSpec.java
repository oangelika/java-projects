package specyfikacji;

import java.util.function.Function;
import java.util.function.Predicate;

import realizacja.*;

public class ListaZyczenSpec {
    // Perhaps there are cars that do not have a price in the price list, then when
    // re-packing from the wish list to the cart, they are not removed from the wish
    // list and will not be added to the cart.
    // Predicate function to cover the "no price" use case
    /*Być może są samochody, które nie mają ceny w cenniku,
    to przy przepakowaniu z listy życzeń do koszyka
    nie zostaną usunięte z listy życzeń i nie zostaną dodane do koszyka.
    Funkcja predykatu obejmuje przypadek użycia "bez ceny"*/
    public static Predicate<Zamowienie> wishRepack = new Predicate<>() {
        @Override
        public boolean test(Zamowienie t) {
            if (Cennik.pobierzCennik().pobierzCeneSamochodu(t.pobierzNazweSamochodu()) != null)
                return true;
            return false;
        }
    };

    // darmowy przejazd tylko dla abonentów
    // Predicate function to cover the "free ride" use case
    public static Predicate<Zamowienie> subFreeride = new Predicate<>() {
        @Override
        public boolean test(Zamowienie t) {
            Double price = Cennik.pobierzCennik().pobierzCeneSamochodu(t.pobierzNazweSamochodu()).pobierzCeneAbonament();
            if (price == null) {
                return false;
            }
            if (price != 0)
                return false;

            return true;
        }
    };

    // adjust allowed free distance not to exceed the limit in the Price list
    public static Function<Zamowienie, Integer> adjustFreeDistance = new Function<>() {
        @Override
        public Integer apply(Zamowienie t) {
            int distanceThres = Cennik.pobierzCennik().pobierzCeneSamochodu(t.pobierzNazweSamochodu()).pobierzOdlegloscN();
            if (t.pobierzOdleglosc() > distanceThres)
                t.zmienOdleglosc(distanceThres);
            return t.pobierzOdleglosc();
        }
    };

    public static String priceDisplay(Zamowienie t, InformacjaKlienta cu) {

        if (!wishRepack.test(t))
            return "brak";

        CenaSamochodu carPrice = Cennik.pobierzCennik().pobierzCeneSamochodu(t.pobierzNazweSamochodu());
        if (cu.pobierzAbonament() && carPrice.pobierzCeneAbonament() != null)
            return String.format("%.2f", carPrice.pobierzCeneAbonament());

        if (carPrice.pobierzOdlegloscN() == null || t.pobierzOdleglosc() <= carPrice.pobierzOdlegloscN())
            return String.format("%.2f", carPrice.pobierzCeneNizejN());

        return String.format("%1$.2f (do %2$d), %3$.2f (od %4$d)", carPrice.pobierzCeneNizejN(),
                carPrice.pobierzOdlegloscN(), carPrice.pobierzCeneWyzejN(), carPrice.pobierzOdlegloscN() + 1);
    }

    public static String wishDisplay(Zamowienie t, InformacjaKlienta cu) {
        return String.format(wishlistTemplate, t.pobierzNazweSamochodu(), t.pobierzTypSamochodu().pobierzTyp(), t.pobierzOdleglosc(), priceDisplay(t, cu));
    }

    private final static String wishlistTemplate = "%1$s, typ: %2$s, ile: %3$s km, cena %4$s\n";
}
