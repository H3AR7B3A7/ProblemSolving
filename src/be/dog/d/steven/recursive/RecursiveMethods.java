package be.dog.d.steven.recursive;

public class RecursiveMethods {

    /**
     * REVERSE STRING RECURSIVELY
     * @param str String to be reversed
     * @return The reverse of str
     */
    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    /**
     * GET THE SUM OF ALL POSITIVE INTEGERS UP TO N
     * @param n The target integer
     * @return The sum of all the integers up to n
     */
    public static int getSumOfAllIntsUpToN(int n) {
        if (n == 0){
            return 0;
        } else {
            return (n + getSumOfAllIntsUpToN(n - 1));
        }
    }

    /**
     * RETURN THE NUMBER OF UNIQUE PATHS IN A BxH ARRAY FROM TOP LEFT TO BOTTOM RIGHT
     * ONLY MOVING DOWN OR RIGHT
     * @param width Number of columns
     * @param height Number of rows
     * @return Number of unique paths
     */
    public static int getNumberOfUniquePaths(int width, int height) {
        if (width == 1 || height == 1){
            return 1;
        }else{
            return getNumberOfUniquePaths(width-1, height) + getNumberOfUniquePaths(width, height-1);
        }
    }

    /**
     * GET THE VALUE IN THE FIBONACCI SEQUENCE AT A GIVEN POSITION
     * @param position The position of the value we want to get
     * @return The value at the given position
     */
    public static int getValueAtFibonacciPosition(int position) {
        if (position == 0){
            return 0;
        } else if (position <= 2){
            return 1;
        } else {
            return getValueAtFibonacciPosition(position-1) + getValueAtFibonacciPosition(position-2);
        }
    }

    /**
     * GET THE NUMBER OF WAYS YOU CAN GROUP AN AMOUNT OF OBJECTS GIVEN A MAX GROUP SIZE
     * @param numberOfObjects Amount of objects to be grouped
     * @param maxGroupSize The maximum for individual group sizes
     * @return Number of possible ways to group up the objects
     */
    public static int getNumberOfWaysToGroupWithMaxGroupSize(int numberOfObjects, int maxGroupSize) {
        if (numberOfObjects == 0){
            return 1;
        } else if (maxGroupSize == 0 || numberOfObjects < 0){
            return 0;
        } else {
            return getNumberOfWaysToGroupWithMaxGroupSize(
                    numberOfObjects - maxGroupSize, maxGroupSize) +
                    getNumberOfWaysToGroupWithMaxGroupSize(
                            numberOfObjects, maxGroupSize -1);
        }
    }

}
