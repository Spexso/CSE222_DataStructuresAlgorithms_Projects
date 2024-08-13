public class StockDataManager {

    private AVLTree Avl_tree;

    public StockDataManager(){

        Avl_tree = new AVLTree();
    }

    public void InOrderTraversal(){
        Avl_tree.InOrderTraverse();
    }

    public void PostOrderTraversal(){
        Avl_tree.PostOrderTraverse();
    }

    public void PreOrderTraversal(){
        Avl_tree.PreOrderTraverse();
    }

    
    public void AddorUpdateStock(String Symbol, double Price, long Volume, long MarketCap){

        Stock Searchedstock = Avl_tree.Search(Symbol);
        Stock NewStock = new Stock(Symbol, Price, Volume, MarketCap);

        if(Searchedstock != null){
            
            Stock PresentStock = new Stock(Symbol, Searchedstock.GetPrice(), Searchedstock.GetVolume(), Searchedstock.GetMarketCap());
            update(Symbol, Price, Volume, MarketCap);
            System.out.print(PresentStock.toString() + " updated to " + NewStock.toString());
            StockDataManager.PrintSpace();
        }
        else{
            
            Avl_tree.insert(NewStock);
            System.out.print(NewStock.toString());
            PrintSpace();
        }
    }

    public void update(String symbol, double NewPrice, long NewVolume, long NewMarketCap){

        Stock PresentStock = Avl_tree.Search(symbol);

        // Since stock is already found in Stocks
        // No need to check for nullness
        PresentStock.SetPrice(NewPrice);
        PresentStock.SetVolume(NewVolume);
        PresentStock.SetMarketCap(NewMarketCap);
    }

    public void RemoveStock(String StockToRemove){
        Avl_tree.delete(StockToRemove);
    }

    /**
     * Searches AVL tree for stocks
     * @param StockToSearch Stock Symbol to search
     * @return Returns the found Stock
     */
    public Stock SearchStock(String StockToSearch){
        
        Stock SearchedStock = Avl_tree.Search(StockToSearch);
        return SearchedStock;
    }

    public void UpdateStock(String Symbol, String NewSymbol, double NewPrice, long NewVolume, long NewMarketCap){

        Stock FoundStock = Avl_tree.Search(Symbol);
        // Copy stock for printing later

        if(FoundStock != null){

            Stock OldStock = new Stock(FoundStock.GetSymbol(), FoundStock.GetPrice(), FoundStock.GetVolume(), FoundStock.GetMarketCap());
            
            FoundStock.SetSymbol(NewSymbol);
            FoundStock.SetPrice(NewPrice);
            FoundStock.SetVolume(NewVolume);
            FoundStock.SetMarketCap(NewMarketCap);
            System.out.print("UPDATE: " + OldStock.toString() + " updated to " + FoundStock.toString());
            PrintSpace();
        }
    }

    public static void PrintSpace(){
        System.out.println("");
    }

    // Main Debug
    public static void main(String[] args){
        /* 
        StockDataManager Depot = new StockDataManager();

        Depot.AddorUpdateStock("APL", 150.0, 1000000, 2500000000L);
        Depot.AddorUpdateStock("GGL", 2800.0, 50000, 1500000000L);
        
        System.out.println(Depot.SearchStock("GGL"));
        Depot.AddorUpdateStock("GGL", 40302.0, 30000, 6500000000L);
        Depot.RemoveStock("APL");
        
        System.out.println(Depot.SearchStock("GGL"));
        System.out.println(Depot.SearchStock("APL"));
        System.out.println(Depot.SearchStock("APPL"));
        
        */
    }   
}
