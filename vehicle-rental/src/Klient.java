package realizacja;

import specyfikacji.KoszykSpec;
import specyfikacji.ListaTransakcjiSpec;
import specyfikacji.ListaZyczenSpec;

import java.util.*;
import java.util.stream.Collectors;

public class Klient extends InformacjaKlienta {
    private ListaZyczen listaZyczen;
    private Koszyk koszyk;
    private ListaTransakcji transakcji;

    public Klient(String id, double kwota, boolean abonament) {
        super(id, kwota, abonament);
        listaZyczen = new ListaZyczen(pobierzInformacjeKlienta());
        koszyk = new Koszyk(pobierzInformacjeKlienta());
        transakcji = new ListaTransakcji(pobierzInformacjeKlienta());
    }

    public void dodaj(Zamowienie zamowienie) {
        if (zamowienie instanceof Darmo && !pobierzAbonament()) // filter when adding to wishlist //1 sposob
            return;
        listaZyczen.dodaj(zamowienie);
    }

    public ListaZyczen pobierzListeZyczen() {
        //2 sposob
//        Map<String, Zamowienie> map = listaZyczen.pobierzListe().entrySet().stream()
//                .filter(entry -> (ListaZyczenSpec.wishRepack.and(ListaZyczenSpec.subFreeride).test(entry.getValue()) && !pobierzAbonament()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//
//        listaZyczen.pobierzListe().keySet().removeAll(map.keySet());
        return listaZyczen;
    }

    public Koszyk pobierzKoszyk() {
        return koszyk;
    }

    public void przepakuj() {
        listaZyczen.pobierzListe().entrySet().stream().filter(entry -> ListaZyczenSpec.wishRepack.test(entry.getValue()))
                .forEach(entry -> koszyk.dodaj(entry.getValue()));
        listaZyczen.pobierzListe().keySet().removeAll(koszyk.pobierzListe().keySet());
    }

    public void zaplac(SposobOplaty sposobOplaty) {
// очистит список предыдущих транзакций перед новой оплатой
// чтобы нельзя было сделать возврат средств на предыдущие транзакции перед последней
        transakcji.pobierzListe().clear();

        Comparator<Zamowienie> priceComparator = (zamowa1, zamowa2) -> {
            double priceKm1 = KoszykSpec.obliczCene(zamowa1, pobierzInformacjeKlienta()) / zamowa1.pobierzOdleglosc();
            double priceKm2 = KoszykSpec.obliczCene(zamowa2, pobierzInformacjeKlienta()) / zamowa2.pobierzOdleglosc();
            return Double.compare(priceKm1, priceKm2);
        };
        Map<String, Zamowienie> sortedOrders = koszyk.pobierzListe().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(priceComparator.reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        sortedOrders.values().stream().filter(o -> ListaZyczenSpec.subFreeride.test(o)).forEach(o -> {
            transakcji.dodaj(o);
            koszyk.usun(o);
        });

        Iterator<Zamowienie> iterator = sortedOrders.values().iterator();
        while (iterator.hasNext()) {
            Zamowienie order = iterator.next();
//            Double orderPrice = KoszykSpec.applyCommission(KoszykSpec.calculatePrice(order, pobierzInformacjeKlienta()),
//                    sposobOplaty);
            Double orderPrice = KoszykSpec.applyCommission(1.0, sposobOplaty) * KoszykSpec.obliczCene(order, pobierzInformacjeKlienta());
            if (KoszykSpec.hasMoney(orderPrice, pobierzKwote())) {
                transakcji.dodaj(order);
                koszyk.usun(order);
                zmienKwote(pobierzKwote() - orderPrice);
            } else {
                List<Zamowienie> splitOrders = KoszykSpec.splitOrder(order, pobierzInformacjeKlienta(), sposobOplaty);
                if (splitOrders != null) {
                    transakcji.dodaj(splitOrders.getFirst());
                    koszyk.usun(order);
                    koszyk.dodaj(splitOrders.getLast());
//                    orderPrice = KoszykSpec.applyCommission(
//                            KoszykSpec.calculatePrice(splitOrders.getFirst(), pobierzInformacjeKlienta()), sposobOplaty);
                    orderPrice = KoszykSpec.applyCommission(1.0, sposobOplaty) * KoszykSpec.obliczCene(splitOrders.getFirst(), pobierzInformacjeKlienta());
                    zmienKwote(pobierzKwote() - orderPrice);
                }
                break;
            }
        }
    }

    public String pobierzPortfel() {
        return String.format("%.2f", pobierzKwote());
    }

    public void zwroc(TypSamochodu typSamochodu, String nazwaSamochodu, int odleglosc) {
//        Optional<Map.Entry<String, Zamowienie>> optional = transakcji.pobierzListe().entrySet().stream()
//                .filter(entry -> ListaTransakcjiSpec.refundEligible(entry.getValue(), typSamochodu, nazwaSamochodu, odleglosc)).findFirst();
//
//        if (optional.isEmpty())
//            return;
//
//        Map.Entry<String, Zamowienie> entry = optional.get();
//        Zamowienie order = transakcji.pobierzListe().get(entry.getKey());
        // alternative:
        Zamowienie order = transakcji.pobierzListe().get(nazwaSamochodu);
        if (order == null)
            return;
        if (!order.pobierzTypSamochodu().equals(typSamochodu))
            return;

        Double orderPrice = KoszykSpec.obliczCene(order, pobierzInformacjeKlienta());

        List<Zamowienie> splitTransactions = ListaTransakcjiSpec.splitTransaction(order, odleglosc);

        Zamowienie refundedOrder = splitTransactions.getFirst();
        Zamowienie remainingOrder = splitTransactions.getLast();

        koszyk.merge(refundedOrder);
        transakcji.usun(order);
        if (remainingOrder != null) {
            transakcji.dodaj(remainingOrder);
            orderPrice -= KoszykSpec.obliczCene(remainingOrder, pobierzInformacjeKlienta());
        }
        zmienKwote(pobierzKwote() + orderPrice);
    }
}
