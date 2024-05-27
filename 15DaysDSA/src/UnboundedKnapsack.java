import java.util.Arrays;

public class UnboundedKnapsack {


    private static int unboundKnapsack(int i, int j, int[] v, int[] w, int[][] dp) {
        if (i < 0 || j <= 0) {
            return 0;
        }

        if (dp[i][j] == -1) {
            //leave
            dp[i][j] = unboundKnapsack(i - 1, j, v, w, dp);
            if (j >= w[i]) {
                //pick and stay
                dp[i][j] = Math.max(dp[i][j], unboundKnapsack(i, j - w[i], v, w, dp) + v[i]);
            }
        }

        return dp[i][j];
    }

    //B -> values, C -> weights, A -> Knapsack capacity
    public static int solve(int A, int[] B, int[] C) {
        int n = B.length;
        int[][] dp = new int[n][A + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return unboundKnapsack(n - 1, A, B, C, dp);
    }

    public static void main(String[] args) {
        int A = 10;
        int[] B = {6,7}, C = {5,5};
        System.out.println(solve(A, B, C));
    }
}
