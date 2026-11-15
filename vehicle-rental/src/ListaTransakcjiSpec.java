package specyfikacji;

import realizacja.*;

import java.util.Arrays;
import java.util.List;

public class ListaTransakcjiSpec {
//    public static boolean refundEligible(Zamowienie t, TypSamochodu carType, String string, int i) {
//        if (!t.pobierzTypSamochodu().equals(carType))
//            return false;
//        if (!t.pobierzNazweSamochodu().equals(string))
//            return false;
//        if (t.pobierzOdleglosc() < i)
//            return false;
//        return true;
//    }

    public static List<Zamowienie> splitTransaction(Zamowienie t, int i) { // i to odleglosc
        Zamowienie refundedOrder;
        Zamowienie remainingOrder;
        try {
            refundedOrder = t.clone();
            if (i >= t.pobierzOdleglosc()) {

                refundedOrder.zmienOdleglosc(t.pobierzOdleglosc());
                remainingOrder = null;
            } else {
                refundedOrder.zmienOdleglosc(i);
                remainingOrder = t.clone();
                remainingOrder.zmienOdleglosc(t.pobierzOdleglosc() - i);
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }

        return Arrays.asList(refundedOrder, remainingOrder);
    }

}
