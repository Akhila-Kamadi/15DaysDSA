import java.util.Arrays;

public class UniquePathsInAGrid {
    private static int ways(int[][] A, int i, int j, int[][] dp, int n, int m) {
        if (i >= n || j >= m){
            return 0;
        }
        if (A[i][j] == 1){
            return 0;
        }
        if (i == n-1 && j == m-1){
            return 1;
        }
        if (dp[i][j] == -1) {
            dp[i][j] = ways(A, i + 1, j, dp, n, m) + ways(A, i, j + 1, dp, n, m);
        }
        return dp[i][j];
    }

    public static int uniquePathsWithObstacles(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return ways(A, 0, 0, dp, n, m);
    }

    public static void main(String[] args) {
//        int[][] A = {{0, 0, 0},
//                {1, 1, 1},
//                {0, 0, 0}};
        int[][] A = {{0,1}};
        System.out.println(uniquePathsWithObstacles(A));
    }
}
