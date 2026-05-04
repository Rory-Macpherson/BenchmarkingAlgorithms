package ie.roryRoams.CTAProject;

public class BubbleSort {

	// public, takes an array and returns an array. simples
	public static int[] bubbleSort(int[] arr) {
		int n = arr.length;

		/*
		 * for loop. goes from the value at array 0 all the way to the second last
		 * value, we use the 2nd last value as we use the j+1 to catch the last value,
		 * so if we did i<N we would get an out of bounds . the j loop goes through the
		 * whole array each time the i loop does one iteration. it grabs the biggest
		 * number and puts it at the end. so when the i loop goes forward the j loop
		 * stops looking at the very last one on the array as this is defo the biggest
		 * one. then it keeps getting smaller as the i moves forward. so j always starts
		 * at the start of the array but does stops further away from the end each
		 * iteration.
		 */
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

}
