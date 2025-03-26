import java.util.Scanner;	//importing Scanner
import java.io.File;	//importing File
import java.io.FileNotFoundException;	//importing FileNotFoundException
import java.util.ArrayList;	//importing ArrayList
/*
 * Patrick Conley
 * CPS 350 Assignment 3
 * 
 * ProductList class
 */

public class ProductList 
{
	Node head;	//head of the list
	
	//constructor that creates the ProductList
	public ProductList(String fileName)
	{
		//ArrayList that will hold info from the text file
		ArrayList<String> infoHolder = new ArrayList<String>();
		try
		{
			Scanner fileRead = new Scanner(new File(fileName));	//Scanner object that will read file info
			while (fileRead.hasNextLine())
			{
					//adding file info to ArrayList
					infoHolder.add(fileRead.nextLine());
			}	//end while loop
			
			for (int i = 0; i < infoHolder.size(); i = i + 5)
			{
				//every fifth index is just blank space, so it is ignored
				Product prod = new Product(Long.parseLong(infoHolder.get(i)), infoHolder.get(i+1),
						Double.parseDouble(infoHolder.get(i+2)), Double.parseDouble(infoHolder.get(i+3)));
				
				add(prod);	//adding Product object to the ProductList
			}	//end for loop
		}	//end try block
		
		catch (FileNotFoundException ex)
		{
			System.out.println("Error, file not found");
			System.exit(0);	//ending program
		}	//end catch block
	}	//end ProductList constructor
	
	public void add(Product p) 
	{
        Node newNode = new Node(p);
        if (head == null) 
        {
            head = newNode; 
        }	//end if statement 
        else 
        {
            Node current = head;
            while (current.next != null) 	//iterating through list
            {
                current = current.next;
            }	//end while loop
            current.next = newNode; 
        }	//end else statement
    }	//end add method
	
	//performs a deep copy of a ProductList
	public ProductList(ProductList productList) 
	{
	    if (productList.head == null) 
	    {
	        head = null; //if the original list is empty, set head to null
	    }	//end if statement
	    else 
	    {
	        //copy first Product
	        head = new Node(new Product(productList.head.data));

	        Node currentOriginal = productList.head.next; 
	        Node currentNew = head;

	        while (currentOriginal != null) 
	        {
	            //creating new node
	            Node newNode = new Node(new Product(currentOriginal.data));
	           
	            currentNew.next = newNode;
	            
	            //moving to next nodes
	            currentNew = newNode;
	            currentOriginal = currentOriginal.next;
	        }	//end while loop
	    }	//end else statement
	} //end ProductList constructor
	
	//this will display contents of the list
	public void display()
	{
		Node current = head;
	    while (current != null) 
	    {
	    	System.out.println(current.data.toString());	//printing out each Product's information
	    	current = current.next;	//iterating through LinkedList
	    }	//end while loop
	}	//end display method
	
	//this will display contents of the list with the discount
		public void displayWithDiscount()
		{
			Node current = head;
		    while (current != null) 
		    {
		    	System.out.println(current.data.toStringWithDiscount());	//printing out each Product's information
		    	current = current.next;	//iterating through LinkedList
		    }	//end while loop
		}	//end display method
	
	//uses selection sort to sort the ProductList by ascending order of discounts
	public void sortByDiscount() 
	{
	    if (head == null || head.next == null) 
	    {
	        return; 	//base case for list being empty or only having one Node
	    }	//end if statement

	    Node current = head;

	    while (current != null) 
	    {
	        Node minNode = current; 
	        Node runner = current.next;

	        while (runner != null) 
	        {
	            if (runner.data.getDiscount() < minNode.data.getDiscount()) 
	            {
	                minNode = runner; //updating if smaller discount is found
	            }	//end if statement
	            runner = runner.next;
	        }	//end inner while loop

	        if (minNode != current) 
	        {
	            Product temp = current.data;
	            current.data = minNode.data;
	            minNode.data = temp;
	        }	//end if statement

	        current = current.next; // Move to the next node
	    }	//end out while loop
	}	//end sortByDiscount method
	
	
}	//end ProductList class

/*
 * Node class
 */
class Node 
{
    Product data;	//holds the value inside each node
    Node next;	//holds the reference to the next node

    Node(Product p) 	
    {
        this.data = p;
        this.next = null;
    }	//end Node constructor
}	//end Node class
