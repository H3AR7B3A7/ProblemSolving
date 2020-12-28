package be.dog.d.steven.dynamic;

import be.dog.d.steven.recursive.RecursiveMethods;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    void paid_stair_case_test() {
        int[] prices = {3, 2, 4};
        assertEquals(6, DynamicMethods.paidStaircase(prices));
    }

    @Test
    void paid_stair_case_improved_test() {
        int[] prices = {3, 2, 4};
        assertEquals(6, DynamicMethods.paidStaircaseImproved(prices));
    }

    @Test
    void paid_stair_case_path_test() {
        int[] prices = {3, 2, 4, 6, 1, 1, 5, 3};
        List<Integer> expected = List.of(2, 3, 5, 6, 8);
        assertEquals(expected, DynamicMethods.paidStaircasePath(prices));
    }

    @Test
    void all_possible_paths_from_top_left_to_bottom_right_test() {
        assertEquals(10, DynamicMethods.uniquePaths(3, 4));
    }

    @Test
    void all_possible_paths_given_array_of_obstacles_test() {
        int[][] isRed = {{0, 0, 0, 0},{0, 1, 1, 1},{0, 0, 0, 0}};
        assertEquals(1,DynamicMethods.uniquePathsWithObstacles(isRed));
    }

    @Test
    void maximum_value_path_for_given_values_test(){
        int[][] values = {{0,2,2,1},{3,1,1,1},{4,4,2,0}};
        int[][] values2 = {{0,1,1,1,10},{2,1,1,1,1,},{2,1,1,2,0}};
        assertEquals(13,DynamicMethods.maximumValuePath(values));
        assertEquals(14, DynamicMethods.maximumValuePath(values2));
    }

    @Test
    void path_for_maximum_value_path_for_given_values_test(){
        int[][] values = {{0,2,2,1},{3,1,1,1},{4,4,2,0}};
        int[][] values2 = {{0,1,1,1,10},{2,1,1,1,1,},{2,1,1,2,0}};

        //        DynamicMethods.pathOfMaximumValuePath(values).forEach(e -> System.out.println(Arrays.deepToString(e)));
        Integer[][] expectedPath = {{0,0},{1,0},{2,0},{2,1},{2,2},{2,3}};
        Integer[][] array = DynamicMethods.pathOfMaximumValuePath(values).toArray(new Integer[2][values.length+values[0].length]);
        System.out.println(Arrays.deepToString(array));

        Integer[][] expectedPath2 = {{0,0},{0,1},{0,2},{0,3},{0,4},{1,4},{2,4}};
        Integer[][] array2 = DynamicMethods.pathOfMaximumValuePath(values2).toArray(new Integer[2][values2.length+values2[0].length]);
        System.out.println(Arrays.deepToString(array2));

        assertEquals(Arrays.deepToString(expectedPath), Arrays.deepToString(array));
        assertEquals(Arrays.deepToString(expectedPath2), Arrays.deepToString(array2));
    }

    @Test
    void ways_to_paint_fence_in_two_colors_test(){
        assertEquals(6, DynamicMethods.waysToPaintFence(3));
    }


}