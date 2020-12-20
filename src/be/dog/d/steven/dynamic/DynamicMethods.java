package be.dog.d.steven.dynamic;

public class DynamicMethods {

    /**
     * GET THE SUM OF ALL POSITIVE INTEGERS UP TO N
     * @param n The target integer
     * @return The sum of all the integers up to n
     */
    public static int nSum(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + i;
        }
        return dp[n];
    }
}
