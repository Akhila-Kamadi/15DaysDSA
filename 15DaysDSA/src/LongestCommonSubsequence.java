import java.util.Arrays;

public class LongestCommonSubsequence {

    private static int lCS(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0){
            return 0;
        }
        if (dp[i][j] == -1) {
            if (s1.charAt(i) == s2.charAt(j)) {
                dp[i][j] = lCS(s1, s2, i - 1, j - 1, dp) + 1;
            } else {
                dp[i][j] = Math.max(lCS(s1, s2, i, j - 1, dp), lCS(s1, s2, i - 1, j, dp));
            }
        }
        return dp[i][j];
    }

    public static int solve(String A, String B) {
        int n = A.length();
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return lCS(A, B, n - 1, n - 1, dp);
    }

    public static void main(String[] args) {
        String A = "aaaaaa", B = "ababab";
        System.out.println(solve(A, B));
    }
}
