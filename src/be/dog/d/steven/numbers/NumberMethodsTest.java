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
    void transitive_closure_test() {
        int[][] graph = new int[][]{{0, 1, 3}, {1, 2}, {2}, {3}};
        assertEquals(Arrays.deepToString(new int[][]{}), Arrays.deepToString(graph));
    }
}