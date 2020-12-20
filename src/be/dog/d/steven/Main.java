package be.dog.d.steven;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[]{1,100,1};
        System.out.println(StoneGameSolution.stoneGameVII(array)); // 1
        StoneGameSolution.reset();
        array = new int[]{7,90,5,1,100,10,10,2};
        System.out.println(StoneGameSolution.stoneGameVII(array)); // 122
        StoneGameSolution.reset();
        array = new int[]{5,3,1,4,2};
        System.out.println(StoneGameSolution.stoneGameVII(array)); // 6 ???
        StoneGameSolution.reset();
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
    static int alice = 0;
    static int bob = 0;
    static Boolean aliceTurn = true;

    public static int stoneGameVII(int[] stones) {

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

    public static void reset(){
        StoneGameSolution.alice = 0;
        StoneGameSolution.bob = 0;
        StoneGameSolution.aliceTurn = true;
    }
}