package be.dog.d.steven.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicMethodsTest {

    @Test
    void nSum_test(){
        assertEquals(15, DynamicMethods.nSum(5));
    }

    @Test
    void number_of_ways_to_climb_staircase_test(){
        assertEquals(5, DynamicMethods.staircase(4,2));
    }


}