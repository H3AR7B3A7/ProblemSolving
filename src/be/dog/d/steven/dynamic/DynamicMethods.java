package be.dog.d.steven.dynamic;

/**
 * 1. Define the objective function
 * 2. Identify base case
 * 3. Write down transition function
 * 4. Identify the order of execution
 * 5. Identify the location of the answer
 */
public class DynamicMethods {

    /**
     * GET THE SUM OF ALL POSITIVE INTEGERS UP TO N
     *
     * @param n The target integer
     * @return The sum of all the integers up to n
     * 1. f(i) = sum of all the integers up to n
     * 2. f(0) = 0
     * 3. f(n) = f(n-1) + n
     * 4. bottom-up
     * 5. f(n)
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
     * GET THE NUMBER OF WAYS TO CLIMB A STAIRCASE CLIMBING 1 OR 2 STEPS AT A TIME
     *
     * @param numberOfStairs The amount of stairs in the staircase
     * @return Number of ways to climb the stairs
     * 1. f(i) = number of ways to climb the stairs
     * 2. f(0) = 1, f(1) = 1
     * 3. f(n) = f(n-1) + f(n-2)
     * 4. bottom-up
     * 5. f(n)
     */
    public static int staircaseTwo(int numberOfStairs) {
        int[] dp = new int[numberOfStairs + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= numberOfStairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[numberOfStairs];
    }

    /**
     * GET THE NUMBER OF WAYS TO CLIMB A STAIRCASE CLIMBING 1 OR 2 STEPS AT A TIME
     *
     * @param numberOfStairs The amount of stairs in the staircase
     * @return Number of ways to climb the stairs
     * This method is equivalent to previous one but with a better (fixed) space complexity.
     */
    public static int staircaseTwoImprovedSpaceComplexity(int numberOfStairs) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= numberOfStairs; i++) {
            c = b + a;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * GET THE NUMBER OF WAYS TO CLIMB A STAIRCASE CLIMBING 1, 2 or 3 STEPS AT A TIME
     *
     * @param numberOfStairs The amount of stairs in the staircase
     * @return Number of ways to climb the stairs
     * 1. f(i) = number of ways to climb the stairs
     * 2. f(0) = 1, f(1) = 1, f(2) = 2
     * 3. f(n) = f(n-1) + f(n-2) + f(n-3)
     * 4. bottom-up
     * 5. f(n)
     */
    public static int staircaseThree(int numberOfStairs) {
        int[] dp = new int[numberOfStairs + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= numberOfStairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[numberOfStairs];
    }

    /**
     * GET THE NUMBER OF WAYS TO CLIMB A STAIRCASE GIVEN A MAXIMUM NUMBER OF STAIRS IN ONE STEP
     *
     * @param numberOfStairs The amount of stairs in the staircase
     * @param maxStepSize    The maximum allowed number of stairs in one step
     * @return Number of ways to climb the stairs
     * 1. f(i) = number of ways to climb the stairs
     * 2. f(0) = 1
     * 3. f(n) = f(n-1) + f(n-2) + ... + f(n-maxStepSize) | n-maxStepSize >= 0
     * 4. bottom-up
     * 5. f(n)
     */
    public static int staircase(int numberOfStairs, int maxStepSize) {
        int[] dp = new int[numberOfStairs + 1];
        dp[0] = 1;
        for (int i = 1; i <= numberOfStairs; i++) {
            for (int j = 1; j <= maxStepSize && j <= i; j++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[numberOfStairs];
    }

    /**
     * GET THE NUMBER OF WAYS TO CLIMB A STAIRCASE GIVEN A MAXIMUM NUMBER OF STAIRS IN ONE STEP
     *
     * @param numberOfStairs The amount of stairs in the staircase
     * @param maxStepSize    The maximum allowed number of stairs in one step
     * @return Number of ways to climb the stairs
     * 1. f(i) = number of ways to climb the stairs
     * 2. f(0) = 1, f(1) = 1
     * 3. f(n) = f(n-1) + f(n-2) + ... + f(n-maxStepSize) | n-maxStepSize >= 0
     * 4. bottom-up
     * 5. f(n)
     */
    public static int staircaseImproved(int numberOfStairs, int maxStepSize) {
        int[] dp = new int[maxStepSize];
        dp[0] = 1;
        for (int i = 1; i <= numberOfStairs; i++) {
            for (int j = 1; j < maxStepSize && j <= i; j++) {
                dp[i % maxStepSize] += dp[(i - j) % maxStepSize];
            }
        }
        return dp[numberOfStairs % maxStepSize];
    }

    /**
     * GET THE NUMBER OF WAYS TO CLIMB A STAIRCASE GIVEN A MAXIMUM NUMBER OF STAIRS IN ONE STEP
     * WHILE SKIPPING RED STAIRS
     *
     * @param numberOfStairs The amount of stairs in the staircase
     * @param maxStepSize    The maximum allowed number of stairs in one step
     * @param isRed Boolean array with size numberOfStairs + 1, representing red stairs to be 'true'
     * @return Number of ways to climb the stairs
     * 1. f(i) = number of ways to climb the stairs
     * 2. f(0) = 1, f(1) = 1 | isRed[0] = false
     * 3. f(n) = f(n-1) + f(n-2) + ... + f(n-maxStepSize) | n-maxStepSize >= 0  &&  if(isRed[i-1] == true){ f(i) = 0 }
     * 4. bottom-up
     * 5. f(n)
     */
    public static int staircaseImprovedSkippingRedStairs(int numberOfStairs, int maxStepSize, boolean[] isRed) {
        int[] dp = new int[maxStepSize];
        dp[0] = 1;
        for (int i = 1; i <= numberOfStairs; i++) {
            for (int j = 1; j < maxStepSize && j <= i; j++) {
                if (isRed[i - 1]) {
                    dp[i % maxStepSize] = 0;
                } else {
                    dp[i % maxStepSize] += dp[(i - j) % maxStepSize];
                }
            }
        }
        return dp[numberOfStairs % maxStepSize];
    }

    /**
     * GET THE NUMBER OF WAYS TO CLIMB A STAIRCASE GIVEN A MAXIMUM NUMBER OF STAIRS IN ONE STEP
     * WHILE SKIPPING RED STAIRS
     *
     * @param numberOfStairs The amount of stairs in the staircase
     * @param maxStepSize    The maximum allowed number of stairs in one step
     * @param reds Array holding positions of red stairs
     * @return Number of ways to climb the stairs
     * 1. f(i) = number of ways to climb the stairs
     * 2. f(0) = 1, f(1) = 1
     * 3. f(n) = f(n-1) + f(n-2) + ... + f(n-maxStepSize) | n-maxStepSize >= 0  &&  if(reds.contains(i)){ f(i) = 0 }
     * 4. bottom-up
     * 5. f(n)
     */
    public static int staircaseImprovedSkippingRedStairs2(int numberOfStairs, int maxStepSize, int[] reds) {
        boolean[] isRed = new boolean[numberOfStairs+1];
        for (int red : reds) {
            isRed[red] = true;
        }
        int[] dp = new int[maxStepSize];
        dp[0] = 1;
        for (int i = 1; i <= numberOfStairs; i++) {
            for (int j = 1; j < maxStepSize && j <= i; j++) {
                if (isRed[i - 1]) {
                    dp[i % maxStepSize] = 0;
                } else {
                    dp[i % maxStepSize] += dp[(i - j) % maxStepSize];
                }
            }
        }
        return dp[numberOfStairs % maxStepSize];
    }
}
