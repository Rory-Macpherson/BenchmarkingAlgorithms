package ie.roryRoams.CTAProject;


public class Runner {
	//making some new fields. static cause i want them to be called all the time and the same for all
	//private because noone else needs them. 
	private static int[] sizes = {100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000};
	private static String[] names = {"Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Counting Sort"};
	//making a double array to store all the results
	private static double[][] results = new double[names.length][sizes.length];

    //first I will make random arrays of any size
	// pretty simple array, with a loop to fill it
	//with random number between 0 and 99
	private static int[] arrayMaker(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		return arr;
	}
	
	//now i need a copy of the array otherwise 
	//ill be passing in sorted arrays and that will no work
	private static int[] copyArr(int[] arr) {
		int[] copy = new int [arr.length];
		System.arraycopy(arr, 0, copy, 0, arr.length);
		return copy;
	}
	
	public static void main(String[] args) {
		
		//here i am making 10 of each of the sizes in the array sizes
		//then i use the arraymaker method to fill these arrays
		for (int i = 0; i < sizes.length; i++) {
			for (int j = 0; j < 10; j++) {
				int[] copiedArr = arrayMaker(sizes[i]); 
				long start;
				long end;
				
				//while still in this for loop i am going to run every 
				//algorithm and get the results
				//01
				start = System.nanoTime();
                BubbleSort.bubbleSort(copyArr(copiedArr));
                end = System.nanoTime();
                results[0][i] += ((end - start) / 1000000.0);
                //02
                start = System.nanoTime();
                SelectionSort.selectionSort(copyArr(copiedArr));
                end = System.nanoTime();
                results[1][i] += ((end - start) / 1000000.0);
                //03
                start = System.nanoTime();
                InsertionSort.insertionSort(copyArr(copiedArr));
                end = System.nanoTime();
                results[2][i] += ((end - start) / 1000000.0);
                //04
                start = System.nanoTime();
                MergeSort.mergeSort(copyArr(copiedArr));
                end = System.nanoTime();
                results[3][i] += ((end - start) / 1000000.0);
                //05
                start = System.nanoTime();
                CountingSort.countingSort(copyArr(copiedArr));
                end = System.nanoTime();
                results[4][i] += ((end - start) / 1000000.0);

                
                
					
				}
			//this gets me the average of the 10 results
			//so it loops from 0 to 5 = k
			//then for each k, it divided the answers by 10
            for (int k = 0; k < 5; k++) {
				results[k][i] = results[k][i]/10;
			}
		}
		/*I used %-14 to make the space 14 wide, s means it will be a string
		 * god knows why it needs to know that but it can't deal without it
		 * the - means its left aligned. if i had left it without the -
		 * it would be right aligned
		 * then i use a fancy loop for every size in sizes and it prints them 
		 * all out with a 7 character long space and  they are right aligned as
		 * there is no zero*/
		System.out.printf("%-14s", "Size");
		for (int size : sizes) {
		    System.out.printf("%7d", size);
		}
		System.out.println();

		// print each algorithm row, print the names and then print the results
		for (int k = 0; k < names.length; k++) {
		    System.out.printf("%-14s", names[k]);
		    for (int i = 0; i < sizes.length; i++) {
		        System.out.printf("%7.3f", results[k][i]);
		    }
		    System.out.println();
		}
		
		
	}
	
}
