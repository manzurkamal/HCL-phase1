package learnjava;

import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
import java.util.Scanner;

public class EmailTest {
	
	public static String isValid(String emailToSearch) {
		
	        String[] emails = {
	            "james@yahoo.com", "sam@gmail.com",
	            "jimmy@google.com", "tim@aol.com",
	            "jhon@apple.com", "bind@facebook.com",
	            "tina@hcl.com", "jabo@microsoft.com"
	        };
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
	            "[a-zA-Z0-9_+&*-]+)*@" +
	            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
	            "A-Z]{2,7}$";

	        Pattern pat = Pattern.compile(emailRegex);

	        //boolean result = false;
	        String resultText = "";
	        for (String email: emails) {
	            if (pat.matcher(emailToSearch).matches()) {
	            	resultText = "It's a valid email ";	            	
	            	
	                if (email.equalsIgnoreCase(emailToSearch)) {
	                	resultText = resultText + "and a match to an employee email ID";  
	                	return resultText;
	                } 
	                else {
	                	resultText = "valid email but it does not match an employee";	                   
	                }
	            } 
	            else {
	            	resultText = "Email is not valid";	             
	            }	            
	        }
	        return resultText;	        
	    }

	    public static void main(String[] args) {

	        Scanner user_input = new Scanner(System.in);
	        System.out.println("Please Enter Email id: ");
	        //To match an employee email ID please enter email from array
	        String emailId = user_input.nextLine();
	        
	        System.out.println(isValid(emailId));
	        
	        user_input.close();
	    }
	}