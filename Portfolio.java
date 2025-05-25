import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private final Map<String, Holding> holdings = new HashMap<>();
    private double cash;

    public Portfolio(double initialCash) {
        this.cash = initialCash;
    }

    public double getCash() {
        return cash;
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (cost > cash) {
            System.out.println("❌ Insufficient funds! You need $" + cost + ", but only have $" + cash);
            return;
        }

        cash -= cost;
        holdings.compute(stock.getSymbol(), (_, holding) -> {
            if (holding == null) return new Holding(stock, quantity);
            holding.addQuantity(quantity);
            return holding;
        });

        System.out.println("✅ Bought " + quantity + " shares of " + stock.getSymbol() + " at ₹" + stock.getPrice());
    }

    public void sellStock(Stock stock, int quantity) {
        Holding holding = holdings.get(stock.getSymbol());
        if (holding == null || holding.getQuantity() < quantity) {
            System.out.println("❌ Not enough shares to sell!");
            return;
        }

        double earnings = stock.getPrice() * quantity;
        holding.removeQuantity(quantity);
        if (holding.getQuantity() == 0) {
            holdings.remove(stock.getSymbol());
        }
        cash += earnings;
        System.out.println("✅ Sold " + quantity + " shares of " + stock.getSymbol() + " for ₹" + earnings);
    }

    public void displayPortfolio() {
        System.out.println("\n📊 Your Portfolio:");
        if (holdings.isEmpty()) {
            System.out.println("   (No stocks owned)");
        } else {
            holdings.values().forEach(h -> {
                System.out.println("   " + h.getStock().getSymbol() + " - " + h.getQuantity() +
                        " shares | Total Value: $" + String.format("%.2f", h.getTotalValue()));
            });
        }
        System.out.println("💰 Available Cash: $" + String.format("%.2f", cash));
    }
}
