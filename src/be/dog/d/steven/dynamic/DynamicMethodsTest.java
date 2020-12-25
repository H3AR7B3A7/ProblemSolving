package be.dog.d.steven.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicMethodsTest {

    @Test
    void nSum_test() {
        assertEquals(15, DynamicMethods.nSum(5));
    }

    @Test
    void number_of_ways_to_climb_staircase_step_size_two_test() {
        assertEquals(5, DynamicMethods.staircaseTwo(4));
    }

    @Test
    void number_of_ways_to_climb_staircase_step_size_two_improved_space_test() {
        assertEquals(5, DynamicMethods.staircaseTwoImprovedSpaceComplexity(4));
    }

    @Test
    void number_of_ways_to_climb_staircase_step_size_three_test() {
        assertEquals(7, DynamicMethods.staircaseThree(4));
    }

    @Test
    void number_of_ways_to_climb_staircase_variable_step_size_test() {
        assertEquals(8, DynamicMethods.staircase(4, 4));
    }

    @Test
    void number_of_ways_to_climb_staircase_variable_step_size_improved_test() {
        assertEquals(8, DynamicMethods.staircaseImproved(4, 4));
    }

    @Test
    void number_of_ways_to_climb_staircase_variable_step_size_improved_with_reds_test() {
        boolean[] isRed = {false, true, false, true, true, false, false, false};
        assertEquals(2, DynamicMethods.staircaseImprovedSkippingRedStairs(7, 3, isRed));
    }

    @Test
    void number_of_ways_to_climb_staircase_variable_step_size_improved_with_reds_improved_test() {
        int[] reds = {1, 3, 4};
        assertEquals(2, DynamicMethods.staircaseImprovedSkippingRedStairs2(7, 3, reds));
    }

    @Test
    void paid_stair_case_test(){
        int[] prices = {3,2,4};
        assertEquals(6, DynamicMethods.paidStaircase(prices));
    }

    @Test
    void paid_stair_case_improved_test(){
        int[] prices = {3,2,4};
        assertEquals(6, DynamicMethods.paidStaircaseImproved(prices));
    }
}