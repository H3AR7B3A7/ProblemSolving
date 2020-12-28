package be.dog.d.steven.recursive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecursiveMethodsTest {

    @Test
    void reversing_some_string_test() {
        assertEquals("tset", RecursiveMethods.reverseString("test"));
    }

    @Test
    void sum_of_all_non_negative_integers_up_to_n_test() {
        assertEquals(15, RecursiveMethods.getSumOfAllIntsUpToN(5));
    }

    @Test
    void all_possible_paths_from_top_left_to_bottom_right_test() {
        assertEquals(10, RecursiveMethods.getNumberOfUniquePaths(3, 4));
    }

    @Test
    void value_of_fibonacci_sequence_at_given_position_test() {
        assertEquals(55, RecursiveMethods.getValueAtFibonacciPosition(10));
        assertEquals(0, RecursiveMethods.getValueAtFibonacciPosition(0));
        assertEquals(1, RecursiveMethods.getValueAtFibonacciPosition(1));
        assertEquals(1, RecursiveMethods.getValueAtFibonacciPosition(2));
        assertEquals(2, RecursiveMethods.getValueAtFibonacciPosition(3));
        assertEquals(3, RecursiveMethods.getValueAtFibonacciPosition(4));
        assertEquals(5, RecursiveMethods.getValueAtFibonacciPosition(5));
    }

    @Test
    void number_of_ways_to_partition_amount_of_objects_with_given_max_size_of_groups_test() {
        assertEquals(9,
                RecursiveMethods.getNumberOfWaysToGroupWithMaxGroupSize(6, 4));
    }

}