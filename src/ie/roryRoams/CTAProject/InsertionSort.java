package ie.roryRoams.CTAProject;

public class InsertionSort {

	public static int[] insertionSort(int[] arr) {
		int n = arr.length;
		/*
		 * for loop just goes through the whole array but misses the value at [0] as the
		 * j field gets that in the while loop. it assigns the value at [1] to a key
		 * that is used later int j is assigned i -1 for first loop is zero
		 */
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * so the while loop runs when j is 0 or bigger, and while the value of j is
			 * bigger than the key, swap the value at j +1 with the value at j then j --
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			// then at the end, j is = to -1, so it inserts key at [0]
			// if j is smaller than key then the while loop stops
			// and key gets put in in the position of j+1
			// as i moves everything behind it is in ascending
			// order so if one of them is smaller than key the rest are also
			arr[j + 1] = key;
		}
		return arr;
	}

}
