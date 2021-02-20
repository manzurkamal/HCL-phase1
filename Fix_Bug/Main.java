package practice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer> expenses = new ArrayList<Integer>();

    public static void addSampleExpenses() {
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
    }

    public static void main(String[] args) {

        addSampleExpenses();
        System.out.println("**************************************");
        System.out.println("\tWelcome to TheDesk ");
        System.out.println("**************************************");
        optionsSelection();

    }
    private static void optionsSelection() {
        System.out.println("**************************************");
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditures",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        int[] arr1 = {1,2,3,4,5,6};
        for(int i=0; i<arr1.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("\nEnter your choice between 1 to 6:\t");
        Scanner sc = new Scanner(System.in);
        int options;
        try {
        	options =  sc.nextInt();
        } catch (InputMismatchException e) {
        	System.out.println("\nWrong entry. Please rerun program with an appropriate input value.\n");    
        	return;
        }
        //for(int j=1;j<=arr1.length;j++){
            if(options >=1 && options <= 6){
                switch (options){
                    case 1:
                        System.out.println("\nYour saved expenses are listed below: \n");
                        System.out.println(expenses+"\n");
                        optionsSelection();
                        break;
                    case 2:                        
                        System.out.println("\nEnter the value to add your Expense: ");
                        int value = sc.nextInt();
                        expenses.add(value);
                        System.out.println("\nYour value is updated\n");
                        System.out.println(expenses+"\n");
                        optionsSelection();

                        break;
                    case 3:
                        System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                        int con_choice = sc.nextInt();
                        if(con_choice==options){
                               expenses.clear();
                            System.out.println(expenses+"\n");
                            System.out.println("All your expenses are erased!\n");
                        } else {
                            System.out.println("Oops... try again!");
                        }
                        optionsSelection();
                        break;
                    case 4:
                        sortExpenses(expenses);
                        optionsSelection();
                        break;
                    case 5:
                        searchExpenses(expenses);
                        optionsSelection();
                        break;
                    case 6:
                        closeApp();
                        break;
                    default:
                        System.out.println("You have made an invalid choice!");
                        optionsSelection();
                        break;
                }
            }
            else {
            	System.out.println("\nYou made an invalid selection! Please enter between 1 and 6.\n");
                optionsSelection();         	
            }
        //}
        sc.close();
    }
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
            }
    private static void searchExpenses(ArrayList<Integer> expenses) {
        System.out.println("Enter the expense you want to search for:\t");
        Scanner sc = new Scanner(System.in);
        int  expense =  sc.nextInt();
        for (int m=0; m<expenses.size(); m++) {
        	if(expenses.get(m) == expense) {
        		System.out.println("\nYour search for: " + expenses.get(m) + " has been found!\n");
        		return;
        	}  
        	//sc.close();
        }
        System.out.println("\nExpense not found, please try another number.\n");        
    }
    private static void sortExpenses(ArrayList<Integer> expenses) {
    	    	
    	Integer[] expense = new Integer[Main.expenses.size()]; 
        expense = Main.expenses.toArray(expense);
        
        int n = expense.length; 
  
        QuickSort ob = new QuickSort(); 
        ob.sort(expense, 0, n-1); 
  
        System.out.println("Sorted Expenses:");
        for (Integer x : expense) 
            System.out.print(x + " "); 
        System.out.println();        
    }
}