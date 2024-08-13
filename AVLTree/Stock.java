/**
 * Stock class representing a stock with symbol, price, volume, and market capitalization.
 */
public class Stock {

    private String symbol;
    private double price;
    private long volume;
    private long MarketCap;

    /**
     * Constructor for the Stock class.
     * @param initialSymbol Initial symbol of the stock.
     * @param initialPrice Initial price of the stock.
     * @param initialVolume Initial volume of the stock.
     * @param initialMarketCap Initial market capitalization of the stock.
     */
    public Stock(String initialSymbol, double initialPrice, long initialVolume, long initialMarketCap) {
        symbol = initialSymbol;
        price = initialPrice;
        volume = initialVolume;
        MarketCap = initialMarketCap;
    }

    /**
     * Main method for debugging.
     * @param args Command line arguments.
     */
    public static void main(String args[]) {
        System.out.println("//Live");
    }

    /**
     * Get the symbol of the stock.
     * @return The symbol of the stock.
     */
    public String GetSymbol() {
        return symbol;
    }

    /**
     * Get the price of the stock.
     * @return The price of the stock.
     */
    public double GetPrice() {
        return price;
    }

    /**
     * Get the volume of the stock.
     * @return The volume of the stock.
     */
    public long GetVolume() {
        return volume;
    }

    /**
     * Get the market capitalization of the stock.
     * @return The market capitalization of the stock.
     */
    public long GetMarketCap() {
        return MarketCap;
    }

    /**
     * Set a new price for the stock.
     * @param newPrice The new price to set.
     */
    public void SetPrice(double newPrice) {
        this.price = newPrice;
    }

    /**
     * Set a new volume for the stock.
     * @param newVolume The new volume to set.
     */
    public void SetVolume(long newVolume) {
        this.volume = newVolume;
    }

    /**
     * Set a new market capitalization for the stock.
     * @param newMarketCap The new market capitalization to set.
     */
    public void SetMarketCap(long newMarketCap) {
        this.MarketCap = newMarketCap;
    }

    /**
     * Set a new symbol for the stock.
     * @param newSymbol The new symbol to set.
     */
    public void SetSymbol(String newSymbol) {
        this.symbol = newSymbol;
    }

    /**
     * Override the toString method to provide a string representation of the stock.
     * @return A string representation of the stock.
     */
    @Override
    public String toString() {
        return "Stock [symbol=" + symbol + ", price=" + price + ", volume=" + volume + ", Market Cap=" + MarketCap + "]";
    }

    /**
     * Compare this stock to another stock based on the symbol.
     * @param ExStock The stock to compare to.
     * @return 0 if the symbols are the same, otherwise a positive or negative integer.
     */
    public int Compare(Stock ExStock) {
        int diff = this.symbol.compareTo(ExStock.GetSymbol());

        if (diff == 0)
            return 0;
        else
            return diff;
    }
}
