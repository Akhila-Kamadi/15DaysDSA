import java.util.Arrays;

public class Knapsack_0_1 {
    private static int knapsack(int i, int j, int[] v, int[] w, int[][] dp) {
        if (i < 0 || j <= 0) {
            return 0;
        }
        if (dp[i][j] == -1) {
            int x = knapsack(i - 1, j, v, w, dp);
            if (j >= w[i]) {
                x = Math.max(x, knapsack(i - 1, j - w[i], v, w, dp) + v[i]);
            }
            dp[i][j] = x;
        }
        return dp[i][j];
    }

    public static int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int[][] dp = new int[n][C + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return knapsack(n - 1, C, A, B, dp);
    }

    public static void main(String[] args) {
        int[] A = {10, 20, 30, 40};
        int[] B = {12, 13, 15, 19};
        int C = 10;
        System.out.println(solve(A, B, C));
    }
}
