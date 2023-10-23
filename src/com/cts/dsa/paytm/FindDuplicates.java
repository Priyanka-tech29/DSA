
// Find all duplicates in an array of size N containing numbers from 0 to N-1

/*Explanation:

In this problem, we want to find all duplicates in an array of size N, where the numbers in the array range from 0 to N-1.
We use an ArrayList called duplicates to store the duplicate numbers we find.
The findDuplicates function iterates through the input array nums.
For each element in nums, it calculates the absolute value num and subtracts 1 to map it to the array index.
It checks whether the value at the calculated index is negative. A negative value indicates that we've seen this number before, so it's added to the duplicates list.
If the value is not negative, we mark it as negative to indicate that we've seen it.
After processing all elements, the function returns the duplicates list containing the duplicate numbers.
The main function demonstrates how to use findDuplicates with a sample array and prints the duplicate numbers.
*/
package com.cts.dsa.paytm;


import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;
            
            if (nums[index] < 0) {
                duplicates.add(num);
            } else {
                nums[index] = -nums[index];
            }
        }
        
        return duplicates;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 6, 1};
        List<Integer> result = findDuplicates(arr);
        System.out.println("Duplicates: " + result);
    }
}
