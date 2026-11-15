public enum Seasons {

    AUTUMN("autumn", -15),
    WINTER("winter", -30),
    SPRING("spring", 15),
    SUMMER("summer", 30);

    private String seasonName;
    private int temperature;

    Seasons(String seasonName, int temperature) {
        this.seasonName = seasonName;
        this.temperature = temperature;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public int getTemperature() {
        return temperature;
    }

    public String toString(){
        return "hello, I'm " + seasonName;
    }
}
