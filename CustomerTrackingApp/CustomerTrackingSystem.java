import java.util.Scanner;

public class CustomerTrackingSystem{


    public static void main(String[] args){

        int status;

        // ID variable taken from user
        int IDinput;

        //System.out.println("Main is here!");

        // File Reader initialization
        ReadFileManager readText = new ReadFileManager();
        
        // IO initialization
        Scanner inputcontroller = new Scanner(System.in);

        // Read the text file
        readText.ReadTheFile("content.txt");

        while(true){
            ReadFileManager fmanager = new ReadFileManager();
            fmanager.ReadTheFile("content.txt");
            fmanager.LinkData();

            PrintEnterID();

            // Read the integer ID from user
            IDinput = inputcontroller.nextInt();

            //System.out.println("Your ID is " + IDinput);

            status = fmanager.FindPerson(IDinput);

            if(status != 0){

                System.out.println("No operator/customer was found with ID " + IDinput + ". Please try again.");
            }
        }
    }


    public static void PrintEnterID(){

        System.out.println("Please enter your ID...");
    }
}