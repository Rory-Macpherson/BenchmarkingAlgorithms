package ie.roryRoams.CTAProject;

public class CountingSort {

	public static int[] countingSort(int[] arr) {
		// find the biggest value in the array.
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}

		/*
		 * this makes an array the max's length + 1 to account for 0 then, it loops
		 * through the whole array. it then adds +1 to the value of that number. so if
		 * the number is 3. at position 3 of the array it adds +1 so if there were 3
		 * threes, then the array for 3 would be 3... should not have used 3
		 */
		int[] count = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			count[num] = count[num] + 1;// this is where the counting happens
		}

		/*
		 * make an array the same size as the last array then it loops through the main
		 * arrray and fills it up using the count array. so if there were no 2's but
		 * three threes, then the i would skip over 2 without doing anything and then
		 * add three threes to the array. k is used to keep track of what position is to
		 * be filled in the array then count[i] goes down until it is zero, or not
		 * bigger than zero i should say and when the while loop is done
		 */
		int[] result = new int[arr.length];
		int k = 0;
		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				result[k] = i;
				k++;
				count[i]--;
			}
		}
		return result;
	}

}
