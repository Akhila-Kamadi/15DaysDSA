import java.util.Arrays;

public class Stairs {

    static int nStairs(int i, int[] dp, int mod) {
        if (i <= 2) {
            return i;
        }
        if (dp[i] == -1) {
            dp[i] = nStairs(i - 1, dp, mod) + nStairs(i - 2, dp, mod);
            dp[i] = dp[i] % mod;
        }
        return dp[i];
    }

    public static int climbStairs(int A) {
        int mod = 1000000007;
        int[] dp = new int[A + 1];
        Arrays.fill(dp, -1);
        return nStairs(A, dp, mod);
    }

    public static void main(String[] args) {
        int A = 5;
        System.out.println(climbStairs(A));
    }
}
