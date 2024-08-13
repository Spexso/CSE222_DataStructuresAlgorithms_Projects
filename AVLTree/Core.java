import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Core {
    /**
     * Core class represents the Main of this program
     * @param args String array to get input text file for processing commands
     */
    public static void main(String[] args){

        String inputFile = args[0];
        StockDataManager manager = new StockDataManager();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            
            String line;
            
            while ((line = br.readLine()) != null) {
                //System.out.println(line);    
                ProcessHandler.ProcessCommand(line, manager);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        StockDataManager.PrintSpace();
        StockDataManager.PrintSpace();

        System.out.println("Pre Order Traverse: ");
        manager.PreOrderTraversal();      
        StockDataManager.PrintSpace();
        StockDataManager.PrintSpace();
        StockDataManager.PrintSpace();

        System.out.println("Post Order Traverse: ");
        manager.PostOrderTraversal();
        StockDataManager.PrintSpace();
        StockDataManager.PrintSpace();
        StockDataManager.PrintSpace();

        System.out.println("In Order Traverse: ");
        manager.InOrderTraversal();

        
        // Perform a simple performance analysis
        performPerformanceAnalysis(manager, 10000);

    }
    
    /**
     * Draws the graphs for testing performance 
     * @param manager AVL Tree Node manager class
     * @param size amount of sampling for testing
     */
    private static void performPerformanceAnalysis(StockDataManager manager, int size) {
        long startTime, endTime;
        long innerStart, innerEnd;

        List<Integer> searchOperations = new ArrayList<>();
        List<Long> searchTimes = new ArrayList<>();

        List<Integer> addOperations = new ArrayList<>();
        List<Long> addTimes = new ArrayList<>();

        List<Integer> removeOperations = new ArrayList<>();
        List<Long> removeTimes = new ArrayList<>();

        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random RANDOM = new Random();
        char letter = ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));
        String str;
        // Measure time for ADD operation
        for (int i = 0; i < size; i++) {
            letter = ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));
            str = Character.toString(letter);
            innerStart = System.nanoTime();
            manager.AddorUpdateStock(str, Math.random() * 100, (long) (Math.random() * 10000), (long) (Math.random() * 10000000));
            innerEnd = System.nanoTime();
            addOperations.add(i);
            addTimes.add((innerEnd - innerStart));
        }
        long addTotalTime = addTimes.stream().mapToLong(Long::longValue).sum();
        System.out.println("Average ADD time: " + addTotalTime / size + " ns");

        // Measure time for SEARCH operation
        for (int i = 0; i < size; i++) {
            String symbol = "SYM" + i;
            innerStart = System.nanoTime();
            manager.SearchStock(symbol);
            innerEnd = System.nanoTime();
            searchOperations.add(i);
            searchTimes.add(innerEnd - innerStart);
        }
        long searchTotalTime = searchTimes.stream().mapToLong(Long::longValue).sum();
        System.out.println("Average SEARCH time: " + searchTotalTime / size + " ns");

        // Measure time for REMOVE operation
        boolean t = false;
        for (int i = 0; i < size; i++) {
            letter = ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));
            str = Character.toString(letter);
            innerStart = System.nanoTime();
            manager.RemoveStock(str);
            innerEnd = System.nanoTime();
            if(t != false){
                removeOperations.add(i);
                removeTimes.add((innerEnd - innerStart));
            }
            t = true;
        }
        long removeTotalTime = removeTimes.stream().mapToLong(Long::longValue).sum();
        System.out.println("Average REMOVE time: " + removeTotalTime / size + " ns");
        
         
        // Visualize the search performance
        GUIVisualization Sframe = new GUIVisualization("Search Performance Graph Visualization","line", searchOperations, searchTimes);
        Sframe.setVisible(true);
        
        
        // Visualize the search performance
        GUIVisualization Aframe = new GUIVisualization("Add Performance Graph Visualization","line", addOperations, addTimes);
        Aframe.setVisible(true);
        
        
        // Visualize the search performance
        GUIVisualization Rframe = new GUIVisualization("Remove Performance Graph Visualization","scatter", removeOperations, removeTimes);
        Rframe.setVisible(true);
        
    }

}
