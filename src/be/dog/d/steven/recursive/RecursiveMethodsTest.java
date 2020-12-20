package be.dog.d.steven.recursive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveMethodsTest {

    @Test
    void reversing_some_string_test(){
        String reversed = RecursiveMethods.reverseString("test");
        assertEquals(reversed, "tset");
    }

    @Test
    void sum_of_all_non_negative_integers_up_to_n_test(){
        int actual = RecursiveMethods.getSumOfAllIntsUpToN(5);
        assertEquals(15,actual);
    }

    @Test
    void all_possible_paths_from_top_left_to_bottom_right_test(){
        int numberOfUniquePaths = RecursiveMethods.getNumberOfUniquePaths(3,4);
        assertEquals(10,numberOfUniquePaths);
    }

    @Test
    void value_of_fibonacci_sequence_at_given_position_test(){
        int actual = RecursiveMethods.getValueAtFibonacciPosition(10);
        assertEquals(55, actual);
    }

    @Test
    void number_of_ways_to_partition_amount_of_objects_with_given_max_size_of_groups_test(){
        int numberOfWays = RecursiveMethods.getNumberOfWaysToGroupWithMaxGroupSize(6,4);
        assertEquals(9, numberOfWays);
    }

}