package specyfikacji;

import realizacja.*;

import java.util.Arrays;
import java.util.List;

public class KoszykSpec {
    public static Double obliczCene(Zamowienie t, InformacjaKlienta cu) {

        CenaSamochodu carPrice = Cennik.pobierzCennik().pobierzCeneSamochodu(t.pobierzNazweSamochodu());
        if (cu.pobierzAbonament() && carPrice.pobierzCeneAbonament() != null)
            return carPrice.pobierzCeneAbonament() * t.pobierzOdleglosc();

        if (carPrice.pobierzOdlegloscN() == null || t.pobierzOdleglosc() <= carPrice.pobierzOdlegloscN())
            return carPrice.pobierzCeneNizejN() * t.pobierzOdleglosc();

        return carPrice.pobierzCeneNizejN() * carPrice.pobierzOdlegloscN()
                + carPrice.pobierzCeneWyzejN() * (t.pobierzOdleglosc() - carPrice.pobierzOdlegloscN());
    }

    public static Double applyCommission(Double price, SposobOplaty type) {
        return switch (type) {
            case KARTA -> price * 1.01;
            case PRZELEW -> price;
        };
    }

    public static boolean hasMoney(Double d, Double quota) {
        if (d <= quota)
            return true;
        return false;
    }

    public static boolean quotaDepleted(Double d, InformacjaKlienta cu) {
        Double quota = cu.pobierzKwote();
        if (d <= quota) {
            cu.zmienKwote(quota - d);
            return true;
        }
        return false;
    }

    public static List<Zamowienie> splitOrder(Zamowienie t, InformacjaKlienta cu, SposobOplaty type) {
        CenaSamochodu carPrice = Cennik.pobierzCennik().pobierzCeneSamochodu(t.pobierzNazweSamochodu());
        Double totalQ = obliczCene(t, cu);
        Double partQ = cu.pobierzKwote();
        Integer totalD = t.pobierzOdleglosc();
        Double c = applyCommission(1.0, type);
        Integer thresD = carPrice.pobierzOdlegloscN();
        Double k2 = carPrice.pobierzCeneWyzejN();
        Double k1 = carPrice.pobierzCeneNizejN();
        Integer partD = (int) (partQ * totalD / totalQ / c);

        if (k2 != null && k2 != 0)
            partD = (int) (totalD - (totalQ - partQ / c) / k2);
        if (thresD != null && partD <= thresD)
            partD = (int) (partQ / k1 / c);
        Zamowienie executedOrder;
        Zamowienie remainingOrder;
        try {
            executedOrder = t.clone();
            remainingOrder = t.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
        executedOrder.zmienOdleglosc(partD);
        remainingOrder.zmienOdleglosc(totalD - partD);

        return Arrays.asList(executedOrder, remainingOrder);
    }
}
