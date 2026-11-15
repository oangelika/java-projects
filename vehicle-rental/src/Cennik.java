package realizacja;

import java.util.HashMap;
import java.util.Map;

public class Cennik {

    private Map<String, CenaSamochodu> cennikSamochodow;

    private static Cennik instance = null;

    private Cennik() {
        cennikSamochodow = new HashMap<>();
    }

    public static Cennik pobierzCennik() {
        if (instance == null)
            instance = new Cennik();
        return instance;
    }

    public void dodaj(TypSamochodu typSamochodu, String nazwaSamochodu, double ca, double cn, int od, double cw) {
        CenaSamochodu cenaSamochodu = new CenaSamochodu(nazwaSamochodu, typSamochodu, ca, cn, cw, od);
        cennikSamochodow.put(nazwaSamochodu, cenaSamochodu);
    }

    public void dodaj(TypSamochodu typSamochodu, String nazwaSamochodu, double cn, int od, double cw) {
        CenaSamochodu cenaSamochodu = new CenaSamochodu(nazwaSamochodu, typSamochodu, null, cn, cw, od);
        cennikSamochodow.put(nazwaSamochodu, cenaSamochodu);
    }

    public void dodaj(TypSamochodu typSamochodu, String nazwaSamochodu, double cn) {
        CenaSamochodu cenaSamochodu = new CenaSamochodu(nazwaSamochodu, typSamochodu, null, cn, null, null);
        cennikSamochodow.put(nazwaSamochodu, cenaSamochodu);
    }

    public void dodaj(TypSamochodu typSamochodu, int od, String nazwaSamochodu) {
        CenaSamochodu cenaSamochodu = new CenaSamochodu(nazwaSamochodu, typSamochodu, 0.0, null, null, od);
        cennikSamochodow.put(nazwaSamochodu, cenaSamochodu);
    }

    public CenaSamochodu pobierzCeneSamochodu(String nazwaSamochodu) {
        return cennikSamochodow.get(nazwaSamochodu);
    }
}
