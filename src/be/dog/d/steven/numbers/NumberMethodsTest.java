package be.dog.d.steven.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberMethodsTest {

    @Test
    void check_number_of_sub_arrays_equal_to_k(){
        int[] nums = {1,1,1};
        assertEquals(2, NumberMethods.numberOfSubArraysEqualToAnIntegerBruteForce(nums,2));
    }

    @Test
    void check_number_of_sub_arrays_equal_to_k_optimized(){
        int[] nums = {1,1,1,5,3,6,2,-1,9,-1,8,1};
        assertEquals(7, NumberMethods.numberOfSubArraysEqualToAnInteger(nums,8));
    }
}