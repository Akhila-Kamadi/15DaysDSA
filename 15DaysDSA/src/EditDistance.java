import java.util.Arrays;

public class EditDistance {
    private static int getMinDistance(String A, String B, int i, int j, int[][] dp) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] == -1) {
            if (A.charAt(i) == B.charAt(j)) {
                dp[i][j] = getMinDistance(A, B, i - 1, j - 1, dp);
            } else {
                int delete = getMinDistance(A, B, i - 1, j, dp);
                int replace = getMinDistance(A, B, i - 1, j - 1, dp);
                int insert = getMinDistance(A, B, i, j - 1, dp);
                dp[i][j] = 1 + Math.min(delete, Math.min(replace, insert));
            }
        }
        return dp[i][j];
    }

    public static int minDistance(String A, String B) {
        int n = A.length(), m = B.length();
        int[][] dp = new int[n][m];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return getMinDistance(A, B, n - 1, m - 1, dp);
    }

    public static void main(String[] args) {
        String A = "Anshuman", B = "Antihuman";
//        String A = "feh", B = "aekl";
        System.out.println(minDistance(A, B));
    }
}
