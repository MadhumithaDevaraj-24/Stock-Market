import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockMarket market = new StockMarket();
        Portfolio portfolio = new Portfolio(10000); // initial cash

        while (true) {
            System.out.println("\n==============================");
            System.out.println("📌 Welcome to Stock Simulator");
            System.out.println("==============================");
            System.out.println("1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. Update Stock Price");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Stock Market");
            System.out.println("6. Exit");
            System.out.print("👉 Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = sc.nextLine().toUpperCase();
                    Stock stock = market.getStock(buySymbol);
                    if (stock == null) {
                        System.out.println("❌ Invalid stock symbol!");
                        break;
                    }
                    System.out.print("Enter quantity to buy: ");
                    int qty = sc.nextInt();
                    sc.nextLine(); // consume leftover newline
                    portfolio.buyStock(stock, qty);
                }
                case 2 -> {
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = sc.nextLine().toUpperCase();
                    Stock stock = market.getStock(sellSymbol);
                    if (stock == null) {
                        System.out.println("❌ Invalid stock symbol!");
                        break;
                    }
                    System.out.print("Enter quantity to sell: ");
                    int qty = sc.nextInt();
                    sc.nextLine(); // consume leftover newline
                    portfolio.sellStock(stock, qty);
                }
                case 3 -> {
                    System.out.print("Enter stock symbol to update: ");
                    String symbol = sc.nextLine().toUpperCase();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine(); // consume leftover newline
                    market.updatePrice(symbol, newPrice);
                }
                case 4 -> portfolio.displayPortfolio();
                case 5 -> market.displayMarket();
                case 6 -> {
                    System.out.println("👋 Exiting... Thank you for trading!");
                    sc.close();
                    return;
                }
                default -> System.out.println("❌ Invalid option. Try again.");
            }
        }
    }
}
