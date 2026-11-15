package realizacja;

public class CenaSamochodu extends Samochod {

    private Double cenaAbonament;
    private Double cenaNizejN;
    private Double cenaWyzejN;
    private Integer odlegloscN;

    public CenaSamochodu(String nazwaSamochodu, TypSamochodu typSamochodu, Double cenaAbonament, Double cenaNizejN, Double cenaWyzejN,
                         Integer odlegloscN) {
        super(nazwaSamochodu, typSamochodu);
        this.cenaAbonament = cenaAbonament;
        this.cenaNizejN = cenaNizejN;
        this.cenaWyzejN = cenaWyzejN;
        this.odlegloscN = odlegloscN;
    }

    public Double pobierzCeneAbonament() {
        return cenaAbonament;
    }

    public Double pobierzCeneNizejN() {
        return cenaNizejN;
    }

    public Double pobierzCeneWyzejN() {
        return cenaWyzejN;
    }

    public Integer pobierzOdlegloscN() {
        return odlegloscN;
    }
}

