package be.dog.d.steven.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicMethodsTest {

    @Test
    void nSum_test(){
        assertEquals(15, DynamicMethods.nSum(5));
    }



}