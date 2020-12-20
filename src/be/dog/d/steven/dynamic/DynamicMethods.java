package be.dog.d.steven.dynamic;

public class DynamicMethods {

    /**
     * GET THE SUM OF ALL POSITIVE INTEGERS UP TO N
     * @param n The target integer
     * @return The sum of all the integers up to n
     */
    public static int nSum(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + i;
        }
        return dp[n];
    }

    /**
     * GET THE NUMBER OF WAYS TO CLIMB A STAIRCASE GIVEN A MAXIMUM NUMBER OF STAIRS IN ONE STEP
     * @param numberOfStairs The amount of stairs in the staircase
     * @param maxStepSize The maximum allowed number of stairs in one step
     * @return Number of ways to climb th stairs
     */
    public static int staircase(int numberOfStairs, int maxStepSize) {
        int[] dp = new int[numberOfStairs + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < numberOfStairs + 1; i++) {
            dp[i] = 0;
            for (int j = 1; j <= maxStepSize && j <= i; j++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[numberOfStairs];
    }


}
