/**
 * ProcessHandler class for handling stock management commands.
 */
public class ProcessHandler {

    /**
     * Process a command line and perform the corresponding action on the StockDataManager.
     * @param line The command line to process.
     * @param manager The StockDataManager to perform actions on.
     */
    public static void ProcessCommand(String line, StockDataManager manager) {
        String[] tokens = line.split(" ");
        String ProcessKey = tokens[0];

        switch (ProcessKey) {
            case "ADD":
                System.out.print("ADD: ");
                manager.AddorUpdateStock(tokens[1], Double.parseDouble(tokens[2]), Long.parseLong(tokens[3]), Long.parseLong(tokens[4]));
                // DebugPrintLine(tokens);
                break;

            case "REMOVE":
                // DebugPrintLine(tokens);
                manager.RemoveStock(tokens[1]);
                break;

            case "SEARCH":
                // DebugPrintLine(tokens);
                Stock stock = manager.SearchStock(tokens[1]);

                if (stock != null) {
                    System.out.print("SEARCH: Found =>" + stock.toString());
                    StockDataManager.PrintSpace();
                } else {
                    System.out.print("SEARCH: Stock could not be found =>" + tokens[1]);
                    StockDataManager.PrintSpace();
                }
                break;

            case "UPDATE":
                // DebugPrintLine(tokens);
                manager.UpdateStock(tokens[1], tokens[2], Double.parseDouble(tokens[3]), Long.parseLong(tokens[4]), Long.parseLong(tokens[5]));
                break;

            default:
                System.out.println("Command not recognized: " + tokens[1]);
                break;
        }
    }

    /**
     * Print the command tokens for debugging purposes.
     * @param tokens The command tokens to print.
     */
    public static void DebugPrintLine(String[] tokens) {
        System.out.println("DEBUG");
        if (tokens.length == 2)
            System.out.println(tokens[0] + " " + tokens[1]);
        else if (tokens.length == 3)
            System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2]);
        else if (tokens.length == 4)
            System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3]);
        else if (tokens.length == 5)
            System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4]);
        else if (tokens.length == 6)
            System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4] + " " + tokens[5]);
        System.out.println("DEBUG");
    }
}
