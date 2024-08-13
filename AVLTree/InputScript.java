import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * InputScript class for generating random stock market data and writing it to a file.
 */
public class InputScript {

    private static final String filename = "input"; // Name of file
    private static final int EntryCount = 1000; // Number of entries to generate
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM = new Random();

    /**
     * Generate a single entry of stock data.
     * @return A formatted string representing a stock data entry.
     */
    private static String generateEntry() {
        int SymbolLength = RANDOM.nextInt(5);

        if (SymbolLength == 0)
            SymbolLength = 1;

        StringBuilder Symbol = new StringBuilder(SymbolLength);

        char letter = ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));
        char letter2 = ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));
        char letter3 = ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));
        char letter4 = ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));
        char letter5 = ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));

        switch (SymbolLength) {
            case 1:
                Symbol.append(letter);
                break;
            case 2:
                Symbol.append(letter);
                Symbol.append(letter2);
                break;
            case 3:
                Symbol.append(letter);
                Symbol.append(letter2);
                Symbol.append(letter3);
                break;
            case 4:
                Symbol.append(letter);
                Symbol.append(letter2);
                Symbol.append(letter3);
                Symbol.append(letter4);
                break;
            case 5:
                Symbol.append(letter);
                Symbol.append(letter2);
                Symbol.append(letter3);
                Symbol.append(letter4);
                Symbol.append(letter5);
                break;
            default:
                break;
        }

        double price = 100.0 + (10000.0 - 100.0) * RANDOM.nextDouble();
        int volume = 100000 + RANDOM.nextInt(900000);
        long marketCap = 50000000L + (long) (RANDOM.nextDouble() * (2500000000L - 50000000L));

        return String.format("ADD %s %.2f %d %d", Symbol, price, volume, marketCap);
    }

    /**
     * Create entries and write them to a file.
     * @param n Number of entries to generate.
     * @param filename Name of the file to write entries to.
     */
    private static void createEntries(int n, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < n; i++) {
                writer.write(generateEntry());
                writer.newLine();
            }
            System.out.println(n + " entries have been written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Main method to generate and write entries to a file.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        createEntries(EntryCount, filename);
    }
}
