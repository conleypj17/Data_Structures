/*
	CPS 350 Project 3
	Patrick Conley
	MaxHeap class

*/

public class MaxHeap 
{
	private Item [] array;	//holds Item elements
	private int N;	//number of items in the array
	private static final int CAPACITY = 10;	//max capacity
	private static final int WEIGHT_LIMIT = 67;	//Knapsack weight limit
	
	public MaxHeap()
	{
		array = new Item[CAPACITY];
		N = 0;
	}	//end MaxHeap constructor
	
	//resize array if it gets too big
	private void resize(int newSize) 
	{
		Item[] old = array;
		array = new Item[newSize];
		for (int i = 0; i < old.length; i++)
		{ 
			array[i] = old[i]; 
		}	//end for loop
	}	//end resize method
	
	public void insert(Item item) 
	{
	   //resize array if it gets too full
	    if (N == array.length) 
	    {
	        resize(array.length * 2);
	    }
	    array[N] = item;
	    N++;

	    percolateUp(N - 1);
	}	//end insert method

	//helper method to perform percolateUp
	private void percolateUp(int index) 
	{
	    while (index > 0 && array[parent(index)].getPriorityFactor() < array[index].getPriorityFactor())
	    {
	        swap(index, parent(index));
	        index = parent(index);
	    }	//end while loop
	}	//end percolateUp method

	//helper to find parent's index
	private int parent(int index)
	{
	    return (index - 1) / 2;
	}	//end parent method
	
	//helper to find left child's index
	public int left(int index)
	{
		return 2 * index + 1;
	}	//end left method
	
	//helper to find right child's index
	public int right(int index)
	{
		return 2 * index + 2;
	}	//end right method
	
	//maxHeapify method
	public void maxHeapify(Item[] array, int index)	//similar to percolate down
	{
		int l = left(index);	//getting left child
		int r = right(index);	//getting right child
		int largest = index;
		if (l < N && array[l].getPriorityFactor() > array[index].getPriorityFactor())
		{	//checking to see if left child is bigger than parent
			largest = l;
		}	//end if statement
		else
		{
			largest = index;
		}	//end else statement
		if (r < N && array[r].getPriorityFactor() > array[largest].getPriorityFactor())
		{	//checking to see if right child is bigger than parent/left child
			largest = r;
		}	//end if statement
		if (largest != index)
		{
			swap(index, largest);
			maxHeapify(array, largest);
		}	//end if statement
		
	}	//end maxHeapify method
	
	//method to build max heap
	public void buildMaxHeap()
	{
		for (int i = N / 2; i >= 0; i--)
		{
			maxHeapify(array, i);
		}	//end for loop
	}	//end buildMaxHeap method
	
	//method that deletes element with highest priority
	public Item deleteMax() 
	{
	    if (N == 0) 
	    {
	        return null; //heap is empty
	    }	//end if statement

	    //the max will be the root
	    Item max = array[0];


	    array[0] = array[N - 1];
	    array[N - 1] = null; //clear last spot
	    N--;

	    //restore max heap property
	    maxHeapify(array, 0);

	    return max;
	}	//end deleteMax method

	public void swap(int a, int b)
	{
		Item temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}	//end swap method
	
	//this will act as the Knapsack and display all eligible Items
	public void displayUntilWeightLimit() 
	{
	    int total_weight = 0;	//holds total weight

	    while (total_weight <= WEIGHT_LIMIT && N > 0) 
	    { 
	        Item deletedItem = deleteMax();	//getting the element with the highest priority
	        if (deletedItem == null || N == 0)
	        {
	            break;
	        }	//end if statement
	        if (total_weight + deletedItem.getWeight() > WEIGHT_LIMIT)
	        {
	        	//do nothing
	        }	//end if statement
	        else
	        {
	        	total_weight += deletedItem.getWeight();
	        	System.out.println(deletedItem.toString());
	        } //end else statement
	    }	//end while loop
	}	//end displayUntilWeightLimit method
	
	//display the Max Heap
	public void display()
	{
		for (int i = 0; i < N; i++)
		{
			System.out.println(array[i].toString());
		}	//end for loop
	}	//end display method
	
}	//end MaxHeap class
