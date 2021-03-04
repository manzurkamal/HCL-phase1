package virtualkey;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileOptionsScreen implements Screen {

    private ArrayList<String> options = new ArrayList<>();

    public FileOptionsScreen() {
    	options.add("\nFile Options Menu: ");
        options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Main Menu");
        options.add("\nPlease choose an option: ");
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
        while ((selectedOption = this.getOption()) != 6) {
            this.NavigateOption(selectedOption);
            System.out.println("Please choose an option: ");
        }
    }

    @Override
    public void NavigateOption(int option)
    {
        switch(option) {

            case 1: // Add A File
                this.AddFile();
                break;
            case 2: // Delete A File
                this.DeleteFile();
                break;
            case 3: // Search A FIle
                this.SearchFiles();
                break;
            case 4: // Return to Main Menu
                this.mainReturn();
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
    }
    public void AddFile() {
        System.out.println("Please Enter the Filename:");
        String fileName = this.getInputString();
        System.out.println("You are adding a file named: " + fileName);
        
        boolean isAdded= DirectoryService.AddUserData(fileName);
    	if(isAdded) {
    		System.out.println("File Saved!");
    	}else {
    		System.out.println("Failed: File already exists!");
    	}                
        ScreenService.getCurrentScreen().Show();
        ScreenService.getCurrentScreen().GetUserInput();
    }    
    public void DeleteFile() {  	
    	System.out.println("Please Enter the Filename:");
    	
    	String fileName = this.getInputString();
        DirectoryService.DeleteUserData(fileName);
  
    	ScreenService.getCurrentScreen().Show();
        ScreenService.getCurrentScreen().GetUserInput();        
    }  
        
    public void SearchFiles() {
        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();
        DirectoryService.SearchUserData(fileName);
        ScreenService.getCurrentScreen().Show();
        ScreenService.getCurrentScreen().GetUserInput();
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
    
    public void mainReturn() {
    	
    	ScreenService.setCurrentScreen(ScreenService.WelcomeScreen);
    	ScreenService.getCurrentScreen().Show();
        ScreenService.getCurrentScreen().GetUserInput();    	
    }
}