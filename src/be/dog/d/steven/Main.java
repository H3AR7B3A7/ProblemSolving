package be.dog.d.steven;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /**
         * StoneGameVII
         */
        int[] array = new int[]{1, 100, 1};
        System.out.println(new StoneGameSolution().stoneGameVII(array)); // Expected: 1
        array = new int[]{7, 90, 5, 1, 100, 10, 10, 2};
        System.out.println(new StoneGameSolution().stoneGameVII(array)); // Expected: 122
        array = new int[]{5, 3, 1, 4, 2};
        System.out.println(new StoneGameSolution().stoneGameVII(array)); // Expected: 6 ???
        /**
         * This problem asks for dynamic programming, as our recursion function doesn't work
         * for these more complex cases. If we were to account for these occurrences we'd end
         * up with 'a lot' of code.
         */
        array = new int[]{5, 3, 1, 4, 2};
        System.out.println(new StoneGameDynamicSolution().stoneGameVII(array)); // Expected: 6
    }
}


/**
 * LEETCODE PROBLEM:
 * Alice and Bob take turns playing a game, with Alice starting first.
 * There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or the
 * rightmost stone from the row and receive points equal to the sum of the remaining stones' values in the row.
 * The winner is the one with the higher score when there are no stones left to remove.
 * Bob found that he will always lose this game, so he decided to minimize the score's difference.
 * Alice's goal is to maximize the difference in the score.
 * Given an array of integers stones where stones[i] represents the value of the ith stone from the left,
 * return the difference in Alice and Bob's score if they both play optimally.
 */
class StoneGameSolution {

    int alice = 0;
    int bob = 0;
    boolean aliceTurn = true;

    public int stoneGameVII(int[] stones) {

        if (stones.length < 2) {
            return alice - bob;
        } else {
            int[] copy = new int[stones.length - 1];
            if (stones[0] > stones[stones.length - 1]) {
                for (int i = 0, j = 0; i < stones.length - 1; i++) {
                    copy[j++] = stones[i];
                }
            } else {
                for (int i = 1, j = 0; i < stones.length; i++) {
                    copy[j++] = stones[i];
                }
            }
            stones = copy;

            if (aliceTurn) {
                alice += Arrays.stream(stones).sum();
                aliceTurn = false;
            } else {
                bob += Arrays.stream(stones).sum();
                aliceTurn = true;
            }
        }
        return stoneGameVII(stones);
    }
}

/**
 * NOT MY CODE: Let's try to find out how this works by learning about 'Dynamic Programming'.
 */
class StoneGameDynamicSolution {

    public int stoneGameVII(int[] stones) {

        int n=stones.length;
        int[] preSum=new int[n];
        preSum[0]=stones[0];
        for(int i=1;i<n;i++)
            preSum[i]+=preSum[i-1]+stones[i];
        int[][] dp=new int[n][n];
        for(int len=1;len<n;len++){
            for(int i=0;i+len<n;i++){
                int j=i+len;
                dp[i][j]=preSum[j-1]-(i==0?0:preSum[i-1])-dp[i][j-1];
                if(dp[i][j]<preSum[j]-preSum[i]-dp[i+1][j])
                    dp[i][j]=preSum[j]-preSum[i]-dp[i+1][j];
            }
        }
        return dp[0][n-1];

    }
}