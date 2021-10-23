package be.dog.d.steven.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static be.dog.d.steven.numbers.NumberMethods.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberMethodsTest {

    @Test
    void check_number_of_sub_arrays_equal_to_k() {
        int[] nums = {1, 1, 1};
        assertEquals(2, numberOfSubArraysEqualToAnIntegerBruteForce(nums, 2));
    }

    @Test
    void check_number_of_sub_arrays_equal_to_k_optimized() {
        int[] nums = {1, 1, 1, 5, 3, 6, 2, -1, 9, -1, 8, 1};
        assertEquals(7, numberOfSubArraysEqualToAnInteger(nums, 8));
    }

    @Test
    void find_nth_number_with_digits_adding_up_to_ten_test() {
        assertEquals(28, findNumberWithSumOfDigitsTen(2));
        assertEquals(55, findNumberWithSumOfDigitsTen(5));
        assertEquals(604, findNumberWithSumOfDigitsTen(50));
    }

    @Test
    void find_nth_number_with_digits_adding_up_to_10_test() {
        assertEquals(28, findNumberWithSumOfDigits10(2));
        assertEquals(55, findNumberWithSumOfDigits10(5));
        assertEquals(604, findNumberWithSumOfDigits10(50));
    }

    @Test
    void find_two_numbers_without_double() {
        int[] nums = {2, 4, 6, 8, 10, 2, 6, 10};
        assertEquals(Arrays.toString(new int[]{4, 8}), Arrays.toString(findNumbersWithoutDouble(nums)));
    }

    @Test
    void find_two_numbers_without_double2() {
        int[] nums = {2, 4, 6, 8, 10, 2, 6, 10};
        assertEquals(Arrays.toString(new int[]{4, 8}), Arrays.toString(findNumbersWithoutDouble2(nums)));
    }

    @Test
    void find_two_addends_of_target_sum_test() {
        int[] nums = {2, 7, 11, 15};
        assertEquals(Arrays.toString(new int[]{0, 1}), Arrays.toString(findTwoAddendsOfTargetSum(nums, 9)));
    }

    @Test
    void find_minimal_raises_comparing_lines_of_code_of_neighbors_test() {
        int[] nums = {10, 40, 200, 1000, 60, 30};
        assertEquals(Arrays.toString(new int[]{1, 2, 3, 4, 2, 1}), Arrays.toString(minimalRaiseComparedToNeighborsLines(nums)));
        nums = new int[]{10, 10, 30, 20, 10, 50};
        assertEquals(Arrays.toString(new int[]{1, 1, 3, 2, 1, 2}), Arrays.toString(minimalRaiseComparedToNeighborsLines(nums)));
        nums = new int[]{10, 20, 10, 20, 10, 20, 10};
        assertEquals(Arrays.toString(new int[]{1, 2, 1, 2, 1, 2, 1}), Arrays.toString(minimalRaiseComparedToNeighborsLines(nums)));
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
        assertEquals(expected, removeConsecutiveNumberSumsOfZero(nums));
        nums = new LinkedList<>();
        nums.add(1);
        nums.add(2);
        nums.add(-3);
        nums.add(3);
        nums.add(1);
        expected = new LinkedList<>();
        expected.add(3);
        expected.add(1);
        assertEquals(expected, removeConsecutiveNumberSumsOfZero(nums));
    }

    @Test
    void reverse_integer_test() {
        assertEquals(64321, reverseInteger(12346));
    }

    @Test
    void reverse_negative_integer_test() {
        assertEquals(-9594, reverseInteger(-4959));
    }

    @Test
    void minimum_number_of_classrooms_test() {
        int[][] timeIntervals = {{30, 75}, {0, 50}, {60, 150}};
        assertEquals(2, minimumClassrooms(timeIntervals));
    }

    @Test
    void triangular_number_test() {
        assertEquals(23220, triangleNumber(215));
        assertEquals(1, triangleNumber(1));
        assertEquals(0, triangleNumber(0));
    }

    @Test
    void triangular_number_2_test() {
        assertEquals(23220, triangleNumber2(215));
        assertEquals(1, triangleNumber2(1));
        assertEquals(0, triangleNumber2(0));
    }

    @Test
    void amount_of_triples_that_sum_to_zero_test() {
        int[] numbers = {30, -40, -20, -10, 40, 0, 10, 5};
        assertEquals(4, amountOfTriplesThatSumToZero(numbers));
    }

    @Test
    void amount_of_triples_that_sum_to_zero_improved_test() {
        int[] numbers = {30, -40, -20, -10, 40, 0, 10, 5};
        assertEquals(4, amountOfTriplesThatSumToZeroImproved(numbers));
    }

    @Test
    void amount_of_triples_that_sum_to_zero_sorted_test() {
        int[] numbers = {30, -40, -20, -10, 40, 0, 10, 5};
        assertEquals(4, amountOfTriplesThatSumToZeroSorted(numbers));
    }
    
    @Test
    void count_of_appearances_of_number_in_multiplication_table(){
        assertEquals(3, multiplicationTableAppearancesFor(6, 4));
    }

    @Test
    void count_of_appearances_of_number_in_multiplication_table_with_negatives_1(){
        assertEquals(6, multiplicationTableAppearancesForWithNegatives(6, 4));
    }
    
    @Test
    void count_of_appearances_of_number_in_multiplication_table_with_negatives_2(){
        assertEquals(6, multiplicationTableAppearancesForWithNegatives(6, -4));
    }

    @Test
    void count_of_appearances_of_number_in_multiplication_table_with_negatives_3(){
        assertEquals(6, multiplicationTableAppearancesForWithNegatives(-6, -4));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Math.sqrt(Long.MAX_VALUE));
    }
}