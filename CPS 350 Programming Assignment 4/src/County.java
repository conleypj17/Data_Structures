/*
 * CPS 350 Assignment 4
 * 
 * Patrick Conley
 * 
 * County object class
 */

public class County 
{
	String name;	//holds name
	int FIPS;	//holds integer value of FIPS
	String FIPS_String;	//holds FIPS String
	String seat;	//holds seat
	int population;	//holds population
	double area;	//holds area
	
	public County(String name, String FIPS, String seat, int population, double area)
	{
		this.name = name;
		this.FIPS = Integer.parseInt(FIPS);
		FIPS_String = FIPS;
		this.seat = seat;
		this.population = population;
		this.area = area;
	}	//end County constructor
	
	//getting method for FIPS
	public int getFIPS()
	{
		return FIPS;
	}	//end getFIPS method
	
	//setter method for FIPS
	public void setFIPS(int FIPS)
	{
		this.FIPS = FIPS;
	}	//end setFIPS method
}	//end County class


class TreeNode
{
	County county_info; // the reference to the information of the county
	TreeNode left; // reference to the left child
	TreeNode right; // reference to the right child
	
	public TreeNode(County county_info)
	{
		this.county_info = county_info;
	}	//end TreeNode constructor
	
	public TreeNode(County county_info, TreeNode left, TreeNode right)
	{
		this.county_info = county_info;
		this.left = left;
		this.right = right;
	}	//end TreeNode constructor
	
	public void display()
	{
		System.out.println("Name: " + county_info.name + "\tFIPS: " + county_info.FIPS_String
				+ "\tSeat: " + county_info.seat + "\tPopulation: " + county_info.population 
				+ "\tArea: " + county_info.area + "\t");
	}	//end display method
}	//end TreeNode class
