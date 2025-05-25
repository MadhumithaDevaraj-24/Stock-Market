public class Holding {
    private final Stock stock;
    private int quantity;

    public Holding(Stock stock, int quantity) {
        this.stock = stock;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int qty) {
        this.quantity += qty;
    }

    public void removeQuantity(int qty) {
        this.quantity -= qty;
    }

    public double getTotalValue() {
        return stock.getPrice() * quantity;
    }

    public Stock getStock() {
        return stock;
    }
}
