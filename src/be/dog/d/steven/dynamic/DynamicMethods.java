package be.dog.d.steven.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * DYNAMIC PROGRAMMING - COMBINATORIAL & OPTIMIZATION PROBLEMS
 * <p>
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
     * 4. Bottom-up
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
     * 4. Bottom-up
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
     * 4. Bottom-up
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
     * 4. Bottom-up
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
     * This method is equivalent to previous one but with a better (fixed) space complexity.
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
     * @param isRed          Boolean array with size numberOfStairs + 1, representing red stairs to be 'true'
     * @return Number of ways to climb the stairs
     * 1. f(i) = number of ways to climb the stairs
     * 2. f(0) = 1, f(1) = 1 | isRed[0] = false
     * 3. f(n) = f(n-1) + f(n-2) + ... + f(n-maxStepSize) | n-maxStepSize >= 0  &&  if(isRed[i-1] == true){ f(i) = 0 }
     * 4. Bottom-up
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
     * @param reds           Array holding positions of red stairs
     * @return Number of ways to climb the stairs
     * 1. f(i) = number of ways to climb the stairs
     * 2. f(0) = 1, f(1) = 1
     * 3. f(n) = f(n-1) + f(n-2) + ... + f(n-maxStepSize) | n-maxStepSize >= 0  &&  if(reds.contains(i)){ f(i) = 0 }
     * 4. Bottom-up
     * 5. f(n)
     */
    public static int staircaseImprovedSkippingRedStairs2(int numberOfStairs, int maxStepSize, int[] reds) {
        boolean[] isRed = new boolean[numberOfStairs + 1];
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

    /**
     * FIND THE MINIMAL COST TO CLIMB STAIRS WITH EACH USED STAIR COSTING A DIFFERENT PRICE
     * TRAVERSING A MAXIMUM OF 2 STEPS AT A TIME
     *
     * @param prices Price for each stair
     * @return Minimal price to climb stairs
     * 1. f(i) = Minimum cost to get to stair i
     * 2. f(0) = 0
     * 3. f(n) = Price[n-1] + min(f(n-1), f(n-2))
     * 4. Bottom-up
     * 5. f(n)
     */
    public static int paidStaircase(int[] prices) {
        int[] dp = new int[prices.length + 1];
        dp[0] = 0;
        dp[1] = prices[0];
        for (int i = 2; i <= prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + prices[i - 1];
        }
        return dp[prices.length];
    }

    /**
     * This method is equivalent to previous one but with a better (fixed) space complexity.
     */
    public static int paidStaircaseImproved(int[] prices) {
        int a = 0;
        int b = prices[0];
        int c = prices[0];
        for (int i = 2; i <= prices.length; i++) {
            c = Math.min(b, a) + prices[i - 1];
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * GET THE PATH WITH MINIMAL COST TO CLIMB STAIRS WITH EACH USED STAIR COSTING A DIFFERENT PRICE
     * TRAVERSING A MAXIMUM OF 2 STEPS AT A TIME
     *
     * @param prices Price for each stair
     * @return Path to climb stairs with minimal cost
     */
    public static List<Integer> paidStaircasePath(int[] prices) {
        int[] dp = new int[prices.length + 1];
        int[] origins = new int[prices.length + 1];
        dp[0] = 0;
        dp[1] = prices[0];
        for (int i = 2; i <= prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + prices[i - 1];
            if (dp[i - 1] < dp[i - 2]) {
                origins[i] = i - 1;
            } else {
                origins[i] = i - 2;
            }
        }
        List<Integer> path = new ArrayList<>();
        for (int i = prices.length; i > 0; i = origins[i]) {
            path.add(i);
        }
        Collections.reverse(path);
        return path;
    }

    /**
     * RETURN THE NUMBER OF UNIQUE PATHS IN A WxH ARRAY FROM TOP LEFT TO BOTTOM RIGHT
     * ONLY MOVING DOWN OR RIGHT
     *
     * @param w Number of columns
     * @param h Number of rows
     * @return Number of unique paths
     * 1. f(i,j) = Number of unique paths to (i,j)
     * 2. f(0,0) = 1
     * 3. f(w,h) = f(w-1,h) + f(w,h-1)
     * 4. Bottom-up
     * 5. f(w,h)
     */
    public static int uniquePaths(int w, int h) {
        int[][] dp = new int[w][h];
        dp[0][0] = 1;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[w - 1][h - 1];
    }

    /**
     * RETURN THE NUMBER OF UNIQUE PATHS IN A WxH ARRAY FROM TOP LEFT TO BOTTOM RIGHT
     * ONLY MOVING DOWN OR RIGHT, WITHOUT TRAVERSING OBSTACLES IN A GIVEN ARRAY
     *
     * @param isRed Array with 1 for obstacle and 0 for absence of obstacle
     * @return Number of unique paths
     * 1. f(i,j) = Number of unique paths to (i,j)
     * 2. f(0,0) = 1
     * 3. f(w,h) = f(w-1,h) + f(w,h-1) | if(isRed == 1){ f(i,j) = 0 }
     * 4. Bottom-up
     * 5. f(w,h)
     */
    public static int uniquePathsWithObstacles(int[][] isRed) {
        int w = isRed.length;
        int h = isRed[0].length;

        int[][] dp = new int[w][h];
        dp[0][0] = 1;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (isRed[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[w - 1][h - 1];
    }

    /**
     * RETURN THE MAXIMUM VALUE WE CAN GET FOLLOWING A PATHS IN A WxH ARRAY FROM TOP LEFT TO
     * BOTTOM RIGHT ONLY MOVING DOWN OR RIGHT, GIVEN AN ARRAY OF VALUES
     *
     * @param values Array with values
     * @return Maximum accumulated values on a path
     * 1. f(i,j) = Maximum collected value on (i,j)
     * 2. f(0,0) = 0
     * 3. f(w,h) = max(f(w-1,h),f(w,h-1)) + valueAt(w,h)
     * 4. Bottom-up
     * 5. f(w,h)
     */
    public static int maximumValuePath(int[][] values) {
        int w = values.length;
        int h = values[0].length;
        int[][] dp = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + values[i][j];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j] + values[i][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j - 1] + values[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[w - 1][h - 1];
    }

    /**
     * RETURN THE PATH WITH MAXIMUM VALUE WE CAN GET FOLLOWING A PATHS IN A WxH ARRAY FROM
     * TOP LEFT TO BOTTOM RIGHT ONLY MOVING DOWN OR RIGHT, GIVEN AN ARRAY OF VALUES
     *
     * @param values Array with values
     * @return Maximum accumulated values on a path
     * 1. f(i,j) = Maximum collected value on (i,j)
     * 2. f(0,0) = 0
     * 3. f(w,h) = max(f(w-1,h),f(w,h-1)) + valueAt(w,h)
     * 4. Bottom-up
     * 5. f(w,h)
     */
    public static List<Integer[]> pathOfMaximumValuePath(int[][] values) {
        int w = values.length;
        int h = values[0].length;
        int[][] dp = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + values[i][j];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j] + values[i][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j - 1] + values[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return getPath(dp, w - 1, h - 1);
    }

    /**
     * HELPER FUNCTION
     *
     * @param dp Results of main function
     * @param i  Current width
     * @param j  Current Height
     * @return Path as list of [i,j] coords
     */
    private static List<Integer[]> getPath(int[][] dp, Integer i, Integer j) {
        List<Integer[]> path = new ArrayList<>();
        if (i == 0 && j == 0) { // Negate this check !() and make the others children to avoid empty body.
            // Return path here to drop [0,0] from list
        } else if (i == 0) {
            path = getPath(dp, i, j - 1);
        } else if (j == 0) {
            path = getPath(dp, i - 1, j);
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                path = getPath(dp, i - 1, j);
            } else {
                path = getPath(dp, i, j - 1);
            }
        }
        path.add(new Integer[]{i, j});
        return path;
    }

    /**
     * DIFFERENT WAYS TO PAINT FENCE WITH TWO COLORS, NOT REPEATING COLOR ON MORE THEN 2
     * FENCE POSTS
     *
     * @param n Number of posts
     * @return Number of ways to paint the fence
     * 1. f(i,j) = Total number of ways to paint i posts painted in j (blue/green)
     * 2. f(1,0) = 1, f(1,1) = 1, f(2,0) = 2, f(2,1) = 2
     * 3. f(n,j) = f(n-1, 1-j) + f(n-2, 1-j)
     * 4. Bottom-up
     * 5. f(n,0) + f(n,1)
     */
    public static int waysToPaintFence(int n) {
        int[][] dp = new int[n + 1][2];
        dp[1][0] = 1; // 0 = blue
        dp[1][1] = 1; // 1 = green
        dp[2][0] = 2; // 10, 00
        dp[2][1] = 2; // 11, 01
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                dp[i][j] = dp[i - 1][1 - j] + dp[i - 2][1 - j];
            }
        }
        return dp[n][0] + dp[n][1];
    }


}
