import java.time.LocalDate;


public class Order {

    private String costumerName;

    private LocalDate orderedDate;

    public Order(String costumerName, LocalDate orderedDate) {
        this.costumerName = costumerName;
        this.orderedDate = orderedDate;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public LocalDate getOrderedDate() {
        return orderedDate;
    }

}
