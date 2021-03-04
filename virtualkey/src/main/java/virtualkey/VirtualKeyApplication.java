package virtualkey;

public class VirtualKeyApplication {
    
    public static void main(String[] args) {

    	System.out.println(WelcomeScreen.welcomeText);
        System.out.println(WelcomeScreen.developerText);
        
        DirectoryService.AddTestData();
        ScreenService.getCurrentScreen().Show();
        ScreenService.getCurrentScreen().GetUserInput();
        
    }
}
