/*
	CPS 350 Project 3
	Patrick Conley
	Item class

*/

public class Item
{
	int ID;	//holds ID
	double weight;	//holds weight
	double value;	//holds value
	double priorityFactor;	//varies depending on what we want to prioritize
	
	public Item(int ID, double weight, double value)
	{
		this.ID = ID;
		this.weight = weight;
		this.value = value;
	}	//end Item constructor
	
	public void setPriorityFactorAsValue()
	{
		priorityFactor = value;
	}	//end setPriorityFactorAsValue method
	
	public void setPriorityFactorAsAdditiveInverseOfWeight()
	{
		priorityFactor = (-1.0) * weight;
	}	//end setPriorityFactorAsAdditiveInverseOfWeight method
	
	public void setPriorityFactorAsValueToWeightRatio()
	{
		priorityFactor = (1.0) * value / weight;
	}	//end setPriorityFactorAsValueTOWeightRatio method
	
	public double getPriorityFactor()
	{
		return priorityFactor;
	}	//end getPriorityFactor method
	
	public double getWeight()
	{
		return weight;
	}	//end getWeight method
	
	public String toString()
	{
		return "ID: " + ID + "\tWeight: " + weight + "\tValue: " + value + "\tPriority Factor: " +  priorityFactor;
	}	//end toString method
}	//end Item class