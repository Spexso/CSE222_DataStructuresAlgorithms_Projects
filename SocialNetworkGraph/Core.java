import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Core {
    public static void main(String[] args) {

        SocialNetworkGraph network = new SocialNetworkGraph();
        Scanner scanner = new Scanner(System.in);
        int pick = -1;

        // Adding some people for demonstration
        network.addPerson("John Doe", 25, Arrays.asList("reading", "hiking", "cooking"));
        network.addPerson("Jane Smith", 22, Arrays.asList("swimming", "cooking"));
        network.addPerson("Alice Johnson", 27, Arrays.asList("hiking", "painting"));
        network.addPerson("Bob Brown", 30, Arrays.asList("reading", "swimming"));
        network.addPerson("Emily Davis", 28, Arrays.asList("running", "swimming"));
        network.addPerson("Frank Wilson", 26, Arrays.asList("reading", "hiking"));

        // Adding friendships for demonstration
        network.addFriendship("John Doe", "Jane Smith");
        network.addFriendship("John Doe", "Alice Johnson");
        network.addFriendship("Jane Smith", "Bob Brown");
        network.addFriendship("Emily Davis", "Frank Wilson");

        // Main program loop
        while (true) {
            try {

                Menu();
                pick = scanner.nextInt();

                int check = HandleInput(pick, network, scanner);
                
                if(check == -1){
                    Print("Unexpected input. Try again...");
                }
                else if(check == 0){
                    Print("Terminating...");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer. Try again...");
                scanner.nextLine(); // Clear the invalid input from the buffer
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        

        // Finding shortest path for demonstration
        // network.findShortestPath("John Doe", "Bob Brown");

        // // Counting clusters for demonstration
        // network.countClusters();

        scanner.close();
    }

    private static void Menu(){

        Print("===== Social Network Analysis Menu =====");
        Print("1. Add person");
        Print("2. Remove person");
        Print("3. Add Friendship ");
        Print("4. Remove Friendship");
        Print("5. Find Shortest path");
        Print("6. Suggest friends");
        Print("7. Count Clusters");
        Print("8. Exit");
        Print("Please select an option: ");

    }

    private static void Print(String line){ System.out.println(line); }

    private static void PrintNoNewLine(String line){ System.out.print(line); }

    private static int HandleInput(int opt, SocialNetworkGraph network, Scanner inputGetter){
        
        List<String> hobbies = new ArrayList<>();
        
        int interrupt;
        // Call Network analysis methods here
        switch (opt) {
            
            case 1:
                inputGetter.nextLine(); // Consume line to prevent errors
                Print("Enter Person information to Add: ");
                
                PrintNoNewLine("Name: ");
                String PName = inputGetter.nextLine();

                if(checkString(PName))
                    return 1;

                PrintNoNewLine("Age: ");
                int PAge;

                try {
                    PAge = inputGetter.nextInt();
                    inputGetter.nextLine(); // Consume the newline
                } catch (InputMismatchException e) {
                    Print("Invalid age. Please enter a valid integer.");
                    inputGetter.nextLine(); // Clear the invalid input
                    return 1;
                }

                Print("Hobbies(Enter hobbies or type \"done\" to finalize, Max 5): ");

                while (hobbies.size() < 5) {

                    String PHobbies = inputGetter.nextLine().trim();
                    if (PHobbies.equalsIgnoreCase("done")) {
                        break;
                    }

                    if (!PHobbies.isEmpty())
                        hobbies.add(PHobbies);
                }

                network.addPerson(PName, PAge, hobbies);
                
            interrupt = 1;
                break;
            case 2:
                inputGetter.nextLine(); // Consume line to prevent errors
                Print("Enter Person name to Remove: ");
                
                PrintNoNewLine("Name: ");
                String RName = inputGetter.nextLine();

                if(checkString(RName))
                    return 1;

                network.removePerson(RName);

            interrupt = 1;
                break;
            case 3:
                inputGetter.nextLine(); // Consume line to prevent errors
                Print("Enter Person names to make friendship: ");
                
                PrintNoNewLine("First User Name: ");
                String Name1 = inputGetter.nextLine();

                if(checkString(Name1))
                    return 1;

                PrintNoNewLine("Second User Name: ");
                String Name2 = inputGetter.nextLine();

                if(checkString(Name2))
                    return 1;

                network.addFriendship(Name1, Name2);

            interrupt = 1;
                break;
            case 4:
                inputGetter.nextLine(); // Consume line to prevent errors
                Print("Enter Person names to remove friendship: ");
                
                PrintNoNewLine("First User Name: ");
                String RFName1 = inputGetter.nextLine();

                if(checkString(RFName1))
                    return 1;

                PrintNoNewLine("Second User Name: ");
                String RFName2 = inputGetter.nextLine();

                if(checkString(RFName2))
                    return 1;

                network.removeFriendship(RFName1, RFName2);
            interrupt = 1;
                break;
            case 5:

            inputGetter.nextLine(); // Consume line to prevent errors
                Print("Enter Person names to make friendship: ");
                
                PrintNoNewLine("First User Name: ");
                String FName1 = inputGetter.nextLine();

                if(checkString(FName1))
                    return 1;

                PrintNoNewLine("Second User Name: ");
                String FName2 = inputGetter.nextLine();

                if(checkString(FName2))
                    return 1;

                network.findShortestPath(FName1, FName2);
            interrupt = 1;
                break;
            case 6:
            interrupt = 1;
                break;
            case 7:
                // Count number of cluster & Print their contents
                network.countClusters();
            interrupt = 1;
                break;
            case 8:
            interrupt = 0;
                break; 

            default:
                interrupt = -1;
                break;
        }

        return interrupt;
    }

    private static boolean checkString(String in){

        if(in.isEmpty() || !in.matches("[a-zA-Z ]+")){
            Print("Invalid name. Please enter a valid name consisting of letters and spaces only.");
            return true;
        }

        return false;
    }

}
