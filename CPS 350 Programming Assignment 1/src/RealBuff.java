/*
 * Patrick Conley
 * 
 * CPS 350 Assignment 1
 * 
 * Buffers for double numbers
 */

class RealBuff
{
	static final int max_size = 100; // the default maximum size of the buffer
	double[] content; // the content of the buffer
	int current_size; // the number of valid elements
	
	RealBuff() // initializing an empty buffer of the default maximum size
	{
		content = new double[max_size];	
	}
	
	// initializing an empty buffer of the maximum size given by n
	RealBuff(final int n)
	{
		content = new double[n];
	}
	
	// initializing a buff which is a copy of buff
	RealBuff(final RealBuff buff)
	{
		this.content = new double[max_size];
		this.current_size = buff.current_size;
		for (int i = 0; i < current_size; i++)
		{
			this.content[i] = buff.content[i];
		}
	}
		
	//appending a given value n to the buffer
	public void append(final double n)
	{
		content[current_size++] = n;
	}	//end append method
	
	//adds value n to index position
	public boolean insert(final double n, final int position)
	{
		if (current_size == max_size)
		{
			return false;
		}	//end if statement
		if (position < 0 || position > max_size)
		{
			return false;
		}	//end if statement
		

		for (int i = current_size + 1; i > position; i--)
		{
			content[i] = content[i-1];
		}	//end for loop
		
		content[position] = n;
		current_size++;
		return true;
	}	//end append method
	
	//deletes the element in index passed to method
	public boolean delete(final int position)
	{
		if (current_size == 0)
		{
			return false;
		}	//end if statement
		if (position > current_size)
		{
			return false;
		}	//end if statement
		
		for (int i = 0; i < current_size; i++)
		{
			if (i >= position)
			{
				content[i] = content[i + 1];
			}	//end if statement
		}	//end for loop
		current_size--;
		return true;
	}	//end delete method
	
	//display the values in the buffer
	public void display()
	{
		for (int i = 0; i < current_size; i++)
		{
			System.out.print(content[i] + " ");
		}	//end for loop
		System.out.println("");
	}	//end display method
	
	//using insertionSort to sort the contents of the RealBuff passed in
	public void insertionSort(RealBuff buff)
	{
		double key;	//holds content values
		int i;	//holds index values
		for (int j = 1; j < current_size; j++)
		{
			key = content[j];
			//insert content[j] into the sorted sequence
			
			i = j - 1;
			while (i >= 0 && content[i] > key)
			{
				content[i + 1] = content[i];
				i--;
			}	//end while loop
			content[i+1] = key;
		}	//end for loop
	}	//end insertionSort method
	
	//using quickSort to sort the contents of the RealBuff passed in
	public void quickSort(RealBuff buff, int low, int high)
	{
        if (low < high) 
        {
            //calling partition method
            int pivotIndex = partition(buff.content, low, high);
            //recusively calling quickSort method
            quickSort(buff, low, pivotIndex - 1);
            quickSort(buff, pivotIndex + 1, high);
        }	//end if statement
    }	//end quickSort method

    //partition method for quickSort
    private int partition(double[] array, int low, int high) 
    {
        //making the last element the pivot
        double pivot = array[high];
        int i = low - 1; //smallest element
        
        for (int j = low; j < high; j++) 
        {
            //if less than or equal to pivot
            if (array[j] <= pivot) 
            {
                i++;
                swap(array, i, j); //swap elements i and j
            }	//end if statement
        }	//end for loop
        //swap pivot with i+1
        swap(array, i + 1, high);
        return i + 1; //return pivot index
    }	//end partition method

	//swap method for quickSort
	public void swap(double[] arr, int i1, int i2) 
	{
	    double temp = arr[i1];	//storing temp
	    arr[i1] = arr[i2];	//moving i2 to i1
	    arr[i2] = temp;	//moving temp to i2
	} // end swap method
	
	//merge method for mergeSort
	public void merge(RealBuff buff, int left, int mid, int right) 
	{
	    //getting sizes of the two smaller arrays
	    int size1 = mid - left + 1;
	    int size2 = right - mid;

	    //creating two new arrays
	    double[] leftArray = new double[size1];
	    double[] rightArray = new double[size2];

	    //putting values in leftArray and rightArray
	    for (int i = 0; i < size1; i++) 
	    {
	        leftArray[i] = buff.content[left + i];
	    }	//end for loop
	    for (int j = 0; j < size2; j++) 
	    {
	        rightArray[j] = buff.content[mid + 1 + j];
	    }	//end for loop

	    int cur1 = 0;	//index of left array 
	    int cur2 = 0;	//index of right array
	    int cur3 = left;	//index of content
	    while (cur1 < size1 && cur2 < size2) 
	    {
	        if (leftArray[cur1] <= rightArray[cur2]) 
	        {
	            buff.content[cur3++] = leftArray[cur1++];
	        } //end if statement
	        else 
	        {
	            buff.content[cur3++] = rightArray[cur2++];
	        }	//end else statement
	    }	//end while loop

	    //getting leftover elements of leftArray
	    while (cur1 < size1) 
	    {
	        buff.content[cur3++] = leftArray[cur1++];
	    }	//end while loop

	    //getting the leftover elements of rightArray
	    while (cur2 < size2) 
	    {
	        buff.content[cur3++] = rightArray[cur2++];
	    }	//end while loop
	}	//end merge method

	//using mergeSort to sort the contents of the RealBuff passed in
	public void mergeSort(RealBuff buff, int left, int right) 
	{
	    if (left < right) //base case statement
	    {
	        //finding mid
	        int mid = left + (right - left) / 2;

	        //mergeSorting the two halves of the array
	        mergeSort(buff, left, mid);
	        mergeSort(buff, mid + 1, right);

	        //merging the two sorted halves
	        merge(buff, left, mid, right);
	    }	//end if statement
	}	//end mergeSort method
	
}	//end RealBuff class