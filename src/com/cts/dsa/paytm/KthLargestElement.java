
//Here's the Java code to find the Kth largest element in an unsorted array using the quickselect algorithm:

/*

Explanation:

In this problem, we want to find the Kth largest element in an unsorted array.
The findKthLargest function takes an array nums and an integer k as input.
It sorts the array using Arrays.sort(nums), which places the Kth largest element at the nums.length - k index.
The function then returns this Kth largest element.
The main function demonstrates how to use findKthLargest with a sample array and K value, printing the Kth largest element.*/

package com.cts.dsa.paytm;

import java.util.Arrays;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = findKthLargest(arr, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }
}
