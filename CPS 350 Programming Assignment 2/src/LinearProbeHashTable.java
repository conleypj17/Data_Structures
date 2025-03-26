
/*
 * LinearProbeHashTable Object Class
 *  - this will be used for linear probing
 *  
 * Patrick Conley
 */
public class LinearProbeHashTable 
{
	private final int TABLE_SIZE;	//holds size of the hash table
	int[] values;
	boolean [] occupied;	//false if not occupied, true if occupied
	boolean [] available;	//keeps track if a slot is marked available
	private int i;
	
	public LinearProbeHashTable(int size)
	{
		TABLE_SIZE = size;
		values = new int[TABLE_SIZE];	//initializing array of values
		occupied = new boolean[TABLE_SIZE];	//automatically initialized to false
		available = new boolean[TABLE_SIZE];	//automatically initialized to false
		i = 0;	//setting i to 0
	}	//end LinearProbeHashTable constructor
	
	public int hash(int x)
	{
		return (x % TABLE_SIZE + i) % TABLE_SIZE;
	}	//end hash method
	
	public int search(int x)
	{
		int index = hash(x);
		if (i > TABLE_SIZE)	//have gone through the whole table
		{
			System.out.println("Failed to find " + x);
			i = 0;
			return -1;
		}	//end if statement
		
		if (occupied[index]);
		{
			if (values[index] == x)
			{
				i = 0;
				System.out.println(x + " successfully found in hash table");
				return index;
			}	//end if statement
		}	//end if statement
		if (available[index])
		{
			i++;
			return search(x);
		}	//end else if statement
		if (!occupied[index] && !available[index])
		{
			System.out.println("Failure to find " + x);
			i = 0;
			return -1;	//failed search
		}	//end if statement
		else
		{
			i++;
			return search(x);
		}
	}	//end search method
	
	public boolean insert(int x)
	{
		int index = hash(x);
		if (i > TABLE_SIZE)	//have gone through the whole table
		{
			i = 0;
			System.out.println("Unsuccessful insertion of " + x);
			return false;	//unsuccessful insertion
		}	//end if statement
		if (!occupied[index])
		{
			values[index] = x;
			occupied[index] = true;
			i = 0;
			System.out.println("Successful insertion of " + x);
			return true;	//successful insertion
		}	//end if statement
		if (available[index])
		{
			values[index] = x;
			occupied[index] = true;
			available[index] = false;
			i = 0;
			System.out.println("Successful insertion of " + x);
			return true;	//successful insertion
		}	//end if statement
		if (occupied[index])
		{
			i++;
			return insert(x);
		}	//end if statement
		return false;	//unsuccessful insertion
	}	//end insert method
	
	public boolean delete(int x)
	{
		int index = search(x);
		if (index == -1)
		{
			System.out.println(x + " is not in the hash table");
			return false;
		}
		else
		{
			available[index] = true;
			occupied[index] = false;
			System.out.println("Successful deletion of " + x);
			return true;	//successful deletion
		}
	}	//end delete method
	
	public void display()
	{
		String output = "";
		for (int j = 0; j < TABLE_SIZE; j++)
		{
			output += "Slot " + j + " status: ";
			if (available[j])
			{
				output += "available, ";
			}
			else
			{
				output += "not available, ";
			}
			if (occupied[j])
			{
				output += "occupied, key = " + values[j];
			}	//end if statement
			else
			{
				 output += "not occupied";
			}	//end else statement
			output += "\n";
		}	//end for loop
		System.out.println(output);
	}	//end display method
	
}	//end LinearProbeHashTable class
