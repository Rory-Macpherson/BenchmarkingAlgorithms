package ie.roryRoams.CTAProject;

public class SelectionSort {

	public static int[] selectionSort(int[] arr) {
		int n = arr.length;
		/*
		 * the i for loop runs through the whole array at the start of every loop the
		 * minindex is equal to i. so as i moves up so will min index
		 */
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			/*
			 * this j for loop runs on each i loop iteration it starts at one above i, so on
			 * the i loops first iteration it would start on value 1. it also reaches the
			 * last value in the array where as the i loop does not. if any value [j] is
			 * less than the value at i, then mindindex = j
			 */
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			/*
			 * the confusing part, after the j for loop, you basically switch the lowest
			 * value in the array with the value at i then when i increases you know that
			 * anything behind i has been sorted.
			 */
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
}
