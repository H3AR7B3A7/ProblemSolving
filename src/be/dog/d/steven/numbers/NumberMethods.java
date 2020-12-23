package be.dog.d.steven.numbers;

import java.util.HashMap;

public class NumberMethods {

    /**
     * GIVEN AN ARRAY AND INTEGER K, FIND THE TOTAL NUMBER OF SUB-ARRAYS WITH SUM EQUAL TO K
     * @param nums The array to check for sub-arrays
     * @param k The sum the sub-arrays must equal to
     * @return Number of sub-arrays
     */
    public static int numberOfSubArraysEqualToAnIntegerBruteForce(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    res++;
            }
        }
        return res;
    }

    /**
     * GIVEN AN ARRAY AND INTEGER K, FIND THE TOTAL NUMBER OF SUB-ARRAYS WITH SUM EQUAL TO K
     * @param nums The array to check for sub-arrays
     * @param k The sum the sub-arrays must equal to
     * @return Number of sub-arrays
     */
    public static int numberOfSubArraysEqualToAnInteger(int[] nums, int k) {
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        int res = 0;
        int current = 0;
        for (int num : nums) {
            current += num;
            if (current == k)
                res++;
            if (prevSum.containsKey(current - k))
                res += prevSum.get(current - k);
            prevSum.merge(current, 1, Integer::sum);
        }
        return res;
    }
}
