import java.util.Arrays;

public class MinimumNumberOfSquares {
    static int minSquares(int i, int[] dp, int n) {
        if (i == 0){
            return 0;
        }
        if (dp[i] == n + 1) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], minSquares((i - (j * j)), dp, n) + 1);
            }
        }
        return dp[i];
    }

    public static int countMinSquares(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp, A+1);
        return minSquares(A,dp,A);
    }

    public static void main(String[] args) {
        int A = 5;
        System.out.println(countMinSquares(A));
    }
}
