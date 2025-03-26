
/*
 * CPS 350 Programming Project #2
 * 
 * Patrick Conley
 */
public class HashTableRunner 
{
	public static void main(String[] args)
	{
		System.out.println("Hashtable that uses simple hashing: ");
		//creating empty hash table of size 11
		SimpleHashTable hashTable = new SimpleHashTable(11);
		
		//keys that will be consecutively inserted into the hash table
		int[] keys = {34, 29, 53, 44, 120, 39, 45, 40};
		
		//consecutively inserting keys into the hash table and displaying table after each insertion
		for (int i = 0; i < keys.length; i++)
		{
			System.out.println("Hashtable after attempting to insert: " + keys[i]);
			hashTable.insert(keys[i]);	//inserting key
			hashTable.display();	//display hash table
		}	//end for loop
		
		System.out.println("Hashtable after deleting 120: ");
		//deleting 120 and displaying content
		hashTable.delete(120);
		hashTable.display();
		
		System.out.println("Hashtable after searching for 40: ");
		//searching for 40 and displaying content
		int index = hashTable.search(40);
		if (index != -1)
		{
			System.out.println("40 found at index " + index);
		}	//end if statement
		hashTable.display();
		
		System.out.println("Hashtable after attempting to insert 46: ");
		//inserting the key 46 and displaying content
		hashTable.insert(46);
		hashTable.display();
		
		
		System.out.println("Hashtable that uses linear probing: ");
		//creating empty hash table of size 11 that uses linear probing 
		LinearProbeHashTable hashTableProbe = new LinearProbeHashTable(11);
		
		//consecutively inserting keys into the hash table and displaying table after each insertion
		for (int i = 0; i < keys.length; i++)
		{
			System.out.println("Hashtable after attempting to insert: " + keys[i]);
			hashTableProbe.insert(keys[i]);
			hashTableProbe.display();
		}	//end for loop
		
		System.out.println("Hashtable after deleting 120: ");
		//deleting 120 and displaying content
		hashTableProbe.delete(120);
		hashTableProbe.display();
		
		System.out.println("Hashtable after searching for 40: ");
		//searching for 40 and displaying content
		index = hashTableProbe.search(40);
		if (index != -1)
		{
			System.out.println("40 found at index " + index);
		}	//end if statement
		hashTableProbe.display();
		
		System.out.println("Hashtable after attempting to insert 46: ");
		//inserting the key 46 and displaying content
		hashTableProbe.insert(46);
		hashTableProbe.display();
		

	}	//end main method
}	//end HashTableRunner class
