import java.time.LocalDate;

public class Bill {
    private int id;
    private double price;
//    private Order order;
    private LocalDate date;

//    public Bill(int id, double price, Order order) {
//        this.id = id;
//        this.price = price;
//        this.order = order;
//        date = LocalDate.now();
//    }

    public String transcript() {
        StringBuilder transcript = new StringBuilder();

        transcript.append("ID of transaction: ");
        transcript.append(id + "\n");
        transcript.append("Price: ");
        transcript.append(price + "\n");
        transcript.append("Order ID: ");
//        transcript.append(order.getId + "\n");

        return transcript.toString();
    }
}
