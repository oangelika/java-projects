public enum Month {
    JANUARY(31),
    FEBRUARY(28){
        @Override
        public int getDays() {
            return 29;
        }
    },
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    private int days;
    private String name;

    Month (int days){
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void countDays(){
        System.out.println("month:" + this.name() + "has" + this.days);
    }
}

