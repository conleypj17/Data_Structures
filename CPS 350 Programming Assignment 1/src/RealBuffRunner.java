/*
 * RealBuffRunner class
 */
import java.util.Random;	//importing java Random class

public class RealBuffRunner 
{
	public static void main(String[] args)
	{
		//empty buff of default maximum size
		RealBuff buff1 = new RealBuff();	//this will hold values that will be quickSorted
		RealBuff buff2 = new RealBuff();	//this will hold values that will be mergeSorted
		
		Random r = new Random();	//creating new random object
		//generating 10 random doubles and appending them to buffer object
		double[] numbers = new double[10];	//this array will hold the doubles to be appended
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = r.nextDouble() * 100;	//getting a random double between 0 and 100
			buff1.append(numbers[i]);	//appending these random doubles to the buffer
			numbers[i] = r.nextDouble() * 100; //getting a random double between 0 and 100
			buff2.append(numbers[i]); //appending these random doubles to the buffer
		}	//end for loop
		
		//displaying contents of the buffer
		System.out.println("buff1 before quickSort: ");
		buff1.display();
		
		//calling quickSort for buff1
		buff1.quickSort(buff1, 0, buff1.current_size-1);
		
		//displaying contents of the buffer to see if it is sorted
		System.out.println("buff1 after quickSort: ");
		buff1.display();
		
		//displaying contents of the buffer
		System.out.println("\nbuff2 before mergeSort: ");
		buff2.display();
		
		//calling mergeSort for buff2
		buff2.mergeSort(buff2, 0, buff2.current_size-1);
		
		//displaying contents of the buffer to see if it is sorted
		System.out.println("buff2 after mergeSort: ");
		buff2.display();
		
		
		//creating 10 random RealBuff objects
		RealBuff[] buff_holder1 = new RealBuff[10];
		final int N1 = 150000; //holds 150000 elements
		for (int i = 0; i < 10; i++)
		{
			buff_holder1[i] = new RealBuff(N1);	//creating new RealBuffs in the array
		}	//end for loop
	
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < N1; j++)
			{
				//appending 150000 elements between -100 and 100
				buff_holder1[i].append(-100 + (100 + 100) * r.nextDouble());
			}	//end inner for loop
		}	//end outer for loop
		
		long time1;
		long time2;
		long[] quickSortTimes = new long[10];
		for (int i = 0; i < 10; i++)
		{
			time1 = System.currentTimeMillis();
			//quicksorting each buffer in the array
			buff_holder1[i].quickSort(buff_holder1[i], 0, buff_holder1[i].current_size-1);
			time2 = System.currentTimeMillis();	//getting time2
			quickSortTimes[i] = time2 - time1;
		}	//end for loop
		
		long average = 0;
		for (int i = 0; i < quickSortTimes.length; i++)
		{
			average += quickSortTimes[i];
		}	//end for loop
		average = average / 10;	//finding average time
		
		//printing out quickSort time
		System.out.println("\nQuickSort average time: " + average + " milliseconds.");
		
		//creating 10 random RealBuff objects
		RealBuff[] buff_holder2 = new RealBuff[10];
		final int N2 = 150000;	//holds 150000 elements
		for (int i = 0; i < 10; i++)
		{
			buff_holder2[i] = new RealBuff(N2);//creating new RealBuffs in the array
		}	//end for loop
		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < N2; j++)
			{
					//appending 150000 elements between -100 and 100
					buff_holder2[i].append(-100 + (100 + 100) * r.nextDouble());
			}	//end inner for loop
		}	//end for loop
		
		
		
		long[] mergeSortTimes = new long[10];
		for (int i = 0; i < 10; i++)
		{
			time1 = System.currentTimeMillis();	//getting time1
			//mergesorting each buffer in the array
			buff_holder2[i].mergeSort(buff_holder2[i], 0, buff_holder2[i].current_size-1);
			time2 = System.currentTimeMillis();	//getting time2
			mergeSortTimes[i] = time2 - time1;
		}	//end for loop
		
		average = 0;
		for (int i = 0; i < mergeSortTimes.length; i++)
		{
			average += mergeSortTimes[i];
		}	//end for loop
		average = average / 10;	//finding average time
		
		//printing out mergeSort time
		System.out.println("MergeSort average time: " + average + " milliseconds.");
		
		/*
		 * mergeSort seems to take twice as long as quickSort
		 */
		
	}	//end main method
}	//end RealBuffRunner class
