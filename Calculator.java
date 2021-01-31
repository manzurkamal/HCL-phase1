package Projects;

import java.util.Scanner;

public class Calculator {
	
	public static void main(String[] args) {
		
		double num1;
		double num2;
		char operator;
		
		Scanner user_inp = new Scanner(System.in);
		
		System.out.println("Please Enter First Number: ");
		num1 = user_inp.nextDouble();
		System.out.println("Please Choose an Operator: Add, Subtract, Divide, or Multiply");
		operator = user_inp.next().charAt(0);
		System.out.println("Please Enter Second Number: ");
		num2 = user_inp.nextDouble();
		
		if(operator == '+') {
			System.out.println("Answer = " + (num1 + num2));			
		}
		else if(operator == '-') {
			System.out.println("Answer = " + (num1 - num2));			
		}
		else if(operator == '*') {
			System.out.println("Answer = " + (num1 * num2));			
		}
		else if(operator == '/') {
			System.out.println("Answer = " + (num1 / num2));			
		}
		user_inp.close();
	}

}
