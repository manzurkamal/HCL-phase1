package virtualkey;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WelcomeScreen implements Screen {

    public static String welcomeText = "Welcome to VirtualKey!";
    public static String developerText = "Developer: MD Kamal";

    private ArrayList<String> options = new ArrayList<>();

    public WelcomeScreen() {    
    	options.add("\nMain Menu: ");
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");
        options.add("\nPlease choose between 1-3: ");

    }
    @Override
    public void Show()
    {
        for (String s : options)  {
            System.out.println(s);
        }
    }

    @Override
    public void GetUserInput()
    {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 5) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option)
    {
        switch(option) {

            case 1: // Show Files Sorted in Ascending Order
            	System.out.println("The Existing Files: ");
                this.ShowFiles();                
                break;                
            case 2: // Show File Options
                ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
                ScreenService.getCurrentScreen().Show();
                ScreenService.getCurrentScreen().GetUserInput();
                break;
            case 3: //Quit
            	quitApp();
                break;            	
            default:
                System.out.println("Invalid Option");
                break;
        }
    }    
    private static void quitApp() {
        System.out.println("Closing your application... \nThank you!");
        System.exit(0);
    }

    public void ShowFiles() {
        DirectoryService.PrintFiles();
        ScreenService.getCurrentScreen().Show();
        ScreenService.getCurrentScreen().GetUserInput();        
    }
    public void AddFile() {
        System.out.println("Please Enter the Filename:");
        String fileName = this.getInputString();
        System.out.println("You are adding a file named: " + fileName);
    }

    private String getInputString()
    {

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }
    private int getOption()
    {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;
    }
}