/*
 * Patrick Conley
 * CPS 350 Assignment 3
 * 
 * Product class
 */

class Product
{
	long ID;	//holds ID
	String name;	//holds name
	double originalPrice;	//holds original price
	double currentPrice;	//holds current price
	
	//constructor
	public Product(long ID, String name, double originalPrice, double currentPrice)
	{
		this.ID = ID;
		this.name = name;
		this.originalPrice = originalPrice;
		this.currentPrice = currentPrice;
	}	//end Product constructor
	
	//constructor
	public Product(Product other) 
	{
        this.ID = other.ID;
        this.name = other.name;
        this.originalPrice = other.originalPrice;
        this.currentPrice = other.currentPrice;
    }	//end Product constructor
	
	//calculates and returns the discount
	public double getDiscount()
	{
		return (originalPrice - currentPrice) / originalPrice;
	}	//end getDiscount method
	
	//toString method
	public String toString()
	{
		return "ID:" + ID + "\tName: " + name + "\tOriginal Price: $" + originalPrice + "\tCurrentPrice: $" + currentPrice + "\n"; 
	}	//end to String method
	
	//toString method that includes discount
	public String toStringWithDiscount()
	{
		return "ID:" + ID + "\tName: " + name + "\tOriginal Price: $" + originalPrice + "\tCurrentPrice: $" + currentPrice
				+ "\tDiscount " + this.getDiscount() + "\n";
	}	//end toStringWithDiscount method
			
}	//end Product class