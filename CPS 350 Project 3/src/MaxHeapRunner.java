import java.util.ArrayList;	//importing ArrayList to store Items
/*
	CPS 350 Project 3
	Patrick Conley
	Runner class

*/

public class MaxHeapRunner 
{
	public static void main(String[] args)
	{
		ArrayList<Item> items = new ArrayList<Item>();	//creating ArrayList that stores Items
		//adding Items to the ArrayList
		items.add(new Item(0, 23, 505));
		items.add(new Item(1, 26, 353));
		items.add(new Item(2, 20, 458));
		items.add(new Item(3, 18, 220));
		items.add(new Item(4, 32, 354));
		items.add(new Item(5, 27, 414));
		items.add(new Item(6, 29, 498));
		items.add(new Item(7, 26, 545));
		items.add(new Item(8, 30, 473));
		items.add(new Item(9, 27, 543));
		
		MaxHeap heap = new MaxHeap();	//creating max heap
		
        for (Item item : items) 
        {
            item.setPriorityFactorAsValue(); //setting priority based on value
        }	//end for loop
        for (Item item : items) 
        {
            heap.insert(item); //insert items into the heap
        }	//end for loop
        heap.buildMaxHeap();	//calling buildMaxHeap
        System.out.println("Knapsack based on Value:");
        heap.displayUntilWeightLimit();

        for (Item item : items) 
        {
            item.setPriorityFactorAsAdditiveInverseOfWeight(); //priority based on additive inverse of weight
        }	//end for loop
        heap = new MaxHeap(); //reset heap
        for (Item item : items) 
        {
            heap.insert(item); //reinsert items
        }
        System.out.println("\nKnapsack based on lower Weight:");
        heap.displayUntilWeightLimit();

        for (Item item : items)
        {
            item.setPriorityFactorAsValueToWeightRatio(); //set priority based on value/weight ratio
        }	//end for loop
        heap = new MaxHeap(); //reset the heap
        for (Item item : items) 
        {
            heap.insert(item); //reinsert items
        }	//end for loop
        System.out.println("\nKnapsack based on Value/Weight Ratio:");
        heap.displayUntilWeightLimit();
    }
}
