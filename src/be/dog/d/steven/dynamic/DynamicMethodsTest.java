package be.dog.d.steven.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicMethodsTest {

    @Test
    void nSum_test(){
        assertEquals(15, DynamicMethods.nSum(5));
    }

    @Test
    void number_of_ways_to_climb_staircase_step_size_two_test(){
        assertEquals(5, DynamicMethods.staircaseTwo(4));
    }

    @Test
    void number_of_ways_to_climb_staircase_step_size_two_improved_space_test(){
        assertEquals(5, DynamicMethods.staircaseTwoImprovedSpaceComplexity(4));
    }

    @Test
    void number_of_ways_to_climb_staircase_step_size_three_test(){
        assertEquals(7, DynamicMethods.staircaseThree(4));
    }

    @Test
    void number_of_ways_to_climb_staircase_variable_step_size_test(){
        assertEquals(8, DynamicMethods.staircase(4,4));
    }

}