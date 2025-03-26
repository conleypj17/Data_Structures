import java.util.Scanner;	//importing Scanner
/*
 * Patrick Conley
 * CPS 350 Assignment 3
 * 
 * ProductListRunner class
 */


public class ProductListRunner 
{
	public static Scanner keyboard = new Scanner(System.in);	//creating global Scanner object
	
	public static void main(String[] args)
	{
		//getting user input for entering name of text file
		System.out.println("Do you want to enter the name of the text file?");
		String response = keyboard.nextLine().toLowerCase();
		String fileName;
		if (response.charAt(0) == 'y')
		{
			System.out.println("You answered yes");
			System.out.println("Please enter the file you want to retrieve information from: ");
			fileName = keyboard.nextLine();	//getting fileName from the user
		}	//end if statement
		else
		{
			System.out.println("You answered no");
			fileName = "C:\\Users\\conle\\Downloads\\products.txt";
		}	//end else statements
		
		//creating a new ProductList object with fileName to read information from
		ProductList productList = new ProductList(fileName);
		
		//displaying contents of productList
		System.out.println("\nContents of the Product List: ");
		productList.display();
		
		//creating a deep copy of productList
		ProductList productListCopy = new ProductList(productList);
		
		System.out.println("\nContents of the Copied List: ");
		productListCopy.display();
		
		
		//displaying the Product List with discount prices
		System.out.println("\nProduct List before being sorted by discount: ");
		productList.displayWithDiscount();
		
		//re-organizes the products in the list in the ascending order of the discount
		productList.sortByDiscount();
		
		//displaying contents of ProductList
		System.out.println("\nProduct List after being sorted by discount: ");
		productList.displayWithDiscount();
	}	//end main method
}	//end ProductListRunner class
