package be.dog.d.steven.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NumberMethodsTest {

    @Test
    void check_number_of_sub_arrays_equal_to_k() {
        int[] nums = {1, 1, 1};
        assertEquals(2, NumberMethods.numberOfSubArraysEqualToAnIntegerBruteForce(nums, 2));
    }

    @Test
    void check_number_of_sub_arrays_equal_to_k_optimized() {
        int[] nums = {1, 1, 1, 5, 3, 6, 2, -1, 9, -1, 8, 1};
        assertEquals(7, NumberMethods.numberOfSubArraysEqualToAnInteger(nums, 8));
    }

    @Test
    void find_nth_number_with_digits_adding_up_to_ten_test() {
        assertEquals(28, NumberMethods.findNumberWithSumOfDigitsTen(2));
        assertEquals(55, NumberMethods.findNumberWithSumOfDigitsTen(5));
        assertEquals(604, NumberMethods.findNumberWithSumOfDigitsTen(50));
    }

    @Test
    void find_nth_number_with_digits_adding_up_to_10_test() {
        assertEquals(28, NumberMethods.findNumberWithSumOfDigits10(2));
        assertEquals(55, NumberMethods.findNumberWithSumOfDigits10(5));
        assertEquals(604, NumberMethods.findNumberWithSumOfDigits10(50));
    }

    @Test
    void find_two_numbers_without_double() {
        int[] nums = {2, 4, 6, 8, 10, 2, 6, 10};
        assertEquals(Arrays.toString(new int[]{4, 8}), Arrays.toString(NumberMethods.findNumbersWithoutDouble(nums)));
    }

    @Test
    void find_two_numbers_without_double2() {
        int[] nums = {2, 4, 6, 8, 10, 2, 6, 10};
        assertEquals(Arrays.toString(new int[]{4, 8}), Arrays.toString(NumberMethods.findNumbersWithoutDouble2(nums)));
    }

    @Test
    void find_two_addends_of_target_sum_test() {
        int[] nums = {2, 7, 11, 15};
        assertEquals(Arrays.toString(new int[]{0, 1}), Arrays.toString(NumberMethods.findTwoAddendsOfTargetSum(nums, 9)));
    }

    @Test
    void test() {
        int[] nums = {10, 40, 200, 1000, 60, 30};
        assertEquals(Arrays.toString(new int[]{1, 2, 3, 4, 2, 1}), Arrays.toString(NumberMethods.minimalRaiseComparedToNeighborsLines(nums)));
        nums = new int[]{10, 10, 30, 20, 10, 50};
        assertEquals(Arrays.toString(new int[]{1, 1, 3, 2, 1, 2}), Arrays.toString(NumberMethods.minimalRaiseComparedToNeighborsLines(nums)));
        nums = new int[]{10, 20, 10, 20, 10, 20, 10};
        assertEquals(Arrays.toString(new int[]{1, 2, 1, 2, 1, 2, 1}), Arrays.toString(NumberMethods.minimalRaiseComparedToNeighborsLines(nums)));
    }
}