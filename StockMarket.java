import java.util.HashMap;
import java.util.Map;

public class StockMarket {
    private final Map<String, Stock> stocks = new HashMap<>();

    public StockMarket() {
        addStock(new Stock("AAPL", 150.0));
        addStock(new Stock("GOOGL", 2800.0));
        addStock(new Stock("AMZN", 3400.0));
        addStock(new Stock("TSLA", 720.0));
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }

    public void updatePrice(String symbol, double newPrice) {
        Stock stock = stocks.get(symbol);
        if (stock != null) {
            stock.updatePrice(newPrice);
            System.out.println("✅ Price updated for " + symbol + ": $" + newPrice);
        } else {
            System.out.println("❌ Stock not found!");
        }
    }

    public void displayMarket() {
        System.out.println("\n📈 Current Stock Market Data:");
        stocks.values().forEach(System.out::println);
    }
}
