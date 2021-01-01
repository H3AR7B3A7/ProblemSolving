package be.dog.d.steven.numbers;

import java.util.*;

public class NumberMethods {

    /**
     * GIVEN AN ARRAY AND INTEGER K, FIND THE TOTAL NUMBER OF SUB-ARRAYS WITH SUM EQUAL TO K
     *
     * @param nums The array to check for sub-arrays
     * @param k    The sum the sub-arrays must equal to
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
     *
     * @param nums The array to check for sub-arrays
     * @param k    The sum the sub-arrays must equal to
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

    /**
     * IN AN ARRAY OF INTEGERS, FIND THE TWO INTEGERS THAT APPEAR ONLY ONCE
     *
     * @param numbers The array containing integers with only 2 appearing once
     * @return An array with the 2 unique integers
     */
    public static int[] findNumbersWithoutDouble(int[] numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum = sum ^ number;
        }
        sum = sum & -sum;
        int number1 = 0;
        int number2 = 0;
        for (Integer number : numbers) {
            if ((number & sum) > 0) {
                number1 = number1 ^ number;
            } else {
                number2 = number2 ^ number;
            }
        }
        return new int[]{number1, number2}; // T:O(n), S:O(1)
    }

    public static int[] findNumbersWithoutDouble2(int[] numbers) {
        int sum = 0;
        int memo = 0;
        for (Integer number : numbers) {
            memo = sum = sum ^ number;
        }
        sum = sum & -sum;
        int number1 = 0;
        int number2 = 0;
        for (Integer number : numbers) {
            if ((number & sum) > 0) {
                number1 = number1 ^ number;
                number2 = memo - number1;
                break;
            }
        }
        return new int[]{number1, number2}; // T:O(n), S:O(1)
    }


}
