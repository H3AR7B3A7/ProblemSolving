package be.dog.d.steven.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void find_minimal_raises_comparing_lines_of_code_of_neighbors_test() {
        int[] nums = {10, 40, 200, 1000, 60, 30};
        assertEquals(Arrays.toString(new int[]{1, 2, 3, 4, 2, 1}), Arrays.toString(NumberMethods.minimalRaiseComparedToNeighborsLines(nums)));
        nums = new int[]{10, 10, 30, 20, 10, 50};
        assertEquals(Arrays.toString(new int[]{1, 1, 3, 2, 1, 2}), Arrays.toString(NumberMethods.minimalRaiseComparedToNeighborsLines(nums)));
        nums = new int[]{10, 20, 10, 20, 10, 20, 10};
        assertEquals(Arrays.toString(new int[]{1, 2, 1, 2, 1, 2, 1}), Arrays.toString(NumberMethods.minimalRaiseComparedToNeighborsLines(nums)));
    }

    @Test
    void remove_consecutive_sums_of_zero_test() {
        LinkedList<Integer> nums = new LinkedList<>();
        nums.add(3);
        nums.add(4);
        nums.add(-7);
        nums.add(5);
        nums.add(-6);
        nums.add(6);
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(5);
        assertEquals(expected, NumberMethods.removeConsecutiveNumberSumsOfZero(nums));
        nums = new LinkedList<>();
        nums.add(1);
        nums.add(2);
        nums.add(-3);
        nums.add(3);
        nums.add(1);
        expected = new LinkedList<>();
        expected.add(3);
        expected.add(1);
        assertEquals(expected, NumberMethods.removeConsecutiveNumberSumsOfZero(nums));
    }

    @Test
    void reverse_integer_test() {
        assertEquals(64321, NumberMethods.reverseInteger(12346));
    }

    @Test
    void reverse_negative_integer_test() {
        assertEquals(-9594, NumberMethods.reverseInteger(-4959));
    }

    @Test
    void minimum_number_of_classrooms_test() {
        int[][] timeIntervals = {{30, 75}, {0, 50}, {60, 150}};
        assertEquals(2, NumberMethods.minimumClassrooms(timeIntervals));
    }

    @Test
    void triangular_number_test() {
        assertEquals(23220, NumberMethods.triangleNumber(215));
        assertEquals(1, NumberMethods.triangleNumber(1));
        assertEquals(0, NumberMethods.triangleNumber(0));
    }

    @Test
    void triangular_number_2_test() {
        assertEquals(23220, NumberMethods.triangleNumber2(215));
        assertEquals(1, NumberMethods.triangleNumber2(1));
        assertEquals(0, NumberMethods.triangleNumber2(0));
    }

    @Test
    void amount_of_triples_that_sum_to_zero_test() {
        int[] numbers = {30, -40, -20, -10, 40, 0, 10, 5};
        assertEquals(4, NumberMethods.amountOfTriplesThatSumToZero(numbers));
    }

    @Test
    void amount_of_triples_that_sum_to_zero_improved_test() {
        int[] numbers = {30, -40, -20, -10, 40, 0, 10, 5};
        assertEquals(4, NumberMethods.amountOfTriplesThatSumToZeroImproved(numbers));
    }

    @Test
    void amount_of_triples_that_sum_to_zero_sorted_test() {
        int[] numbers = {30, -40, -20, -10, 40, 0, 10, 5};
        assertEquals(4, NumberMethods.amountOfTriplesThatSumToZeroSorted(numbers));
    }
}