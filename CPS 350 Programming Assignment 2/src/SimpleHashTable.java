
/*
 * SimpleHashTable Object Class
 *  - this will be used for simple hashing without dealing with collisions
 *  
 * Patrick Conley
 */
public class SimpleHashTable 
{
	private final int TABLE_SIZE;	//holds size of the hash table
	int[] values;
	boolean [] occupied;	//false if not occupied, true if occupied
	
	public SimpleHashTable(int size)
	{
		TABLE_SIZE = size;
		values = new int[TABLE_SIZE];	//initializing array of values
		occupied = new boolean[TABLE_SIZE];	//automatically initialized to false
		
	}	//end HashTable constructor
	
	public int hash(int x)
	{
		return x % TABLE_SIZE;
	}	//end hash method
	
	public int search(int x)
	{
		int index = hash(x);
		if (!occupied[index])
		{
			System.out.println("No such element");
			return -1;	//failed search
		}	//end if statement
		else
		{
			if (values[index] == x)
			{
				System.out.println(x + " found in table");
				return index;
			}
			else
			{
				System.out.println(x + " not in the hash table");
				return -1;
			}
		}
	}	//end search method
	
	public boolean insert(int x)
	{
		int index = hash(x);
		if (!occupied[index])
		{
			values[index] = x;
			occupied[index] = true;
			System.out.println("Successful insertion of " + x);
			return true;	//successful insertion
		}	//end if statement
		
		System.out.println("Position already occupied");
		return false;	//there is a conflict
	}	//end insert method
	
	public boolean delete(int x)
	{
		int index = hash(x);
		if (!occupied[index])
		{
			System.out.println("No such element: " + x);
			return false;	//failed deletion - no such element
		}	//end if statement
		
		//will keep the int there, but if another int needs to be inserted, it will replace the int that stays there
		occupied[index] = false;
		System.out.println("Successful deletion of " + x);
		return true;	//successful deletion
		
	}	//end delete method
	
	public void display()
	{
		String output = "";
		for (int i = 0; i < TABLE_SIZE; i++)
		{
			output += "Slot " + i + " status: ";
			if (occupied[i])
			{
				output += "occupied, key = " + values[i];
			}	//end if statement
			else
			{
				 output += "not occupied";
			}	//end else statement
			output += "\n";
		}	//end for loop
		System.out.println(output);
	}	//end display method
	
	
	
}	//end SimpleHashTable class