package ie.roryRoams.CTAProject;

import java.util.Arrays;

public class MergeSort {

	public static int[] mergeSort(int[] arr) {
		// this is the base case needed for recursion
		if (arr.length <= 1)
			return arr;

		// this is used to find the mid point, java drops the remainder
		int mid = arr.length / 2;
		// this is like substring, so the first gets the values of array from 0
		// to mid not inclusive of mid, very handy to not use a for loop
		// to fill each array
		// these are the recursion calls, it calls recusivly until it reaches
		// the base case and then, and only then does it even get down to
		// helper method
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		/*
		 * this gets the array from the mid point to the arr.length not inclusive.
		 */
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

		// this is calling a helper method that merges the two
		// arrays together
		return merge(left, right);
	}

//the helper method merge
	public static int[] merge(int[] left, int[] right) {
		// this is just using the numbers to get the length of the array
		int[] result = new int[left.length + right.length];
		// sets a group of ints to 0
		int i = 0, j = 0, k = 0;
		/*
		 * while they both have values left if left array [i] is less than right array
		 * [j] then add left array[i] to the results array. if its bigger then add right
		 * array [j]
		 */
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[j++];
			}
		}

		// this is to catch the last value if the array was odd
		while (i < left.length)
			result[k++] = left[i++];
		while (j < right.length)
			result[k++] = right[j++];

		return result;
	}
}
